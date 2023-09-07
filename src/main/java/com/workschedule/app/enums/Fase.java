package com.workschedule.app.enums;

import java.util.Arrays;
import java.util.List;

public enum Fase {
	ANALISIS,
	ESTIMACION,
	CONSTRUCCION,
	SOPORTE_PRUEBAS_PI,
	SOPORTE_PRUEBAS_PAU,
	IMPLEMENTACION,
	HOMOLOGACION;

	public static List<Fase> obtenerFases() {
	    
		return Arrays.asList(Fase.values());
	}
}