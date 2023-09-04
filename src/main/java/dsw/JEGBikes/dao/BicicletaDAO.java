package dsw.JEGBikes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dsw.JEGBikes.domain.Bicicleta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@SuppressWarnings("unchecked")
public interface BicicletaDAO extends CrudRepository<Bicicleta, Long>{
	
	Bicicleta findById(long id);
	
	List<Bicicleta> findAll();
	
	Bicicleta save(Bicicleta b);
	
	void deleteById(Long id);
	
	@Query("Select b FROM Bicicleta b LEFT JOIN  Locadora l  ON b.locadora = l.id WHERE l.id =:id")
	List<Bicicleta> findByLocadoraId(@Param("id") long id);

	@Query("Select b FROM Bicicleta b WHERE b.modelo =:modelo")
	List<Bicicleta> findByModelo(@Param("modelo") String modelo);
}
