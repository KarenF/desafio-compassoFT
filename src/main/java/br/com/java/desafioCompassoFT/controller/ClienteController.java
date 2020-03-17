package br.com.java.desafioCompassoFT.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
		mv.addObject("cidade", cidadeService.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(ClienteModel clienteModel, BindingResult result, RedirectAttributes attributes) throws Exception {
		
		String str = result.getFieldValue("dataNascimento").toString() + " 00:00";  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		
//		LocalDateTime teste = (LocalDateTime) ; 
//		if (result.hasErrors()) {
//			attributes.addFlashAttribute("mensagem", "Verifique os campos");
//			return "redirect:/cadastrarCliente";
//		}
		
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
		Cidade cidadesalva = cidadeService.save(cidade); 
		
		Cidade cidadeCarregada = cidadeService.findById(cidadesalva.getId()); 
		attributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso");
		return "redirect:/cadastrarCliente";
	}

	@RequestMapping(value = "/atualizarCliente/{id}", method = RequestMethod.GET)
	public ModelAndView atualizarCliente(@PathVariable(name = "id") Long id) {
		Cliente cliente = clienteService.findById(id);
		ModelAndView mv = new ModelAndView("atualizarCliente");
		mv.addObject("cliente", cliente);

		return mv;
	}

	@Transactional
	@RequestMapping(value = "/atualizarCliente/{id}", method = RequestMethod.POST)
	public String atualizarClientePost(@PathVariable("id") Long id, @Valid Cliente cliente,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/atualizarCliente/{id}";
		}

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
	
	@RequestMapping(value = "/clientesInativos", method = RequestMethod.GET)
	public ModelAndView clientesInativos() {
		
		ModelAndView mv = new ModelAndView("/inativos/clientesInativos");
		List<Cliente> clientesInativos = clienteService.findAll();
		mv.addObject("clientes", clientesInativos);
		
		return mv;
	}
}
