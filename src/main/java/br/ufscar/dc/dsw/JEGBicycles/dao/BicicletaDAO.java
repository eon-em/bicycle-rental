package br.ufscar.dc.dsw.JEGBicycles.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.JEGBicycles.domain.Bicicleta;

@SuppressWarnings("unchecked")
public interface BicicletaDAO extends CrudRepository<Bicicleta, Long>{
	
	Bicicleta findById(long id);
	
	List<Bicicleta> findAll();
	
	Bicicleta save(Bicicleta c);
	
	void deleteById(Long id);
}
