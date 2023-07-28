package br.ufscar.dc.dsw.JEGBicycles.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueEMAILUSValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEMAILUS {
    String message() default "Email is already registered";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
