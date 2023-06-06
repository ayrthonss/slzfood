package slzfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.api.model.input.CozinhaInput;
import slzfood.domain.model.Cozinha;

@Component
public class CozinhaInputDisassembler {

    private final ModelMapper modelMapper;

    public CozinhaInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Cozinha toEntity(CozinhaInput cozinhaInput) {
        return modelMapper.map(cozinhaInput, Cozinha.class);
    }

    public void copyToDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha) {
        modelMapper.map(cozinhaInput, cozinha);
    }

}
