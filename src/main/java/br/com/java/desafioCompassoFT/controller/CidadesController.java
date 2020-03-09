package br.com.java.desafioCompassoFT.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.service.CidadesService;

@Controller
public class CidadesController {

	@Autowired
	private CidadesService cidadesService;

	@RequestMapping(value = "/cadastrarCidades", method = RequestMethod.GET)
	public String cadastrarCidades() {
		return "cadastrarCidades";
	}

	@RequestMapping(value = "/cadastrarCidades", method = RequestMethod.POST)
	public String cadastrarCidadesPost(@Valid Cidades cidades, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCidades";
		}

		cidadesService.save(cidades);
		attributes.addFlashAttribute("mensagem", "Cidade adicionada com sucesso");
		return "redirect:/cadastrarCidades";
	}
}
