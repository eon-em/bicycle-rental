package dsw.JEGBikes.service.spec;

import java.util.List;

import dsw.JEGBikes.domain.Locadora;

public interface ILocadoraService {
	Locadora buscarPorId(Long id);
	
	List<Locadora> buscarTodos();
	
	void salvar(Locadora locadora);
	
	void excluir(Long id);
	
	Locadora buscarPorEmail(String email);
}
