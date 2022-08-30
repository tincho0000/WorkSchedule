package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Dato_Personal")
public class DatoPersonal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "usuario_id")
    private Long id;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Column(name = "usuario_teco")
	private String usuarioTeco;

	private String oblea;
	private String telefono;
	
	@Past(message = "Error")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngreso;
	
	@Past(message = "laaaaaaaaaaa")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ultimoAscenso;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioTeco() {
		return usuarioTeco;
	}

	public void setUsuarioTeco(String usuarioTeco) {
		this.usuarioTeco = usuarioTeco;
	}

	public String getOblea() {
		return oblea;
	}

	public void setOblea(String oblea) {
		this.oblea = oblea;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getUltimoAscenso() {
		return ultimoAscenso;
	}

	public void setUltimoAscenso(Date ultimoAscenso) {
		this.ultimoAscenso = ultimoAscenso;
	}

	@Override
	public String toString() {
		return "DatoPersonal [usuario=" + usuario.getId() + ", usuarioTeco=" + usuarioTeco + ", oblea=" + oblea + ", telefono="
				+ telefono + ", fechaIngreso=" + fechaIngreso + ", ultimoAscenso=" + ultimoAscenso + "]";
	}
	
	

}
