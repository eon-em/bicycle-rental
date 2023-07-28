package br.ufscar.dc.dsw.JEGBicycles.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;

public interface ILocadoraService {
	Locadora buscarPorId(Long id);
	
	List<Locadora> buscarTodos();
	
	void salvar(Locadora locadora);
	
	void excluir(Long id);
	
	Locadora buscarPorEmail(String email);
}
