package com.workschedule.app.enums;

import java.util.Arrays;
import java.util.List;

public enum Fase {
	ANALISIS("ANALISIS"),
	ESTIMACION("ESTIMACION"),
	CONSTRUCCION(""),
	SOPORTE_PRUEBAS_PI("SOPORTE_PRUEBAS_PI"),
	SOPORTE_PRUEBAS_PAU("SOPORTE_PRUEBAS_PAU"),
	IMPLEMENTACION("IMPLEMENTACION"),
	HOMOLOGACION("HOMOLOGACION");

	private final String nombreFase;

	private Fase(String fase) {
		this.nombreFase = fase;
	}
	public String getFase() {
		return nombreFase;
	}
	public static List<Fase> obtenerFases() {
	    
		return Arrays.asList(Fase.values());
	}
}