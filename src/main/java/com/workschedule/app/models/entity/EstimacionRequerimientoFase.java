package com.workschedule.app.models.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Estimacion_Requerimiento_Fase")
public class EstimacionRequerimientoFase {

//	@EmbeddedId
//	private RequerimientoFaseId requerimientoFaseId;

//	@MapsId("requerimientoId")
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	private Requerimiento requerimiento;
//
//	@MapsId("faseId")
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	private Fase fase;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Estimacion estimacion;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Requerimiento requerimiento;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Fase fase;

	@Column(name = "cantidad_horas")
	private int cantidadHoras;
	
//	@OneToMany(mappedBy = "requerimientoFases")
//	private List<Planificacion> planificaciones;

//	public RequerimientoFaseId getRequerimientoFaseId() {
//		return requerimientoFaseId;
//	}
//
//	public void setRequerimientoFaseId(RequerimientoFaseId requerimientoFaseId) {
//		this.requerimientoFaseId = requerimientoFaseId;
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
//	public List<Planificacion> getPlanificaciones() {
//		return planificaciones;
//	}
//
//	public void setPlanificaciones(List<Planificacion> planificaciones) {
//		this.planificaciones = planificaciones;
//	}

	public Estimacion getEstimacion() {
		return estimacion;
	}

	public void setEstimacion(Estimacion estimacion) {
		this.estimacion = estimacion;
	}

	public EstimacionRequerimientoFase() {
	}

	public EstimacionRequerimientoFase(Requerimiento requerimiento, Fase fase, Estimacion estimacion) {
		this.requerimiento = requerimiento;
		this.fase = fase;
		this.estimacion = estimacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadHoras, fase, requerimiento, /*planificaciones,*/ estimacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstimacionRequerimientoFase other = (EstimacionRequerimientoFase) obj;
		return cantidadHoras == other.cantidadHoras && Objects.equals(fase, other.fase)
				&& Objects.equals(requerimiento, other.requerimiento)
				&& Objects.equals(estimacion, other.estimacion)
				/*&& Objects.equals(planificaciones, other.planificaciones)*/;
	}

	@Override
	public String toString() {
		return "RequerimientoFase [estimacion=" + estimacion.toString() + ", requerimiento=" + requerimiento
				+ ", fase=" + fase.toString() + ", cantidadHoras=" + cantidadHoras + "]";
	}
	
	

}
