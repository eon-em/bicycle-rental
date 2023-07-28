package br.ufscar.dc.dsw.JEGBicycles.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.JEGBicycles.dao.BicicletaDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Bicicleta;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.IBicicletaService;

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
}
