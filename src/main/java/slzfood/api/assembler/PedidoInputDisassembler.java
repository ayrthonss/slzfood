package slzfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.api.model.input.PedidoInput;
import slzfood.domain.model.Pedido;

@Component
public class PedidoInputDisassembler {

    private final ModelMapper modelMapper;

    public PedidoInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Pedido toEntity(PedidoInput pedidoInput) {
        return modelMapper.map(pedidoInput, Pedido.class);
    }

    public void copyToDomainObject(PedidoInput pedidoInput, Pedido pedido) {
        modelMapper.map(pedidoInput, pedido);
    }

}
