package br.com.java.desafioCompassoFT.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.model.ClienteModel;
import br.com.java.desafioCompassoFT.service.CidadeService;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/cadastrar/cadastrarCliente");
		mv.addObject("cidades", cidadeService.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(ClienteModel clienteModel, BindingResult result, RedirectAttributes attributes) throws Exception {

		String str = result.getFieldValue("dataNascimento").toString() + " 00:00";  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		
		Cidade cidade = cidadeService.findById(clienteModel.getIdCidade());
		Cliente cliente = new Cliente();
		
		cliente.setNomeCliente(clienteModel.getNomeCliente());
		cliente.setGenero(clienteModel.getGenero());
		cliente.setDataNascimento(dateTime);
		cliente.setAtivo(true);
		
		String idade = clienteService.findByIdade(dateTime);
		cliente.setIdade(idade);
		
		Cliente salvo = clienteService.save(cliente);
		cidade.getCliente().add(salvo); 
		cidadeService.save(cidade); 
		
		attributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso");
		return "redirect:/cadastrarCliente";
	}

	@RequestMapping(value = "/atualizarCliente/{id}", method = RequestMethod.GET)
	public ModelAndView atualizarCliente(@PathVariable(name = "id") Long id) {
		Cliente cliente = clienteService.findById(id);
		ModelAndView mv = new ModelAndView("atualizarCliente");
		mv.addObject("clientes", cliente);

		return mv;
	}

	@Transactional
	@RequestMapping(value = "/atualizarCliente/{id}", method = RequestMethod.POST)
	public String atualizarClientePost(@PathVariable("id") Long id, @Valid Cliente cliente,
			BindingResult result, RedirectAttributes attributes) {

		clienteService.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente atualizado com sucesso");
		return "redirect:/";
	}
	
	@RequestMapping("/deletarCliente")
	public String deletarCliente(Long id) {
		Cliente cliente = clienteService.findById(id);
		clienteService.delete(cliente);

		return "redirect:/";
	}
}
