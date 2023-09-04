package dsw.JEGBikes.validation;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import dsw.JEGBikes.dao.BicicletaDAO;
import dsw.JEGBikes.domain.Bicicleta;

@Component
public class UniqueDateTimeValidator implements ConstraintValidator<UniqueDateTime, LocalDateTime> {

	@Autowired
	private BicicletaDAO dao;

	@Override
	public boolean isValid(LocalDateTime dataLocacao, ConstraintValidatorContext context) {
		if (dao != null) {
			Bicicleta bicicleta = dao.findByDataLocacao(dataLocacao);
			return bicicleta == null;
		} else {
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência
			return true;
		}

	}
}