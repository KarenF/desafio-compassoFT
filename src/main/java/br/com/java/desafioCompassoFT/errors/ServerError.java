package br.com.java.desafioCompassoFT.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerError extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 962237642540822242L;

	public ServerError(String erro) {
        super(erro);
    }
}