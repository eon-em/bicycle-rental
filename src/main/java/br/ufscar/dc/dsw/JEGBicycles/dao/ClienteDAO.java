package br.ufscar.dc.dsw.JEGBicycles.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.JEGBicycles.domain.Cliente;

@SuppressWarnings("unchecked")
public interface ClienteDAO extends CrudRepository<Cliente, Long>{
	Cliente findById(long id);

	List<Cliente> findAll();
	
	Cliente save(Cliente cliente);

	void deleteById(Long id);

	//@Query("SELECT cliente FROM Cliente cliente WHERE cliente.cpf = :cpf")
	Cliente findBycpf(String cpf);
}
