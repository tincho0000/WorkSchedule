package com.workschedule.app.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Aplicacion {
	SHV("SHIVA"),
	ICE("ICE"),
	OYP("OYP"),
	DEI("DEIMOS");
	
	private final String aplicacion;
	
	Aplicacion (String label){
		this.aplicacion = label;
	}
	
	public String getAplicacion() {
		return aplicacion;
	}
	
	public static List<String> obtenerAplicaciones() {
        
		List<String> aplicaciones = new ArrayList<>();
        
		for (Aplicacion tipo : Aplicacion.values()) {
			aplicaciones.add(tipo.getAplicacion());
        }
		
        return aplicaciones;
    }
	
	public static List<Aplicacion> obtenerAplicacionAbreviado() {
        
		return Arrays.asList(Aplicacion.values());
    }

}
