package dsw.RCVeiculos.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsw.RCVeiculos.dao.LojaDAO;
import dsw.RCVeiculos.domain.Loja;
import dsw.RCVeiculos.service.spec.ILojaService;

@Service
@Transactional(readOnly = false)
public class LojaService implements ILojaService{
	@Autowired
	LojaDAO dao;
	
	public void salvar(Loja loja) {
		dao.save(loja);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Loja buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true)
	public Loja buscarPorEmail(String email) {
		return dao.findByemail(email);
	}

	@Transactional(readOnly = true)
	public List<Loja> buscarTodos() {
		return dao.findAll();
	}
}
