package dsw.JEGBikes.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsw.JEGBikes.dao.BicicletaDAO;
import dsw.JEGBikes.domain.Bicicleta;
import dsw.JEGBikes.service.spec.IBicicletaService;

@Service
@Transactional(readOnly = false)
public class BicicletaService implements IBicicletaService{
	@Autowired
	BicicletaDAO dao;
	
	public void salvar(Bicicleta bicicleta) {
		dao.save(bicicleta);
	}
	
	public void excluir(Long id) {
		dao.deleteById(id);
	}
	

	@Transactional(readOnly = true)
	public Bicicleta buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Bicicleta> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Bicicleta> buscaPorLocadora(long id) {
		return dao.findByLocadoraId(id);
	}

	@Transactional(readOnly = true)
	public List<Bicicleta> buscaPorModelo(String modelo) {
		return dao.findByModelo(modelo);
	}
}
