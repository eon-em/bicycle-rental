package br.ufscar.dc.dsw.JEGBicycles.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.JEGBicycles.dao.LocadoraDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.ILocadoraService;

@Service
@Transactional(readOnly = false)
public class LocadoraService implements ILocadoraService{
	@Autowired
	LocadoraDAO dao;
	
	public void salvar(Locadora loja) {
		dao.save(loja);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Locadora buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true)
	public Locadora buscarPorEmail(String email) {
		return dao.findByemail(email);
	}

	@Transactional(readOnly = true)
	public List<Locadora> buscarTodos() {
		return dao.findAll();
	}
}
