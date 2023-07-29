package br.ufscar.dc.dsw.JEGBicycles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.JEGBicycles.domain.Usuario;
import br.ufscar.dc.dsw.JEGBicycles.security.UsuarioDetails;
import br.ufscar.dc.dsw.JEGBicycles.domain.Bicicleta;
import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.IBicicletaService;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.ILocadoraService;

@Controller
@RequestMapping("/bicicletas")
public class BicicletaController {
	@Autowired
	private IBicicletaService bicicletaService;

	@Autowired
	private ILocadoraService locadoraService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Bicicleta bicicleta, ModelMap model) {
		bicicleta.setLocadora(locadoraService.buscarPorEmail(getUsuario().getEmail()));
		model.addAttribute("bicicleta", bicicleta);
		return "bicicleta/cadastro";
	}
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("bicicletas", bicicletaService.buscarTodos());
		return "bicicleta/lista";
	}

	@GetMapping("/listarLocadora")
	public String listarLocadora(ModelMap model) {
		model.addAttribute("locadoras", listaLocadoras());
		return "bicicleta/listaLocadora";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Bicicleta bicicleta, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "bicicleta/cadastro";
		}
		
		bicicleta.setLocadora(locadoraService.buscarPorEmail(this.getUsuario().getEmail())); 

		bicicletaService.salvar(bicicleta);
		attr.addFlashAttribute("sucess", "bicicleta.create.sucess");
		if(this.getUsuario().getPapel().equals("LOCADORA")) {
			return "redirect:/locadoras/listarBicicleta";
		}
		return "redirect:/bicicletas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		Bicicleta bicicleta = bicicletaService.buscarPorId(id);
		model.addAttribute("bicicleta", bicicleta);
		model.addAttribute("locadora", bicicleta.getLocadora());
		return "bicicleta/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Bicicleta bicicleta, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "bicicleta/cadastro";
		}
																																																														
		bicicletaService.salvar(bicicleta);
		attr.addFlashAttribute("sucess", "bicicleta.edit.sucess");
		if(this.getUsuario().getPapel().equals("LOCADORA")) {
			return "redirect:/locadoras/listarBicicleta";
		}
		return "redirect:/bicicletas/listar";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		bicicletaService.excluir(id);
		attr.addFlashAttribute("sucess", "bicicleta.delete.sucess");
		if(this.getUsuario().getPapel().equals("LOCADORA")) {
			return "redirect:/locadoras/listarBicicleta";
		}
		return "redirect:/bicicletas/listar";
	}

	@ModelAttribute("locadoras")
	public List<Locadora> listaLocadoras() {
		return locadoraService.buscarTodos();
	}
}