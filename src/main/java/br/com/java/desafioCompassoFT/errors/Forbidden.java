package br.com.java.desafioCompassoFT.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class Forbidden extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 973977149183048212L;

	public Forbidden(String erro) {
		super(erro);
	}

}