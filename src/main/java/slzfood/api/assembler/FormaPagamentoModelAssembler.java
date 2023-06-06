package slzfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.domain.model.FormaPagamento;

@Component
public class FormaPagamentoModelAssembler {

    private final ModelMapper modelMapper;

    public FormaPagamentoModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FormaPagamento toModel(FormaPagamento formaPagamento) {
        return modelMapper.map(formaPagamento, FormaPagamento.class);
    }

    public List<FormaPagamento> toCollectionModel(List<FormaPagamento> formasPagamento) {
        return formasPagamento.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
