package com.workschedule.app.enums;

public enum MotivoReplanificacion {
    NO_APLICA("NO APLICA"),
    MOTIVO1("MOTIVO1"),
    MOTIVO2("MOTIVO2"),
    MOTIVO3("MOTIVO3");
    private String nombreMotivo;

    MotivoReplanificacion(String motivo){
        this.nombreMotivo = motivo;
    }

    public String getMotivo(){
        return this.nombreMotivo;
    }
}
