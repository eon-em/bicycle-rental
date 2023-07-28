package br.ufscar.dc.dsw.JEGBicycles.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.JEGBicycles.dao.UsuarioDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Usuario;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.IUsuarioService;

@Service
@Transactional(readOnly = false)
public class UsuarioService implements IUsuarioService {
	@Autowired
	UsuarioDAO dao;
	
	public void salvar(Usuario usuario) {
		dao.save(usuario);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}
	
	public Usuario buscaUsuario(String email) {
		return dao.getUserByUsername(email);
	}
	
	@Transactional(readOnly = true)
	public Usuario buscarPorEmail(String email) {
		return dao.findByemail(email);
	}
}
