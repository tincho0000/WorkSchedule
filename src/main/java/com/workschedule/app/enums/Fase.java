package com.workschedule.app.enums;

import java.util.Arrays;
import java.util.List;

public enum Fase {
	ANALISIS("ANALISIS"),
	ESTIMACION("ESTIMACION"),
	CONSTRUCCION("CONSTRUCCION"),
	PI("PI"),
	PAU("PAU"),
	IMPLEMENTACION("IMPLEMENTACION"),
	HOMOLOGACION("HOMOLOGACION");

	private final String nombreFase;

	private Fase(String fase) {
		this.nombreFase = fase;
	}
	public String getFase() {
		return nombreFase;
	}

	public static Fase fromString(String text) {
		for (Fase b : Fase.values()) {
			if (b.nombreFase.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
	public static List<Fase> obtenerFases() {
	    
		return Arrays.asList(Fase.values());
	}
}