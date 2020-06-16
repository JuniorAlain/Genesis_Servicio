package com.jrancsar.genesis.entities.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_Perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfil;
	private String nPerfil;
	private Boolean activo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuarioPerfil", cascade = CascadeType.ALL)
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Perfil() {		
	}
	
	public Perfil(Long idPerfil, String nPerfil, Boolean activo) {
		super();
		this.idPerfil = idPerfil;
		this.nPerfil = nPerfil;
		this.activo = activo;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
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

	public List<Usuario> getUsuarios() {
		return usuarios;
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
