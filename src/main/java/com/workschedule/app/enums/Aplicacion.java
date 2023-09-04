package com.workschedule.app.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Aplicacion {
	SHV("SHIVA"),
	ICE("ICE"),
	OYP("OYP"),
	DEI("DEIMOS");
	
	private final String aplacacion;
	
	Aplicacion (String label){
		this.aplacacion = label;
	}
	
	public String getAplicacion() {
		return aplacacion;
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
