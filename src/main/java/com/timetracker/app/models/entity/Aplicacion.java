package com.timetracker.app.models.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Aplicacion")
public class Aplicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;

	@OneToMany(mappedBy = "aplicacion", fetch = FetchType.LAZY)
	private Set<Requerimiento> requerimientos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Requerimiento> getRequerimientos() {
		return requerimientos;
	}

	public void setRequerimientos(Set<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}

	public Aplicacion() {
	}

	@Override
	public String toString() {
		return "Aplicacion [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}
