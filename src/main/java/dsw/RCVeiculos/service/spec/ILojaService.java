package dsw.RCVeiculos.service.spec;

import java.util.List;

import dsw.RCVeiculos.domain.Loja;

public interface ILojaService {
	Loja buscarPorId(Long id);
	
	List<Loja> buscarTodos();
	
	void salvar(Loja loja);
	
	void excluir(Long id);
	
	Loja buscarPorEmail(String email);
}
