package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.workschedule.app.enums.Aplicacion;
import com.workschedule.app.enums.EstadoRequerimiento;
import com.workschedule.app.enums.TipoRequerimiento;

@Entity
@Table(name = "Requerimiento")
public class Requerimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	private String requerimiento;
	
	@NotEmpty
	private String descripcion;
	
	private String observacion;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadoRequerimiento estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_planif_testing")
	private Date fechaPlanifTesting;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_real_testing")
	private Date fechaRealTesting;
	
	@Column(name="motivo_replanif_testing")
	private Date motivoReplanifTesting;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_planif_implementacion")
	private Date fechaPlanifImplementacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_real_implementacion")
	private Date fechaRealImplementacion;
	
	@Column(name="motivo_replanif_implementacion")
	private Date motivoReplanifImplementacion;
	
	@NotNull
	@Column(name="tipo_requerimiento")
	@Enumerated(EnumType.STRING)
	private TipoRequerimiento tipoRequerimiento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Aplicacion aplicacion;

	@OneToMany(mappedBy = "requerimiento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Estimacion> estimacion;
	
	
	
	public Requerimiento() {
		
		this.estimacion = new ArrayList<>();
		
	}
	
	public void addEstimacion(Estimacion estimacion) {
		this.estimacion.add(estimacion);
	}
	
	public void deleteEstimacion(int index) {
		this.estimacion.remove(index);
	}
	
	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public EstadoRequerimiento getEstado() {
		return estado;
	}

	public void setEstado(EstadoRequerimiento estado) {
		this.estado = estado;
	}

	public Date getFechaPlanifTesting() {
		return fechaPlanifTesting;
	}

	public void setFechaPlanifTesting(Date fechaPlanifTesting) {
		this.fechaPlanifTesting = fechaPlanifTesting;
	}

	public Date getFechaRealTesting() {
		return fechaRealTesting;
	}

	public void setFechaRealTesting(Date fechaRealTesting) {
		this.fechaRealTesting = fechaRealTesting;
	}

	public Date getMotivoReplanifTesting() {
		return motivoReplanifTesting;
	}

	public void setMotivoReplanifTesting(Date motivoReplanifTesting) {
		this.motivoReplanifTesting = motivoReplanifTesting;
	}

	public Date getFechaPlanifImplementacion() {
		return fechaPlanifImplementacion;
	}

	public void setFechaPlanifImplementacion(Date fechaPlanifImplementacion) {
		this.fechaPlanifImplementacion = fechaPlanifImplementacion;
	}

	public Date getFechaRealImplementacion() {
		return fechaRealImplementacion;
	}

	public void setFechaRealImplementacion(Date fechaRealImplementacion) {
		this.fechaRealImplementacion = fechaRealImplementacion;
	}

	public Date getMotivoReplanifImplementacion() {
		return motivoReplanifImplementacion;
	}

	public void setMotivoReplanifImplementacion(Date motivoReplanifImplementacion) {
		this.motivoReplanifImplementacion = motivoReplanifImplementacion;
	}

	public TipoRequerimiento getTipoRequerimiento() {
		return tipoRequerimiento;
	}

	public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
		this.tipoRequerimiento = tipoRequerimiento;
	}

	public List<Estimacion> getEstimacion() {
		return estimacion;
	}

	public void setEstimacion(List<Estimacion> estimacion) {
		this.estimacion = estimacion;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aplicacion, descripcion, estado, estimacion, fechaPlanifImplementacion, fechaPlanifTesting,
				fechaRealImplementacion, fechaRealTesting, motivoReplanifImplementacion, motivoReplanifTesting,
				observacion, requerimiento, tipoRequerimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requerimiento other = (Requerimiento) obj;
		return aplicacion == other.aplicacion && Objects.equals(descripcion, other.descripcion)
				&& estado == other.estado && Objects.equals(estimacion, other.estimacion)
				&& Objects.equals(fechaPlanifImplementacion, other.fechaPlanifImplementacion)
				&& Objects.equals(fechaPlanifTesting, other.fechaPlanifTesting)
				&& Objects.equals(fechaRealImplementacion, other.fechaRealImplementacion)
				&& Objects.equals(fechaRealTesting, other.fechaRealTesting)
				&& Objects.equals(motivoReplanifImplementacion, other.motivoReplanifImplementacion)
				&& Objects.equals(motivoReplanifTesting, other.motivoReplanifTesting)
				&& Objects.equals(observacion, other.observacion) && Objects.equals(requerimiento, other.requerimiento)
				&& Objects.equals(tipoRequerimiento, other.tipoRequerimiento);
	}

	@Override
	public String toString() {
		return "Requerimiento [requerimiento=" + requerimiento + ", descripcion=" + descripcion + ", observacion="
				+ observacion + ", estado=" + estado + ", fechaPlanifTesting=" + fechaPlanifTesting
				+ ", fechaRealTesting=" + fechaRealTesting + ", motivoReplanifTesting=" + motivoReplanifTesting
				+ ", fechaPlanifImplementacion=" + fechaPlanifImplementacion + ", fechaRealImplementacion="
				+ fechaRealImplementacion + ", motivoReplanifImplementacion=" + motivoReplanifImplementacion
				+ ", tipoRequerimiento=" + tipoRequerimiento + ", estimacion=" + estimacion + ", aplicacion="
				+ aplicacion + "]";
	}
	
	
	

	/******************* Metodos *******************/
	
//	@PrePersist
//	public void prePersist() {
//		fecha = new Date();
//	}
	
	

	
	
	

}
