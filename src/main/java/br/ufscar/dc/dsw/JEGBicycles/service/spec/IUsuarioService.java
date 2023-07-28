package br.ufscar.dc.dsw.JEGBicycles.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.JEGBicycles.domain.Usuario;

public interface IUsuarioService {
	Usuario buscarPorId(Long id);
	
	List<Usuario> buscarTodos();
	
	void salvar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscaUsuario(String email);
	
	Usuario buscarPorEmail(String email);
}
