package dsw.JEGBikes.service.spec;

import java.util.List;

import dsw.JEGBikes.domain.Bicicleta;

public interface IBicicletaService {
	Bicicleta buscarPorId(Long id);
	
	List<Bicicleta> buscarTodos();
	
	void salvar(Bicicleta bicicleta);
	
	void excluir(Long id);
	
	List<Bicicleta> buscaPorLocadora(long id);

	List<Bicicleta> buscaPorCliente(long id);
}
