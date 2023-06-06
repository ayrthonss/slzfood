package slzfood.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import slzfood.api.exceptions.EntidadeEmUsoException;
import slzfood.domain.exceptions.PermissaoNaoEncontradaException;
import slzfood.domain.model.Permissao;
import slzfood.domain.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Transactional
	public Permissao salvar(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}

	@Transactional
	public void excluir(Long permissaoId) {
		try {
			permissaoRepository.deleteById(permissaoId);
			permissaoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new PermissaoNaoEncontradaException(permissaoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Permissão de código %d não pode ser removida, pois está em uso", permissaoId));
		}
	}
}
