package br.ufscar.dc.dsw.JEGBicycles.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import br.ufscar.dc.dsw.JEGBicycles.dao.LocadoraDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;

@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

	@Autowired
	private LocadoraDAO dao;

	@Override
	public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
		if (dao != null) {
			Locadora locadora = dao.findBycnpj(CNPJ);
			return locadora == null;
		} else {
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência
			return true;
		}

	}
}