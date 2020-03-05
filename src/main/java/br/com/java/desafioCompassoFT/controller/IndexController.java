package br.com.java.desafioCompassoFT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.service.CidadesService;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Controller
public class IndexController {
	
	@Autowired
	CidadesService cidadesService;
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("index");
		
		List<Cidades> cidades = cidadesService.findAll();
		mv.addObject("cidades", cidades);
		
		List<Cliente> cliente = clienteService.findAll();
		mv.addObject("cliente", cliente);
		
		return mv;
	}
}
