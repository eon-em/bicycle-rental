package dsw.JEGBikes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dsw.JEGBikes.dao.ClienteDAO;
import dsw.JEGBikes.domain.Cliente;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

	@Autowired
	private ClienteDAO dao;

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if (dao != null) {
			Cliente cliente = dao.findBycpf(cpf);
			return cliente == null;
		} else {
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência
			return true;
		}

	}
}
