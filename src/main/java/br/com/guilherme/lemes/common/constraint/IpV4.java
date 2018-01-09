package br.com.guilherme.lemes.common.constraint;

import br.com.guilherme.lemes.common.constraint.impl.IpV4Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = IpV4Validator.class)
@Target(value = {METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IpV4 {
    String message() default "{IpV4.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
