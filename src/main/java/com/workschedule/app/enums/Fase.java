package com.workschedule.app.enums;

import java.util.Arrays;
import java.util.List;

public enum Fase {
	ANALISIS,
	ESTIMACION,
	CONSTRUCCION,
	PRUEBA,
	IMPLEMENTACION;
	

	public static List<Fase> obtenerFases() {
	    
		return Arrays.asList(Fase.values());
	}
}