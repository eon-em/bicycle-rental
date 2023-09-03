package dsw.RCVeiculos.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dsw.RCVeiculos.domain.Loja;

@SuppressWarnings("unchecked")
public interface LojaDAO extends CrudRepository<Loja, Long>{
	
	Loja findById(long id);
	
	List<Loja> findAll();
	
	Loja save(Loja l);
	
	void deleteById(Long id);
	
	Loja findBycnpj(String cnpj);
	
	Loja findByemail(String email);
	
}
