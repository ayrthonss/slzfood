package slzfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.domain.model.Restaurante;

@Component
public class RestauranteModelAssembler {

    private final ModelMapper modelMapper;

    public RestauranteModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Restaurante toModel(Restaurante restaurante) {
        return modelMapper.map(restaurante, Restaurante.class);
    }

    public List<Restaurante> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
