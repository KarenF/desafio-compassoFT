package br.com.java.desafioCompassoFT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.errors.BadRequest;
import br.com.java.desafioCompassoFT.errors.NotFoundException;
import br.com.java.desafioCompassoFT.model.IndexModel;
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
		List<Cliente> clientes = clienteService.findAll();

		IndexModel model = new IndexModel();

		model.setCidades(cidades);
		model.setClientes(clientes);
		mv.addObject("model", model);

		return mv;
	}

	@RequestMapping(value = "/buscarCidades", method = RequestMethod.GET)
	public ModelAndView buscarCidades(Cidades cidades, @RequestParam(defaultValue = "") String nomeCidade) {

		ModelAndView mv = new ModelAndView("/buscar/buscarCidades");
		mv.addObject("cidades", cidadesService.findByNomeCidade(nomeCidade));

		return mv;
	}

	@RequestMapping(value = "/buscarEstado", method = RequestMethod.GET)
	public ModelAndView buscarEstado(Cidades cidades, @RequestParam(defaultValue = "") String estado) {

		ModelAndView mv = new ModelAndView("/buscar/buscarCidades");
		mv.addObject("cidades", cidadesService.findByEstado(estado));

		return mv;
	}

	@RequestMapping(value = "/buscarCliente", method = RequestMethod.GET)
	public ModelAndView buscarCliente(Cliente cliente, @RequestParam(defaultValue = "") String nomeCliente) {

		ModelAndView mv = new ModelAndView("/buscar/buscarCliente");
		mv.addObject("cliente", clienteService.findByNomeClienteLike(nomeCliente));

		return mv;
	}

	@RequestMapping(value = "/buscarIdCliente", method = RequestMethod.GET)
	public ModelAndView buscarIdCliente(@RequestParam(defaultValue = "") String idCliente) {

		ModelAndView mv = new ModelAndView("/buscar/buscarCliente");

		Cliente cliente = new Cliente();
		if (idCliente.matches("[0-9]*")) {
			cliente = this.clienteService.findByIdCliente(Long.parseLong(idCliente));
			if (idCliente.equals(null)) {
				throw new NotFoundException("ID não consta no banco de dados");
			}
			mv.addObject("cliente", cliente);
			return mv;
		} else {
			throw new BadRequest("O ID deve ser um número");
		}
	}
}
