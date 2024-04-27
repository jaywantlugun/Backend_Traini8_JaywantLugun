package com.jaywant.rest.traini8.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailIfPresentValidator implements ConstraintValidator<EmailIfPresent, String> {

	@Override
	public void initialize(EmailIfPresent constraintAnnotation) {

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email == null || email.length() == 0) { // if email is not present return true
			return true;
		}

		// checking whether email is valid
		return email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

}
