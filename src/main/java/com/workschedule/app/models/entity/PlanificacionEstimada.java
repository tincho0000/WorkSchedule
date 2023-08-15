package com.workschedule.app.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "estimacion_planificada")
public class PlanificacionEstimada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="planificacion_id")
	private Long id;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="usuario_id")
	@Column(name = "user_owner_id")
	private int user_owner_id;
	@Column(name="creation_date")
	private LocalDate fechaCreacion;
	@Column(name="last_modified_date")
	private LocalDate ultimaFechaModificacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUser_owner_id() {
		return user_owner_id;
	}

	public void setUser_owner_id(int user_owner_id) {
		this.user_owner_id = user_owner_id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getUltimaFechaModificacion() {
		return ultimaFechaModificacion;
	}

	public void setUltimaFechaModificacion(LocalDate ultimaFechaModificacion) {
		this.ultimaFechaModificacion = ultimaFechaModificacion;
	}
	public PlanificacionEstimada() {
	}

	public PlanificacionEstimada(Usuario usuario, LocalDate fechaCreacion, LocalDate fechaUltimaModificacion) {
		this.fechaCreacion = fechaCreacion;
		this.ultimaFechaModificacion = fechaUltimaModificacion;
		this.user_owner_id = usuario.getId().intValue();
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, ultimaFechaModificacion, id, user_owner_id);
	}

	@Override
	public String toString() {
		return "Planificacion [id=" + id + ", idUsuario=" + user_owner_id
				+ ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + ultimaFechaModificacion + "]";
	}

}
