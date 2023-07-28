package br.ufscar.dc.dsw.JEGBicycles.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.JEGBicycles.dao.ClienteDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Cliente;
import br.ufscar.dc.dsw.JEGBicycles.service.spec.IClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService{
	@Autowired
	ClienteDAO dao;
	
	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		return dao.findAll();
	}
}