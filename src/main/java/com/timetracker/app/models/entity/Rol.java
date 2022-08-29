package com.timetracker.app.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy="roles")
	
	// Nombre de columna en la tabla Rol con la que relaciono a la tbla de
	// usuario(en este caso es redundante)
//	@JoinColumn(name = "usuario_id")
	private Set<Usuario> usuarios;

	private String descripcion;

	/******************* Metodos *******************/

	/******************* Get & Set *******************/

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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", usuario=" + usuarios.toString() + ", descripcion=" + descripcion + "]";
	}

	public Rol() {
		this.usuarios = new HashSet<Usuario>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, usuarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(usuarios, other.usuarios);
	}

	

}
