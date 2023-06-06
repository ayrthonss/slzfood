package slzfood.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteInput {

    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private BigDecimal taxaFrete;

    @Valid
    @NotNull
    private CozinhaIdInput cozinha;

    @Valid
    @NotNull
    private EnderecoInput endereco;

    @Getter
    @Setter
    public static class CozinhaIdInput {

        @NotNull
        private Long id;

    }

    @Getter
    @Setter
    public static class EnderecoInput {

        @NotBlank
        private String cep;

        @NotBlank
        private String logradouro;

        @NotBlank
        private String numero;

        private String complemento;

        @NotBlank
        private String bairro;

        @Valid
        @NotNull
        private CidadeIdInput cidade;

    }

    @Getter
    @Setter
    public static class CidadeIdInput {

        @NotNull
        private Long id;

    }

}
