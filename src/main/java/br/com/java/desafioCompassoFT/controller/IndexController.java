package br.com.java.desafioCompassoFT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.errors.BadRequest;
import br.com.java.desafioCompassoFT.errors.NotFoundException;
import br.com.java.desafioCompassoFT.model.IndexModel;
import br.com.java.desafioCompassoFT.service.CidadeService;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Controller
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

	@RequestMapping(value = "/procurarCidade", method = RequestMethod.GET)
	public ModelAndView procurarCidade(Cidade cidade, @RequestParam(defaultValue = "") String nomeCidade) {

		ModelAndView mv = new ModelAndView("/procurar/procurarCidade");
		mv.addObject("cidade", cidadeService.findByNomeCidadeContainingIgnoreCase(nomeCidade));

		return mv;
	}

	@RequestMapping(value = "/procurarEstado", method = RequestMethod.GET)
	public ModelAndView procurarEstado(Cidade cidade, @RequestParam(defaultValue = "") String estado) {

		ModelAndView mv = new ModelAndView("/procurar/procurarCidade");
		mv.addObject("cidade", cidadeService.findByEstadoContainingIgnoreCase(estado));

		return mv;
	}

	@RequestMapping(value = "/procurarCliente", method = RequestMethod.GET)
	public ModelAndView procurarCliente(Cliente cliente, @RequestParam(defaultValue = "") String nomeCliente) {

		ModelAndView mv = new ModelAndView("/procurar/procurarCliente");
		mv.addObject("cliente", clienteService.findByNomeClienteContainingIgnoreCase(nomeCliente));

		return mv;
	}

	@RequestMapping(value = "/procurarId", method = RequestMethod.GET)
	public ModelAndView procurarId(@RequestParam(defaultValue = "") String id) {

		ModelAndView mv = new ModelAndView("/procurar/procurarCliente");

		Cliente cliente = new Cliente();
		if (id.matches("[0-9]*")) {
			cliente = this.clienteService.findById(Long.parseLong(id));
			if (id.equals(null)) {
				throw new NotFoundException("ID não consta no banco de dados");
			}
			mv.addObject("cliente", cliente);
			return mv;
		} else {
			throw new BadRequest("O ID deve ser um número");
		}
	}
}
