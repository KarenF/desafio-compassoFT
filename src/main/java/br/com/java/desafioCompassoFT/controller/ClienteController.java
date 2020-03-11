package br.com.java.desafioCompassoFT.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.service.CidadesService;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CidadesService cidadesService;
	
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/cadastrar/cadastrarCliente");
		mv.addObject("cidades", cidadesService.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) throws Exception {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCliente";
		}

		String idade = clienteService.findByIdade(cliente.getDataNascimento());
		cliente.setIdade(idade);
		clienteService.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso");
		return "redirect:/cadastrarCliente";
	}

	@RequestMapping(value = "/atualizarCliente/{idCliente}", method = RequestMethod.GET)
	public ModelAndView atualizarCliente(@PathVariable(name = "idCliente") Long idCliente) {
		Cliente cliente = clienteService.findByIdCliente(idCliente);
		ModelAndView mv = new ModelAndView("atualizarCliente");
		mv.addObject("cliente", cliente);

		return mv;
	}

	@Transactional
	@RequestMapping(value = "/atualizarCliente/{idCliente}", method = RequestMethod.POST)
	public String atualizarClientePost(@PathVariable("idCliente") Long idCliente, @Valid Cliente cliente,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/atualizarCliente/{idCliente}";
		}

		clienteService.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente atualizado com sucesso");
		return "redirect:/";
	}
	
	@RequestMapping("/deletarCliente")
	public String deletarCliente(Long idCliente) {
		Cliente cliente = clienteService.findByIdCliente(idCliente);
		clienteService.delete(cliente);

		return "redirect:/";
	}
}
