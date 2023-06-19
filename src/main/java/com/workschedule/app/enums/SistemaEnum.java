package com.workschedule.app.enums;

public enum SistemaEnum {

    SHIVA( "Shiva", "SHV", "Cobranzas"),
    ICE( "Ice", "ICE", "Cobranzas"),
    OYP( "Nuevo OYP", "OYP", "Facturacion"),
    DEIMOS( "Deimos", "DEI", "Morosidad");

    private final String nombre;
    private final String nombreCorto;
    private final String grupo;
    SistemaEnum(String nombre, String nombreCorto, String grupo){
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.grupo = grupo;
    }

    public String getNombre(){ return nombre; }

    public String getNombreCorto(){ return nombreCorto; }

    public String getGrupo(){ return grupo; }

}
