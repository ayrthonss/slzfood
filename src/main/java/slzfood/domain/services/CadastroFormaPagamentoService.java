package slzfood.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import slzfood.api.exceptions.EntidadeNaoEncontradaException;
import slzfood.domain.model.FormaPagamento;
import slzfood.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento buscarOuFalhar(Long formaPagamentoId) {
        return formaPagamentoRepository.findById(formaPagamentoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Forma de pagamento não encontrada"));
    }

    @Transactional
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    @Transactional
    public void excluir(Long formaPagamentoId) {
        formaPagamentoRepository.deleteById(formaPagamentoId);
    }
}
