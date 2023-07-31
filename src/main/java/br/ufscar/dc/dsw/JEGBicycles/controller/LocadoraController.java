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

import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.IBicicletaService;

@Controller
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private ILocadoraService service;
	
	@Autowired
	private IBicicletaService serviceBicicleta;
	
	
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
	public String cadastrar(Locadora locadora) {
		return "locadora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("locadoras", service.buscarTodos());
		return "locadora/lista";
	}
	
	@GetMapping("/listarBicicleta")
	public String listarBicicleta(ModelMap model) {
		model.addAttribute("bicicletas", serviceBicicleta.buscarTodos());
		return "locadora/listaBicicleta";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}
		
		System.out.println("password = " + locadora.getSenha());
		
		locadora.setSenha(encoder.encode(locadora.getSenha()));
		
		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "locadora.create.sucess");
		return "redirect:/locadoras/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("locadora", service.buscarPorId(id));
		return "locadora/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("sucess", "locadora.delete.sucess");
		return "redirect:/locadoras/listar";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "locadora.edit.sucess");
		return "redirect:/locadoras/listar";
	}
	
}
