package slzfood.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slzfood.domain.model.FormaPagamento;
import slzfood.domain.repository.FormaPagamentoRepository;
import slzfood.domain.services.CadastroFormaPagamentoService;

import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamentoService;

    @GetMapping
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.findAll();
    }

    @GetMapping("/{formaPagamentoId}")
    public FormaPagamento buscar(@PathVariable Long formaPagamentoId) {
        return cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
        return cadastroFormaPagamentoService.salvar(formaPagamento);
    }

    @PutMapping("/{formaPagamentoId}")
    public FormaPagamento atualizar(@PathVariable Long formaPagamentoId, @RequestBody FormaPagamento formaPagamento) {
        FormaPagamento formaPagamentoAtual = cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);
        BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual, "id");

        return cadastroFormaPagamentoService.salvar(formaPagamentoAtual);
    }

    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long formaPagamentoId) {
        cadastroFormaPagamentoService.excluir(formaPagamentoId);
    }
}
