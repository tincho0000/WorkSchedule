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

	private String fase;
	private int licencia;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fase", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<RequerimientoFase> requerimientoFase = new HashSet<>();
	private List<EstimacionRequerimientoFase> estimacionRequerimientoFases = new ArrayList<>();

	/******************* Metodos *******************/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	public List<EstimacionRequerimientoFase> getEstimacionRequerimientoFases() {
		return estimacionRequerimientoFases;
	}

	public void setEstimacionRequerimientoFases(List<EstimacionRequerimientoFase> estimacionRequerimientoFases) {
		this.estimacionRequerimientoFases = estimacionRequerimientoFases;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fase, id, licencia/*, estimacionRequerimientoFases*/);
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
		return Objects.equals(fase, other.fase) && Objects.equals(id, other.id)
				&& Objects.equals(licencia, other.licencia);
	}

	public Fase() {
	}

	@Override
	public String toString() {
		return "Fase [id=" + id + ", fase=" + fase + ", licencia=" + licencia + "]";
	}
	
}
