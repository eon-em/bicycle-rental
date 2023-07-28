package br.ufscar.dc.dsw.JEGBicycles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.JEGBicycles.domain.Usuario;

@SuppressWarnings("unchecked")
public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	Usuario findById(long id);

	List<Usuario> findAll();
	
	Usuario save(Usuario u);
	
	void deleteById(Long id);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario getUserByUsername(@Param("email") String email);

    Usuario findByemail(String email);
}