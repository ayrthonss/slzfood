package slzfood.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slzfood.domain.model.Pedido;
import slzfood.domain.repository.PedidoRepository;
import slzfood.domain.services.EmissaoPedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmissaoPedidoService emissaoPedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{pedidoId}")
    public Pedido buscar(@PathVariable Long pedidoId) {
        return emissaoPedidoService.buscarOuFalhar(pedidoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar(@RequestBody Pedido pedido) {
        return emissaoPedidoService.emitir(pedido);
    }

    @PutMapping("/{pedidoId}")
    public Pedido atualizar(@PathVariable Long pedidoId, @RequestBody Pedido pedido) {
        Pedido pedidoAtual = emissaoPedidoService.buscarOuFalhar(pedidoId);
        BeanUtils.copyProperties(pedido, pedidoAtual, "id", "dataCriacao", "restaurante", "cliente");

        return emissaoPedidoService.emitir(pedidoAtual);
    }

    @DeleteMapping("/{pedidoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long pedidoId) {
        emissaoPedidoService.cancelar(pedidoId);
    }
}
