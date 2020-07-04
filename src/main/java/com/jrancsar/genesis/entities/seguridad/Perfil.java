package com.jrancsar.genesis.entities.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Seguridad_tbPerfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idPerfil;	
	private String nPerfil;	
	private Boolean activo;
	private String version;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuarioPerfil")//, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuarios = new ArrayList<>();
	
	//@JsonIgnore para que ignore a la tabla PerfilFuncionalidad
	@OneToMany(mappedBy = "idPerfilFuncionalidad.perfil")
	private Set<PerfilFuncionalidad> funcionalidad = new HashSet<>();
	
	public Perfil() {		
	}
	
	public Perfil(Integer idPerfil, String nPerfil, Boolean activo, String version) {
		super();
		this.idPerfil = idPerfil;
		this.nPerfil = nPerfil;
		this.activo = activo;
		this.version = version;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getnPerfil() {
		return nPerfil;
	}

	public void setnPerfil(String nPerfil) {
		this.nPerfil = nPerfil;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Set<PerfilFuncionalidad> getFuncionalidad() {
		return funcionalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPerfil == null) ? 0 : idPerfil.hashCode());
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
		Perfil other = (Perfil) obj;
		if (idPerfil == null) {
			if (other.idPerfil != null)
				return false;
		} else if (!idPerfil.equals(other.idPerfil))
			return false;
		return true;
	}
}
