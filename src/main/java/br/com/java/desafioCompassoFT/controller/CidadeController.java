package br.com.java.desafioCompassoFT.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.service.CidadeService;

@Controller
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(value = "/cadastrarCidade", method = RequestMethod.GET)
	public String cadastrarCidade() {
		return "cadastrar/cadastrarCidade";
	}

	@RequestMapping(value = "/cadastrarCidade", method = RequestMethod.POST)
	public String cadastrarCidadePost(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCidade";
		}

		cidadeService.save(cidade);
		attributes.addFlashAttribute("mensagem", "Cidade adicionada com sucesso");
		return "redirect:/cadastrarCidade";
	}
}
