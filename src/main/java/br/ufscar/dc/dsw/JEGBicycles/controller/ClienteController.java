package br.ufscar.dc.dsw.JEGBicycles.controller;

import javax.validation.Valid;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.JEGBicycles.domain.Cliente;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/")
    	public String index(Model model, Locale locale) {
        	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, locale);
    	
    		Calendar cal = Calendar.getInstance();
        	model.addAttribute("dateString", dateFormat.format(cal.getTime()));
        	model.addAttribute("date", cal.getTime());
    
        	return "index";
    	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "cliente/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes",service.buscarTodos());
		return "cliente/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cliente/cadastro";
		}

		System.out.println("password = " + cliente.getSenha());
		
		cliente.setSenha(encoder.encode(cliente.getSenha()));
		service.salvar(cliente);
		attr.addFlashAttribute("sucess", "cliente.create.sucess");
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", service.buscarPorId(id));
		return "cliente/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		
		

		System.out.println(cliente.getSenha());
		
		service.salvar(cliente);
		attr.addFlashAttribute("sucess", "cliente.edit.sucess");
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "cliente.delete.sucess");
		return listar(model);
	}
}
