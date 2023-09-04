package dsw.JEGBikes.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsw.JEGBikes.dao.LocadoraDAO;
import dsw.JEGBikes.domain.Locadora;
import dsw.JEGBikes.service.spec.ILocadoraService;

@Service
@Transactional(readOnly = false)
public class LocadoraService implements ILocadoraService{
	@Autowired
	LocadoraDAO dao;
	
	public void salvar(Locadora locadora) {
		dao.save(locadora);
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
