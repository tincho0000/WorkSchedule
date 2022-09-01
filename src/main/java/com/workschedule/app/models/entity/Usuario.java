package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
	
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
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private DatoPersonal datoPersonal;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Planificacion> planificaciones;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Incurrido> incurridos;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Usuario_Rol",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "rol_id")
	)
	private Set<Rol> roles;

//	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Grupo> grupos;

	/******************* Metodos *******************/

	public Usuario() {
		this.roles = new HashSet<Rol>();
		this.datoPersonal = new DatoPersonal();
//		grupos = new ArrayList<Grupo>();
//		planificados = new ArrayList<Planificado>();
	}

	public void addrRol(Rol rol) {
		this.roles.add(rol);
		rol.getUsuarios().add(this);
	}
	
	public void removeRol(Rol rol) {
		this.roles.remove(rol);
		rol.getUsuarios().remove(this);
	}
	
//	public void agregarGrupo (Grupo grupo) {
//		grupos.add(grupo);
//	}
//	public void agregarPlanificado (Planificado planificado) {
//		planificados.add(planificado);
//	}

	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}

	/******************* Get & Set *******************/
//	public int getIdUsuario() {
//		return idUsuario;
//	}
//
//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}
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

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

//	public List<Planificado> getPlanificados() {
//		return planificados;
//	}
//
//	public void setPlanificados(List<Planificado> planificados) {
//		this.planificados = planificados;
//	}

//	public List<Incurrido> getIncurrido() {
//		return incurrido;
//	}
//
//	public void setIncurrido(List<Incurrido> incurrido) {
//		this.incurrido = incurrido;
//	}

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
	
	public DatoPersonal getDatoPersonal() {
		return datoPersonal;
	}

	public void setDatoPersonal(DatoPersonal datoPersonal) {
		this.datoPersonal = datoPersonal;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", fecha=" + fecha + ", foto=" + foto + ", activo=" + activo
				+ ", datoPersonal=" + datoPersonal + "]";
	}

}
