package com.workschedule.app.enums;

import java.util.Arrays;
import java.util.List;

public enum TipoRequerimiento {

	SIN_SELECCION("Seleccionar..."),
	ANALISIS("ANALISIS"),
	REWORK("REWORK"),
	EVOLUTIVO("EVOLUTIVO"),
	CORRECTIVO("CORRECTIVO"),
	EMERGENCIA("EMERGENCIA");

	private String nombreTipoRequerimiento;

	TipoRequerimiento(String tipoReq) {
		this.nombreTipoRequerimiento = tipoReq;
	}

	public String getNombreRequerimiento() {
		return this.nombreTipoRequerimiento;
	}

	public static List<TipoRequerimiento> obtenerTipoRequerimiento() {
	    
		return Arrays.asList(TipoRequerimiento.values());
	}

	public static TipoRequerimiento fromString(String text) {
		for (TipoRequerimiento b : TipoRequerimiento.values()) {
			if (b.nombreTipoRequerimiento.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}