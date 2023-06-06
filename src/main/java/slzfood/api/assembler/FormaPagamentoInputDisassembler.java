package slzfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.api.model.input.FormaPagamentoInput;
import slzfood.domain.model.FormaPagamento;

@Component
public class FormaPagamentoInputDisassembler {

    private final ModelMapper modelMapper;

    public FormaPagamentoInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FormaPagamento toEntity(FormaPagamentoInput formaPagamentoInput) {
        return modelMapper.map(formaPagamentoInput, FormaPagamento.class);
    }

    public void copyToDomainObject(FormaPagamentoInput formaPagamentoInput, FormaPagamento formaPagamento) {
        modelMapper.map(formaPagamentoInput, formaPagamento);
    }

}
