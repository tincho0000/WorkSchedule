package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Requerimiento", uniqueConstraints={ 
		@UniqueConstraint(columnNames={"aplicacion_id", "requerimiento", "descripcion"})
})
public class Requerimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String requerimiento;
	@NotEmpty
	private String descripcion;
	//private int cantidadHoras;
	private String observacion;
	private String estado;
	@Column(name = "tipo_requerimiento")
	private String tipoRequerimiento;
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@OneToMany(mappedBy = "requerimiento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<EstimacionRequerimientoFase> estimacionRequerimientoFases;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aplicacion_id")
	private Aplicacion aplicacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
//	@OneToMany(mappedBy = "estimacion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	private List<Estimacion> estimacion;

	/******************* Metodos *******************/
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	
//	public List<Estimacion> getEstimacion() {
//		return estimacion;
//	}
//
//	public void setEstimacion(List<Estimacion> estimacion) {
//		this.estimacion = estimacion;
//	}



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

	//public int getCantidadHoras() {
	//	return cantidadHoras;
	//}
	//public void setCantidadHoras(int horas) {
	//	this.cantidadHoras = horas;
	//}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<EstimacionRequerimientoFase> getEstimacionRequerimientoFases() {
		return estimacionRequerimientoFases;
	}

	public void setEstimacionRequerimientoFases(List<EstimacionRequerimientoFase> estimacionRequerimientoFases) {
		this.estimacionRequerimientoFases = estimacionRequerimientoFases;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoRequerimiento() {
		return tipoRequerimiento;
	}

	public void setTipoRequerimiento(String tipoRequerimiento) {
		this.tipoRequerimiento = tipoRequerimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(/*cantidadHoras,*/ estimacionRequerimientoFases, id, descripcion, observacion, requerimiento, aplicacion, fecha, estado, usuario);
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
		return /*cantidadHoras == other.cantidadHoras && */Objects.equals(estimacionRequerimientoFases, other.estimacionRequerimientoFases)
				&& Objects.equals(id, other.id) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(observacion, other.observacion) && Objects.equals(requerimiento, other.requerimiento)
				&& Objects.equals(aplicacion, other.aplicacion) && Objects.equals(fecha, other.fecha) && Objects.equals(estado, other.estado)
				&& Objects.equals(usuario, other.usuario);
	}

	public Requerimiento() {
		
		this.estimacionRequerimientoFases = new ArrayList<>();
		
	}
	
	public void addEstimacionRequerimientoFase(EstimacionRequerimientoFase estimacionRequerimientoFases) {
		this.estimacionRequerimientoFases.add(estimacionRequerimientoFases);
	}
	
	public void addEstimacionFase(Fase fase, int cantHoras, Estimacion estimacion) {
		EstimacionRequerimientoFase estimacionRequerimientoFase = new EstimacionRequerimientoFase(this, fase, estimacion);
		estimacionRequerimientoFase.setCantidadHoras(cantHoras);
		estimacionRequerimientoFases.add(estimacionRequerimientoFase);
        fase.getEstimacionRequerimientoFases().add(estimacionRequerimientoFase);
    }
	
//	public void removeFase(Fase fase) {
//		
//		for (Iterator<EstimacionRequerimientoFase> iterator = requerimientoFases.iterator(); iterator.hasNext();) {
////			RequerimientoFase requerimientoFase = (RequerimientoFase) iterator.next();
//			
//			EstimacionRequerimientoFase reqFase = iterator.next();
//			if (reqFase.getRequerimiento().equals(this) && reqFase.getFase().equals(fase)) {
//				iterator.remove();
////				reqFase.getFase().getRequerimientoFase().remove(reqFase);
//				reqFase.setFase(null);
//				reqFase.setRequerimiento(null);
//			}
//		}
//    }
	
//	public String addFase() {
//		System.out.println("Hola");
//		return "";
//    }

	@Override
	public String toString() {
		return "Requerimiento [id=" + id + ", requerimiento=" + requerimiento + ", descripcion=" + descripcion
				/*+ ", cantidadHoras=" + cantidadHoras */+ ", observacion=" + observacion + ", estado=" + estado
				+ ", fecha=" + fecha + /*", \nestimacionRequerimientoFases= " + estimacionRequerimientoFases.toString() +*/ ", \naplicacion=" + aplicacion.toString()
				+ ", usuario=" + usuario.getUsuario() 
				+ "]";
	}
	
	
	

}
