package slzfood.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoInput {

    @Valid
    @NotNull
    private RestauranteIdInput restaurante;

    @Valid
    @NotNull
    private UsuarioIdInput cliente;

    @Valid
    @NotNull
    private EnderecoInput enderecoEntrega;

    @Valid
    @NotNull
    private List<ItemPedidoInput> itens;

    @Getter
    @Setter
    public static class RestauranteIdInput {

        @NotNull
        private Long id;

    }

    @Getter
    @Setter
    public static class UsuarioIdInput {

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

    @Getter
    @Setter
    public static class ItemPedidoInput {

        @NotNull
        private Long produtoId;

        @NotNull
        @PositiveOrZero
        private Integer quantidade;

        private String observacao;

    }

}
