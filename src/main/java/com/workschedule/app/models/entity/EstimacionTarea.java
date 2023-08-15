package com.workschedule.app.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "estimacion_tarea")
public class EstimacionTarea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estimacion;

	@Column(name="nombre")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="requerimiento_id")
	private Requerimiento requerimiento;
	@Column(name="fecha_desde")
	private Date fechaDesdeTarea;
	@Column(name="fecha_hasta")
	private Date fechaHastaTarea;
	@Column(name="puntos_configuracion")
	private Long puntosConfiguracion;
	@Column(name="puntos_funcion")
	private Long puntosFuncion;
	@Column(name="hs_no_medibles")
	private double hsNoMedibles;
	@Column(name="total_hs")
	private double totalHsEstimadasTarea;
	@Column(name="total_hs_reales")
	private double totalHsRealesEstimadasTarea;
	@Column(name="fecha_entrega_testing_p")
	private Date fechaPlanificadaEntregaTesting;
	@Column(name = "fecha_entrega_testing_r")
	private Date fechaEntregaRealTesting;
	public Long getId() {
		return id_estimacion;
	}
	public void setId(Long id) {
		this.id_estimacion = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Requerimiento getPlanificacionOriginal() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Date getFechaDesdeTarea() {
		return fechaDesdeTarea;
	}

	public void setFechaDesdeTarea(Date fechaDesdeTarea) {
		this.fechaDesdeTarea = fechaDesdeTarea;
	}

	public Date getFechaHastaTarea() {
		return fechaHastaTarea;
	}

	public void setFechaHastaTarea(Date fechaHastaTarea) {
		this.fechaHastaTarea = fechaHastaTarea;
	}

	public Long getPuntosConfiguracion() {
		return puntosConfiguracion;
	}

	public void setPuntosConfiguracion(Long puntosConfiguracion) {
		this.puntosConfiguracion = puntosConfiguracion;
	}

	public Long getPuntosFuncion() {
		return puntosFuncion;
	}

	public void setPuntosFuncion(Long puntosFuncion) {
		this.puntosFuncion = puntosFuncion;
	}

	public Double getHsNoMedibles() {
		return hsNoMedibles;
	}

	public void setHsNoMedibles(Double hsNoMedibles) {
		this.hsNoMedibles = hsNoMedibles;
	}

	public Double getTotalHsEstimadasTarea() {
		return totalHsEstimadasTarea;
	}

	public void setTotalHsEstimadasTarea(Double totalHsEstimadasTarea) {
		this.totalHsEstimadasTarea = totalHsEstimadasTarea;
	}

	public Double getTotalHsRealesEstimadasTarea() {
		return totalHsRealesEstimadasTarea;
	}

	public void setTotalHsRealesEstimadasTarea(Double totalHsRealesEstimadasTarea) {
		this.totalHsRealesEstimadasTarea = totalHsRealesEstimadasTarea;
	}

	public Date getFechaPlanificadaEntregaTesting() {
		return fechaPlanificadaEntregaTesting;
	}

	public void setFechaPlanificadaEntregaTesting(Date fechaPlanificadaEntregaTesting) {
		this.fechaPlanificadaEntregaTesting = fechaPlanificadaEntregaTesting;
	}

	public Date getFechaEntregaRealTesting() {
		return fechaEntregaRealTesting;
	}

	public void setFechaEntregaRealTesting(Date fechaEntregaRealTesting) {
		this.fechaEntregaRealTesting = fechaEntregaRealTesting;
	}
	public EstimacionTarea() {
	}


	public EstimacionTarea(String nombre, Requerimiento requerimiento, Date fechaDesde, Date fechaHasta, Double horasNoMedibles,
						   Long puntosConfiguracion, Long puntosFuncion, Double totalHsEstimadasTarea, Double totalHsRealesEstimadasTarea,
						   Date fechaEntregaPlanificadaTesting, Date fechaEntregaRealTesting) {
		this.nombre = nombre;
		this.requerimiento = requerimiento;
		this.fechaDesdeTarea = fechaDesde;
		this.fechaHastaTarea = fechaHasta;
		this.hsNoMedibles = horasNoMedibles;
		this.puntosConfiguracion = puntosConfiguracion;
		this.puntosFuncion = puntosFuncion;
		this.totalHsEstimadasTarea = totalHsEstimadasTarea;
		this.totalHsRealesEstimadasTarea = totalHsRealesEstimadasTarea;
		this.fechaPlanificadaEntregaTesting = fechaEntregaPlanificadaTesting;
		this.fechaEntregaRealTesting = fechaEntregaRealTesting;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaDesdeTarea, fechaHastaTarea, puntosConfiguracion, puntosFuncion,hsNoMedibles, id_estimacion, totalHsEstimadasTarea, totalHsRealesEstimadasTarea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstimacionTarea other = (EstimacionTarea) obj;
		return Objects.equals(fechaDesdeTarea, other.fechaDesdeTarea) && Objects.equals(fechaHastaTarea, other.fechaHastaTarea);
	}

	@Override
	public String toString() {
		return "Estimacion Tarea [id=" + id_estimacion + ", requerimientoId="
				+ ", fechaDesde=" + fechaDesdeTarea + ", fechaHasta=" + fechaHastaTarea + ", horasNoMedibles="
				+ hsNoMedibles + ", total hs tarea=" + totalHsEstimadasTarea
				+ ", total hs reales=" + totalHsRealesEstimadasTarea +"]";
	}

}
