package slzfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.api.model.input.CidadeInput;
import slzfood.domain.model.Cidade;

@Component
public class CidadeInputDisassembler {

    private final ModelMapper modelMapper;

    public CidadeInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Cidade toEntity(CidadeInput cidadeInput) {
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
        modelMapper.map(cidadeInput, cidade);
    }

}
