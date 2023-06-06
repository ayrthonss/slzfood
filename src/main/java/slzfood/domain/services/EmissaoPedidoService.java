package slzfood.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import slzfood.api.exceptions.EntidadeNaoEncontradaException;
import slzfood.domain.model.Pedido;
import slzfood.domain.repository.PedidoRepository;

@Service
public class EmissaoPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarOuFalhar(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Pedido não encontrado"));
    }

    @Transactional
    public Pedido emitir(Pedido pedido) {
        // Lógica para emissão do pedido
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void cancelar(Long pedidoId) {
        Pedido pedido = buscarOuFalhar(pedidoId);
        // Lógica para cancelamento do pedido
        pedidoRepository.delete(pedido);
    }
}
