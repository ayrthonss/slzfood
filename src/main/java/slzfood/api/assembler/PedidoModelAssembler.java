package slzfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import slzfood.domain.model.Pedido;

@Component
public class PedidoModelAssembler {

    private final ModelMapper modelMapper;

    public PedidoModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Pedido toModel(Pedido pedido) {
        return modelMapper.map(pedido, Pedido.class);
    }

    public List<Pedido> toCollectionModel(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
