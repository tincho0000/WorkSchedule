package com.workschedule.app.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "planificacion_tarea")
public class PlanificacionTarea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nombre")
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="planificacion_id")
	private PlanificacionEstimada planificacionOriginal;
	@Column(name="fecha_desde")
	private LocalDate fechaDesdeTarea;
	@Column(name="fecha_hasta")
	private LocalDate fechaHastaTarea;
	@Column(name="puntos_configuracion")
	private int puntosConfiguracion;
	@Column(name="puntos_funcion")
	private int puntosFuncion;
	@Column(name="hs_no_medibles")
	private int hsNoMedibles;
	@Column(name="total_hs")
	private int totalHsEstimadasTarea;
	@Column(name="total_hs_reales")
	private int totalHsRealesEstimadasTarea;
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

	public PlanificacionEstimada getPlanificacionOriginal() {
		return planificacionOriginal;
	}

	public void setPlanificacionOriginal(PlanificacionEstimada planificacionOriginal) {
		this.planificacionOriginal = planificacionOriginal;
	}

	public LocalDate getFechaDesdeTarea() {
		return fechaDesdeTarea;
	}

	public void setFechaDesdeTarea(LocalDate fechaDesdeTarea) {
		this.fechaDesdeTarea = fechaDesdeTarea;
	}

	public LocalDate getFechaHastaTarea() {
		return fechaHastaTarea;
	}

	public void setFechaHastaTarea(LocalDate fechaHastaTarea) {
		this.fechaHastaTarea = fechaHastaTarea;
	}

	public int getPuntosConfiguracion() {
		return puntosConfiguracion;
	}

	public void setPuntosConfiguracion(int puntosConfiguracion) {
		this.puntosConfiguracion = puntosConfiguracion;
	}

	public int getPuntosFuncion() {
		return puntosFuncion;
	}

	public void setPuntosFuncion(int puntosFuncion) {
		this.puntosFuncion = puntosFuncion;
	}

	public int getHsNoMedibles() {
		return hsNoMedibles;
	}

	public void setHsNoMedibles(int hsNoMedibles) {
		this.hsNoMedibles = hsNoMedibles;
	}

	public int getTotalHsEstimadasTarea() {
		return totalHsEstimadasTarea;
	}

	public void setTotalHsEstimadasTarea(int totalHsEstimadasTarea) {
		this.totalHsEstimadasTarea = totalHsEstimadasTarea;
	}

	public int getTotalHsRealesEstimadasTarea() {
		return totalHsRealesEstimadasTarea;
	}

	public void setTotalHsRealesEstimadasTarea(int totalHsRealesEstimadasTarea) {
		this.totalHsRealesEstimadasTarea = totalHsRealesEstimadasTarea;
	}
	public PlanificacionTarea() {
	}


	public PlanificacionTarea(String nombre, PlanificacionEstimada planificacion, LocalDate fechaDesde, LocalDate fechaHasta, int horasNoMedibles,
                              int puntosConfiguracion, int puntosFuncion, int totalHsEstimadasTarea, int totalHsRealesEstimadasTarea) {
		this.nombre = nombre;
		this.planificacionOriginal = planificacion;
		this.fechaDesdeTarea = fechaDesde;
		this.fechaHastaTarea = fechaHasta;
		this.hsNoMedibles = horasNoMedibles;
		this.puntosConfiguracion = puntosConfiguracion;
		this.puntosFuncion = puntosFuncion;
		this.totalHsEstimadasTarea = totalHsEstimadasTarea;
		this.totalHsRealesEstimadasTarea = totalHsRealesEstimadasTarea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaDesdeTarea, fechaHastaTarea, puntosConfiguracion, puntosFuncion,hsNoMedibles, id, planificacionOriginal.getUser_owner_id(), totalHsEstimadasTarea, totalHsRealesEstimadasTarea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanificacionTarea other = (PlanificacionTarea) obj;
		return Objects.equals(fechaDesdeTarea, other.fechaDesdeTarea) && Objects.equals(fechaHastaTarea, other.fechaHastaTarea)
				&& Objects.equals(planificacionOriginal, other.planificacionOriginal);
	}

	@Override
	public String toString() {
		return "Planificacion Tarea [id=" + id + ", planificacionId=" + planificacionOriginal.getId() + ", idUsuario=" + planificacionOriginal.getUser_owner_id()
				+ ", fechaDesde=" + fechaDesdeTarea + ", fechaHasta=" + fechaHastaTarea + ", horasNoMedibles="
				+ hsNoMedibles + ", total hs tarea=" + totalHsEstimadasTarea
				+ ", total hs reales=" + totalHsRealesEstimadasTarea +"]";
	}

}
