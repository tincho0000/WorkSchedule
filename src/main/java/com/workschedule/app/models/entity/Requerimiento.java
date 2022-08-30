package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Requerimiento")
public class Requerimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String requerimiento;
	@NotEmpty
	private String descripcion;
	private int cantidadHoras;
	private String observacion;
	private String estado;
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@OneToMany(mappedBy = "requerimiento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<RequerimientoFase> requerimientoFases;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aplicacion_id")
	private Aplicacion aplicacion;

	/******************* Metodos *******************/
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setDescripcion(String nombre) {
		this.descripcion = nombre;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int horas) {
		this.cantidadHoras = horas;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<RequerimientoFase> getRequerimientoFases() {
		return requerimientoFases;
	}

	public void setRequerimientoFases(List<RequerimientoFase> fases) {
		this.requerimientoFases = fases;
	}
	
	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadHoras, requerimientoFases, id, descripcion, observacion, requerimiento, aplicacion, fecha, estado);
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
		return cantidadHoras == other.cantidadHoras && Objects.equals(requerimientoFases, other.requerimientoFases)
				&& Objects.equals(id, other.id) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(observacion, other.observacion) && Objects.equals(requerimiento, other.requerimiento)
				&& Objects.equals(aplicacion, other.aplicacion) && Objects.equals(fecha, other.fecha) && Objects.equals(estado, other.estado);
	}

	public Requerimiento() {
		
		this.requerimientoFases = new ArrayList<>();
		
	}
	public void addRequerimientoFase(RequerimientoFase requerimientoFase) {
		this.requerimientoFases.add(requerimientoFase);
	}
	
	public void addFase(Fase fase, int cantHoras) {
		RequerimientoFase requerimientoFase = new RequerimientoFase(this, fase);
		requerimientoFase.setCantidadHoras(cantHoras);
		requerimientoFases.add(requerimientoFase);
        fase.getRequerimientoFase().add(requerimientoFase);
    }
	
	public void removeFase(Fase fase) {
		
		for (Iterator<RequerimientoFase> iterator = requerimientoFases.iterator(); iterator.hasNext();) {
//			RequerimientoFase requerimientoFase = (RequerimientoFase) iterator.next();
			
			RequerimientoFase reqFase = iterator.next();
			if (reqFase.getRequerimiento().equals(this) && reqFase.getFase().equals(fase)) {
				iterator.remove();
//				reqFase.getFase().getRequerimientoFase().remove(reqFase);
				reqFase.setFase(null);
				reqFase.setRequerimiento(null);
			}
		}
    }
	
//	public String addFase() {
//		System.out.println("Hola");
//		return "";
//    }

	@Override
	public String toString() {
		return "Requerimiento [id=" + id + ", requerimiento=" + requerimiento + ", descripcion=" + descripcion
				+ ", cantidadHoras=" + cantidadHoras + ", observacion=" + observacion + ", estado=" + estado
				+ ", fecha=" + fecha + /*", \nrequerimientoFases= " + requerimientoFases.toString() +*/ ", \naplicacion=" + aplicacion.toString()
				+ "]";
	}
	
	
	

}
