package slzfood.api.openapi;

public final class ApiResponses {

    private ApiResponses() {}

    public static final String BAD_REQUEST = "Requisição inválida (erro do cliente)";
    public static final String UNAUTHORIZED = "Sem autorização para acessar este recurso";
    public static final String FORBIDDEN = "Acesso negado";
    public static final String NOT_FOUND = "Recurso não encontrado";
    public static final String INTERNAL_SERVER_ERROR = "Erro interno no servidor";
}
