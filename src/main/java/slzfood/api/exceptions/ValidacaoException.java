package slzfood.api.exceptions;

public class ValidacaoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
