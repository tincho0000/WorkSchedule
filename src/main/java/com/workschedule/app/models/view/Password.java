package com.workschedule.app.models.view;

import javax.validation.constraints.Pattern;

import com.workschedule.app.validation.ConfirmarPassword;

@ConfirmarPassword(message="{register.repeatPassword.mismatch}")
public class Password {

	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	String password;
	
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	String confirmPassword;
	String usuario;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
