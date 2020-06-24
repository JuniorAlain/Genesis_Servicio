package com.jrancsar.genesis.entities.seguridad;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;

@Entity
@Table(name = "Seguridad_tbUsuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String login;
	private String dni;
	private String aPaterno;
	private String aMaterno;
	private String nombre;
	private String pass;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant fechaRegistro;
	private String usuarioRegistro;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant fechaModificacion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant usuarioModificacion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant fechaExpiracion;
	private Boolean activo;
	
	//@OneToOne
	//@MapsId
	@ManyToOne
	@JoinColumn(name = "cargoAdministrativo_idCargoAdministrativo")
	private CargoAdministrativo cargoAdministrativo;
	
	@ManyToOne
	@JoinColumn(name = "usuarioPerfil_idPerfil")
	private Perfil usuarioPerfil;
	
	public Usuario() {		
	}
	
	public Usuario(String login, String dni, String aPaterno, String aMaterno, String nombre, String pass,
			Instant fechaRegistro, String usuarioRegistro, Instant fechaModificacion, Instant usuarioModificacion,
			Instant fechaExpiracion, Boolean activo, CargoAdministrativo cargoAdministrativo, Perfil usuarioPerfil) {
		super();
		this.login = login;
		this.dni = dni;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.nombre = nombre;
		this.pass = pass;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaExpiracion = fechaExpiracion;
		this.activo = activo;
		this.cargoAdministrativo = cargoAdministrativo;
		this.usuarioPerfil = usuarioPerfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Instant getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Instant fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Instant getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Instant fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Instant getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Instant usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Instant getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Instant fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public CargoAdministrativo getCargoAdministrativo() {
		return cargoAdministrativo;
	}

	public void setCargoAdministrativo(CargoAdministrativo cargoAdministrativo) {
		this.cargoAdministrativo = cargoAdministrativo;
	}	
	
	public Perfil getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(Perfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
