package slzfood.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import slzfood.domain.exceptions.EntidadeEmUsoException;
import slzfood.domain.exceptions.EstadoNaoEncontradoException;
import slzfood.domain.model.Estado;
import slzfood.domain.repository.EstadoRepository;


@Service
public class CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO = "Estado de código %d não pode ser removido, pois está em uso";

	@Autowired
	private EstadoRepository estadoRepository;
	@Transactional
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	@Transactional
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);

		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(estadoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_ESTADO_EM_USO, estadoId));
		}
	}

	public Estado buscarOuFalhar(Long id) {
		return estadoRepository.findById(id).orElseThrow(() -> new EstadoNaoEncontradoException(id));
	}

}
