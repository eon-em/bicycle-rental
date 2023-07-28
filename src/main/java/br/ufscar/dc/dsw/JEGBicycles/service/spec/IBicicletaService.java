package br.ufscar.dc.dsw.JEGBicycles.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.JEGBicycles.domain.Bicicleta;

public interface IBicicletaService {
	Bicicleta buscarPorId(Long id);
	
	List<Bicicleta> buscarTodos();
	
	void salvar(Bicicleta bicicleta);
	
	void excluir(Long id);
}
