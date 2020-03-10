package br.com.java.desafioCompassoFT.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8973778964912808815L;

	public BadRequest(String erro) {
        super(erro);
    }
    
    
}