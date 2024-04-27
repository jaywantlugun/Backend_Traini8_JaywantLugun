package com.jaywant.rest.traini8.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailIfPresentValidator.class)
public @interface EmailIfPresent {

	String message() default "Invalid email format";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
