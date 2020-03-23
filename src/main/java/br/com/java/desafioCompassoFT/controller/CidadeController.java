package br.com.java.desafioCompassoFT.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.service.CidadeService;

@RestController
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
	
	@RequestMapping(value = "/procurarCidade", method = RequestMethod.GET)
	public ModelAndView procurarCidade(Cidade cidade, @RequestParam(defaultValue = "") String nomeCidade) {

		ModelAndView mv = new ModelAndView("/procurar/procurarCidade");
		mv.addObject("cidades", cidadeService.findByNomeCidadeContainingIgnoreCase(nomeCidade));

		return mv;
	}

	@RequestMapping(value = "/procurarEstado", method = RequestMethod.GET)
	public ModelAndView procurarEstado(Cidade cidade, @RequestParam(defaultValue = "") String estado) {

		ModelAndView mv = new ModelAndView("/procurar/procurarCidade");
		mv.addObject("cidades", cidadeService.findByEstadoContainingIgnoreCase(estado));

		return mv;
	}
}
