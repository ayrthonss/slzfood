package slzfood.api.exceptions;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormaPagamentoInput {

    @NotBlank
    private String descricao;

}
