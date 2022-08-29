package com.timetracker.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
						@RequestParam(value="logout", required=false) String logout,
						Model model, Principal principal, RedirectAttributes flash) {
		
		System.err.println("-------------------------------principal: " + principal);
		if (principal != null) {
			System.err.println("Ya ha iniciado sesión anteriormente");
			flash.addFlashAttribute("titulo", "Login");
			flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");
			return "redirect:/app/listar";
		}
		
		if (error != null) {
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta. Por favor vuelva a intentarlo!");
			System.err.println("Error en el login: Nombre de usuario o contraseña incorrecta. Por favor vuelva a intentarlo!");
		}
		
		System.err.println(logout);
		if (logout != null) {
			System.err.println("Ha cerrado sesión con éxito!");
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}
		
		return "login";
	}
	
	
}
