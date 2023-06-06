package slzfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.api.model.input.GrupoInput;
import slzfood.domain.model.Grupo;

@Component
public class GrupoInputDisassembler {

    private final ModelMapper modelMapper;

    public GrupoInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Grupo toEntity(GrupoInput grupoInput) {
        return modelMapper.map(grupoInput, Grupo.class);
    }

    public void copyToDomainObject(GrupoInput grupoInput, Grupo grupo) {
        modelMapper.map(grupoInput, grupo);
    }

}
