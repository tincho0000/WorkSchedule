package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.workschedule.app.enums.Fase;
import com.workschedule.app.enums.TipoRequerimiento;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Estimacion", uniqueConstraints={ 
		@UniqueConstraint(columnNames={"requerimiento_id", "fase", "version"})
})
public class Estimacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private int version;
	private int activo;
	private int cantidadHoras; // TODO: Verificar si tiene sentido tenerlo ya que se puede calcular
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaAlta;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaUpdate;
	
	private String usuarioAlta;
	private String usuarioUpdate;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Fase fase;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requerimiento_id")
	private Requerimiento requerimiento;

	public Estimacion (String fase, int version, int cantHs, Requerimiento req, String userCreate, int activo) {
		System.out.println("se esta por crear la fase:" + fase);
	 this.setFase(Fase.fromString(fase.trim()));
	 this.setVersion(version);
	 this.setCantidadHoras(cantHs);
	 this.setRequerimiento(req);
	 this.setUsuarioAlta(userCreate);
	 this.setFechaAlta(new Date());
	 this.setActivo(activo);
	}
	public Estimacion() {

	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaUpdate() {
		return fechaUpdate;
	}

	public void setFechaUpdate(Date fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public String getUsuarioUpdate() {
		return usuarioUpdate;
	}

	public void setUsuarioUpdate(String usuarioUpdate) {
		this.usuarioUpdate = usuarioUpdate;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, cantidadHoras, fase, fechaAlta, fechaUpdate, id, requerimiento, usuarioAlta,
				usuarioUpdate, version);
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
		return activo == other.activo && cantidadHoras == other.cantidadHoras && fase == other.fase
				&& Objects.equals(fechaAlta, other.fechaAlta) && Objects.equals(fechaUpdate, other.fechaUpdate)
				&& Objects.equals(id, other.id) && Objects.equals(requerimiento, other.requerimiento)
				&& Objects.equals(usuarioAlta, other.usuarioAlta) && Objects.equals(usuarioUpdate, other.usuarioUpdate)
				&& Objects.equals(version, other.version);
	}

	@Override
	public String toString() {
		return "Estimacion [id=" + id + ", version=" + version + ", activo=" + activo + ", cantidadHoras="
				+ cantidadHoras + ", fechaAlta=" + fechaAlta + ", fechaUpdate=" + fechaUpdate + ", usuarioAlta="
				+ usuarioAlta + ", usuarioUpdate=" + usuarioUpdate + ", fase=" + fase + ", requerimiento="
				+ requerimiento + "]";
	}

}
