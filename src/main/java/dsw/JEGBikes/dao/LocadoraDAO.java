package dsw.JEGBikes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dsw.JEGBikes.domain.Locadora;

@SuppressWarnings("unchecked")
public interface LocadoraDAO extends CrudRepository<Locadora, Long>{
	
	Locadora findById(long id);
	
	List<Locadora> findAll();
	
	Locadora save(Locadora l);
	
	void deleteById(Long id);
	
	Locadora findBycnpj(String cnpj);
	
	Locadora findByemail(String email);
	
}
