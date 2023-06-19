package com.workschedule.app.enums;

public enum MesEnum {
    ENERO(1, "Enero"),
    FEBRERO(2, "Febrero"),
    MARZO(3, "Marzo"),
    ABRIL(4, "Abril"),
    MAYO(5, "Mayo"),
    JUNIO(6, "Junio"),
    JULIO(7, "Julio"),
    AGOSTO(8, "Agosto"),
    SEPTIEMBRE(9, "Septiembre"),
    OCTUBRE(10, "Octubre"),
    NOVIEMBRE(11, "Noviembre"),
    DICIEMBRE(12, "Diciembre");

    private final int numero;
    private final String nombre;

    MesEnum(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() { return nombre; }
    }
