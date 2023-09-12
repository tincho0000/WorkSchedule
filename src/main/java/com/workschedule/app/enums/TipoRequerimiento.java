package com.workschedule.app.enums;

import java.util.Arrays;
import java.util.List;

public enum TipoRequerimiento {
	ANALISIS,
	REWORK,
	EVOLUTIVO,
	CORRECTIVO,
	EMERGENCIA;
	

	public static List<TipoRequerimiento> obtenerTipoRequerimiento() {
	    
		return Arrays.asList(TipoRequerimiento.values());
	}
}