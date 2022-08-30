package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Fase")
public class Fase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;
	private int otro;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fase", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<RequerimientoFase> requerimientoFase = new HashSet<>();
	private List<RequerimientoFase> requerimientoFase = new ArrayList<>();

	/******************* Metodos *******************/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOtro() {
		return otro;
	}

	public void setOtro(int otro) {
		this.otro = otro;
	}

	public List<RequerimientoFase> getRequerimientoFase() {
		return requerimientoFase;
	}

	public void setRequerimientoFase(List<RequerimientoFase> requerimiento) {
		this.requerimientoFase = requerimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, otro/*, requerimientoFase*/);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fase other = (Fase) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(otro, other.otro);
	}

	public Fase() {
	}

	@Override
	public String toString() {
		return "Fase [id=" + id + ", descripcion=" + descripcion + ", otro=" + otro + "]";
	}
	
}
