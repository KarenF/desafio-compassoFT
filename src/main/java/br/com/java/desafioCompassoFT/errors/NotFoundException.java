package br.com.java.desafioCompassoFT.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1930870472959278716L;

	public NotFoundException(String erro) {
		super(erro); 
	}
}
