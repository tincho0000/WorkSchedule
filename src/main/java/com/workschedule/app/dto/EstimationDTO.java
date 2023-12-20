package com.workschedule.app.dto;

import com.workschedule.app.models.entity.Requerimiento;

import java.util.Date;

public class EstimationDTO {
    private String fase;
    private int version;
    private int cantidadHoras;
    private String usuarioAlta;
    private int activo;

    //private Date fechaAlta;
    private Date fechaUpdate;
    //private String usuarioAlta;
    //private String usuarioUpdate;
    //private Requerimiento requerimiento;

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }
}
