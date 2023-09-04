package dsw.JEGBikes.service.spec;

import java.util.List;

import dsw.JEGBikes.domain.Usuario;

public interface IUsuarioService {
	Usuario buscarPorId(Long id);
	
	List<Usuario> buscarTodos();
	
	void salvar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscaUsuario(String email);
	
	Usuario buscarPorEmail(String email);
}
