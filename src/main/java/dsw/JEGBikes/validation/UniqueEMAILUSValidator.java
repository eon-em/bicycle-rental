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
public class UniqueEMAILUSValidator implements ConstraintValidator<UniqueEMAILUS, String> {

	@Autowired
	private UsuarioDAO daoU;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (daoU != null || daoU != null) {
			Usuario usuario = daoU.findByemail(email);
			return usuario == null;
		} else {
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência
			return true;
		}

	}
	
}