package slzfood.api.slz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException(String message) {
        super(message);
    }
}