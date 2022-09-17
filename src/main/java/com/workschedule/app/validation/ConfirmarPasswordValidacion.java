package com.workschedule.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.workschedule.app.models.view.Password;

public class ConfirmarPasswordValidacion implements ConstraintValidator<ConfirmarPassword, Password> {
	
	@Override
	public void initialize(ConfirmarPassword password) {}
	
	@Override
	public boolean isValid(Password password, ConstraintValidatorContext context) {
		
		String plainPassword = password.getPassword();
		String repeatPassword = password.getConfirmPassword();
		
		if(plainPassword == null || !plainPassword.equals(repeatPassword)) {
			System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + plainPassword);
			System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + repeatPassword);
			return false;
		}
		System.err.println("bbbbbbbbbbbbbbbbbbbb");
		return true;
	}
	
}
