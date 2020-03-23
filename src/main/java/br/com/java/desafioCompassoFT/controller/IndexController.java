package br.com.java.desafioCompassoFT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.errors.BadRequest;
import br.com.java.desafioCompassoFT.errors.NotFoundException;
import br.com.java.desafioCompassoFT.model.IndexModel;
import br.com.java.desafioCompassoFT.service.CidadeService;
import br.com.java.desafioCompassoFT.service.ClienteService;

@RestController
public class IndexController {

	@Autowired
	CidadeService cidadeService;

	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("index");

		List<Cidade> cidades = cidadeService.findAll();
		List<Cliente> clientes = clienteService.findAll();

		IndexModel model = new IndexModel();

		model.setCidades(cidades);
		model.setClientes(clientes);
		mv.addObject("model", model);

		return mv;
	}
}
