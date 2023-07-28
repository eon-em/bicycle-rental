package br.ufscar.dc.dsw.JEGBicycles.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.JEGBicycles.dao.LocadoraDAO;
import br.ufscar.dc.dsw.JEGBicycles.dao.UsuarioDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;

@Component
public class UniqueEMAILValidator implements ConstraintValidator<UniqueEMAIL, String> {

	@Autowired
	private LocadoraDAO dao;
	private UsuarioDAO daoU;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (dao != null || daoU != null) {
			Locadora locadora = dao.findByemail(email);
			return locadora == null;
		} else {
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência
			return true;
		}

	}
	
}