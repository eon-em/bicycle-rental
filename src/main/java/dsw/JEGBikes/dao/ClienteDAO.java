package dsw.JEGBikes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dsw.JEGBikes.domain.Cliente;

@SuppressWarnings("unchecked")
public interface ClienteDAO extends CrudRepository<Cliente, Long>{
	Cliente findById(long id);

	List<Cliente> findAll();
	
	Cliente save(Cliente cliente);

	void deleteById(Long id);

	//@Query("SELECT cliente FROM Cliente cliente WHERE cliente.cpf = :cpf")
	Cliente findBycpf(String cpf);
}
