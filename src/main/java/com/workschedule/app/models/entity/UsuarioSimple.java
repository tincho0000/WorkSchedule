package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Usuario")
public class UsuarioSimple implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(unique = true, length = 30)
	@NotEmpty
	private String usuario;

	@Column(length = 60)
	@NotEmpty
	private String password;

//	@NotEmpty
	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	private String foto;
	
	private Boolean activo;
	
	
	

	/******************* Metodos *******************/

	public UsuarioSimple() {

	}


	/******************* Get & Set *******************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", fecha=" + fecha + ", foto=" + foto + ", activo=" + activo
				+ ", datoPersonal=" + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(activo, fecha, foto, id, password, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSimple other = (UsuarioSimple) obj;
		return Objects.equals(activo, other.activo) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(foto, other.foto) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(usuario, other.usuario);
	}
	
}
