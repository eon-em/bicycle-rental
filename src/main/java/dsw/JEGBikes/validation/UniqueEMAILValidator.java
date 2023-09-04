package dsw.JEGBikes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dsw.JEGBikes.dao.ClienteDAO;
import dsw.JEGBikes.dao.LocadoraDAO;
import dsw.JEGBikes.dao.UsuarioDAO;
import dsw.JEGBikes.domain.Cliente;
import dsw.JEGBikes.domain.Locadora;
import dsw.JEGBikes.domain.Usuario;

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