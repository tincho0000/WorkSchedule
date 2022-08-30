package com.workschedule.app.models.entity;

import java.io.Serializable;

import javax.persistence.Table;

//@Entity
@Table(name = "Planificado")
public class Planificado implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int idUsuario;
	private int idRequerimiento;
	private int idFase;
//	private List<RequerimientoPK> requerimiento;
	private int horas;
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdRequerimiento() {
		return idRequerimiento;
	}

	public void setIdRequerimiento(int idRequerimiento) {
		this.idRequerimiento = idRequerimiento;
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
