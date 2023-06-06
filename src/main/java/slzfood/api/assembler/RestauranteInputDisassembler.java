package slzfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import slzfood.api.model.input.RestauranteInput;
import slzfood.domain.model.Restaurante;

@Component
public class RestauranteInputDisassembler {

    private final ModelMapper modelMapper;

    public RestauranteInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Restaurante toEntity(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
        modelMapper.map(restauranteInput, restaurante);
    }

}
