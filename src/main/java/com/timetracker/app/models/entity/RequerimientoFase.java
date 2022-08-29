package com.timetracker.app.models.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Requerimiento_Fase")
public class RequerimientoFase {

	@EmbeddedId
	private RequerimientoFaseId requerimientoFaseId;

	@MapsId("requerimientoId")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Requerimiento requerimiento;

	@MapsId("faseId")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Fase fase;

	@Column(name = "cantidad_horas")
	private int cantidadHoras;

	public RequerimientoFaseId getRequerimientoFaseId() {
		return requerimientoFaseId;
	}

	public void setRequerimientoFaseId(RequerimientoFaseId requerimientoFaseId) {
		this.requerimientoFaseId = requerimientoFaseId;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public RequerimientoFase() {
	}

	public RequerimientoFase(Requerimiento requerimiento, Fase fase) {
		this.requerimientoFaseId = new RequerimientoFaseId(requerimiento.getId(), fase.getId());
		this.requerimiento = requerimiento;
		this.fase = fase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadHoras, fase, requerimiento, requerimientoFaseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimientoFase other = (RequerimientoFase) obj;
		return cantidadHoras == other.cantidadHoras && Objects.equals(fase, other.fase)
				&& Objects.equals(requerimiento, other.requerimiento)
				&& Objects.equals(requerimientoFaseId, other.requerimientoFaseId);
	}

	@Override
	public String toString() {
		return "RequerimientoFase [requerimientoFaseId=" + requerimientoFaseId.toString() + ", requerimiento=" + requerimiento
				+ ", fase=" + fase.toString() + ", cantidadHoras=" + cantidadHoras + "]";
	}
	
	

}
