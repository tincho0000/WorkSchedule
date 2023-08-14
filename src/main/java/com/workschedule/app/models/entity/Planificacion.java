package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Planificacion")
public class Planificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private RequerimientoFase requerimientoFases;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
//		@JoinColumn(name="requerimiento_id", referencedColumnName = "requerimiento_id"),
//		@JoinColumn(name="fase_id", referencedColumnName = "fase_id")
//	})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="estimacion_requerimiento_fase_id")
	private EstimacionRequerimientoFase estimacionRequerimientoFases;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	private LocalDate fecha;
	@Column(name="hora_planificada")
	private int horasPlanificadas;
	@Column(name="hora_incurrida")
	private int horasIncurridas;
	private String observacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstimacionRequerimientoFase getEstimacionRequerimientoFases() {
		return estimacionRequerimientoFases;
	}

	public void setEstimacionRequerimientoFases(EstimacionRequerimientoFase estimacionRequerimientoFases) {
		this.estimacionRequerimientoFases = estimacionRequerimientoFases;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getHorasPlanificadas() {
		return horasPlanificadas;
	}

	public void setHorasPlanificadas(int horasPlanificadas) {
		this.horasPlanificadas = horasPlanificadas;
	}

	public int getHorasIncurridas() {
		return horasIncurridas;
	}

	public void setHorasIncurridas(int horasIncurridas) {
		this.horasIncurridas = horasIncurridas;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	

	public Planificacion() {
	}
	

	public Planificacion(EstimacionRequerimientoFase estimacionRequerimientoFases, Usuario usuario, LocalDate fecha, int horasPlanificadas,
							int horasIncurridas, String observacion) {
		this.estimacionRequerimientoFases = estimacionRequerimientoFases;
		this.usuario = usuario;
		this.fecha = fecha;
		this.horasPlanificadas = horasPlanificadas;
		this.horasIncurridas = horasIncurridas;
		this.observacion = observacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, horasIncurridas, horasPlanificadas, id, usuario, observacion, estimacionRequerimientoFases);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planificacion other = (Planificacion) obj;
		return Objects.equals(fecha, other.fecha) && horasIncurridas == other.horasIncurridas
				&& horasPlanificadas == other.horasPlanificadas && id == other.id && usuario == other.usuario
				&& Objects.equals(observacion, other.observacion)
				&& Objects.equals(estimacionRequerimientoFases, other.estimacionRequerimientoFases);
	}

	@Override
	public String toString() {
		return "Planificacion [id=" + id + ", requerimientoFases=" + estimacionRequerimientoFases + ", idUsuario=" + usuario
				+ ", fecha=" + fecha + ", horasPlanificadas=" + horasPlanificadas + ", horasIncurridas="
				+ horasIncurridas + ", observacion=" + observacion + "]";
	}

}
