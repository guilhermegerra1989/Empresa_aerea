package br.com.guilherme.lemes.core.domain.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.guilherme.lemes.core.domain.constraints.impl.IpV4Validator;

@Documented
@Constraint(validatedBy = IpV4Validator.class)
@Target(value = { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IpV4 {
	String message() default "{br.com.fotosensores.ftsradar.model.constraints.IpV4.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
