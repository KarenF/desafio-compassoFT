package br.com.java.desafioCompassoFT.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContent extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5245454903371035544L;

	public NoContent(String erro) {
		super(erro);
	}
}
