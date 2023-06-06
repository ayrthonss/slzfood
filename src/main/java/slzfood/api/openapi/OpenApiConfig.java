package slzfood.api.openapi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de SLZFood")
                .description("API para gerenciamento de restaurantes e pedidos")
                .version("1.0.0")
            );
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
