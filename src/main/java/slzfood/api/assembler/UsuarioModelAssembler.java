package slzfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import slzfood.domain.model.Usuario;

@Component
public class UsuarioModelAssembler {

    private final ModelMapper modelMapper;

    public UsuarioModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Usuario toModel(Usuario usuario) {
        return modelMapper.map(usuario, Usuario.class);
    }

    public List<Usuario> toCollectionModel(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
