package dsw.JEGBikes.service.spec;

import java.util.List;

import dsw.JEGBikes.domain.Cliente;

public interface IClienteService {
	Cliente buscarPorId(Long id);
	
	List<Cliente> buscarTodos();
	
	void salvar(Cliente cliente);
	
	void excluir(Long id);
}
