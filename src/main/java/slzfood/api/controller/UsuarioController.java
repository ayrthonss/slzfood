package slzfood.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import slzfood.domain.exceptions.EntidadeNaoEncontradaException;
import slzfood.domain.exceptions.NegocioException;
import slzfood.domain.model.Usuario;
import slzfood.domain.repository.UsuarioRepository;
import slzfood.domain.services.CadastroUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{usuarioId}")
    public Usuario buscar(@PathVariable Long usuarioId) {
        return cadastroUsuarioService.buscarOuFalhar(usuarioId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody Usuario usuario) {
        try {
            return cadastroUsuarioService.salvar(usuario);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("/{usuarioId}")
    public Usuario atualizar(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
        Usuario usuarioAtual = cadastroUsuarioService.buscarOuFalhar(usuarioId);
        BeanUtils.copyProperties(usuario, usuarioAtual, "id", "dataCadastro");

        try {
            return cadastroUsuarioService.salvar(usuarioAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long usuarioId) {
        cadastroUsuarioService.excluir(usuarioId);
    }
}
