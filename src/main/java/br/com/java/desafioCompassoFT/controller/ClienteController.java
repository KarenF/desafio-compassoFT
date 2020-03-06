package br.com.java.desafioCompassoFT.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String form() {
		return "cadastrarCliente";
	}
	
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCliente";
		}

		clienteService.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente adicionada com sucesso");
		return "redirect:/cadastrarCliente";
	}
}
