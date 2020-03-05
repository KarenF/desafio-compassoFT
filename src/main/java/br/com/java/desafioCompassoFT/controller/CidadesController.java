package br.com.java.desafioCompassoFT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.java.desafioCompassoFT.service.CidadesService;

@Controller
public class CidadesController {

	@Autowired
	private CidadesService cidadesService;
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public String form() {
		return "index";
	}
}
