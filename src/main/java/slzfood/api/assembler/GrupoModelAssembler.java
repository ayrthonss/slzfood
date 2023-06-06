package slzfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.domain.model.Grupo;

@Component
public class GrupoModelAssembler {

    private final ModelMapper modelMapper;

    public GrupoModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Grupo toModel(Grupo grupo) {
        return modelMapper.map(grupo, Grupo.class);
    }

    public List<Grupo> toCollectionModel(List<Grupo> grupos) {
        return grupos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
