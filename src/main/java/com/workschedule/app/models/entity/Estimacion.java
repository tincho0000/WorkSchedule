package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Estimacion")
public class Estimacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	private int activo;
	private Date fecha;
	private int cantidadHoras;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estimacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EstimacionRequerimientoFase> estimacionRequerimientoFase = new ArrayList<>(); 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requerimiento_id")
	private Requerimiento requerimiento;

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

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public List<EstimacionRequerimientoFase> getEstimacionRequerimientoFase() {
		return estimacionRequerimientoFase;
	}

	public void setEstimacionRequerimientoFase(List<EstimacionRequerimientoFase> estimacionRequerimientoFase) {
		this.estimacionRequerimientoFase = estimacionRequerimientoFase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadHoras, estimacionRequerimientoFase, activo, descripcion, fecha, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estimacion other = (Estimacion) obj;
		return activo == other.activo && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(estimacionRequerimientoFase, other.estimacionRequerimientoFase) 
				&& Objects.equals(cantidadHoras, other.cantidadHoras);
	}

	@Override
	public String toString() {
		return "Estimacion [id=" + id + ", descripcion=" + descripcion + ", activo=" + activo + ", fecha=" + fecha
				+ ", cantidadHoras=" + cantidadHoras + ", estimacionRequerimientoFase=" + estimacionRequerimientoFase.toString()
				+ "]";
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}
	
	

}
