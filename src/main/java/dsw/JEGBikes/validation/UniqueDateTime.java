package dsw.JEGBikes.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueDateTimeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueDateTime {
    String message() default "Location date+time is already registered";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}