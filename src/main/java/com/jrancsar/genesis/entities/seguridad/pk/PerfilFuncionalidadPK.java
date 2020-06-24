package com.jrancsar.genesis.entities.seguridad.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jrancsar.genesis.entities.seguridad.Objeto;
import com.jrancsar.genesis.entities.seguridad.Perfil;

@Embeddable
public class PerfilFuncionalidadPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "perfil_idPerfil")
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name = "objeto_idObjeto")
	private Objeto objeto;
	
	public PerfilFuncionalidadPK() {		
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Objeto getObjeto() {
		return objeto;
	}
	
	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		PerfilFuncionalidadPK other = (PerfilFuncionalidadPK) obj;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		return true;
	}
	
}
