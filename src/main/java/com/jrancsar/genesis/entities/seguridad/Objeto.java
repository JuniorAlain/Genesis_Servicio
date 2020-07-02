package com.jrancsar.genesis.entities.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seguridad_tbObjeto")
public class Objeto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idObjeto;
	private String nObjeto;
	private String descripcion;
	private Integer objetoPadre;
	private String comando;
	private Boolean activo;
	private String version;
	
	public Objeto() {		
	}

	public Objeto(Integer idObjeto, String nObjeto, String descripcion, Integer objetoPadre, String comando,
			Boolean activo, String version) {
		super();
		this.idObjeto = idObjeto;
		this.nObjeto = nObjeto;
		this.descripcion = descripcion;
		this.objetoPadre = objetoPadre;
		this.comando = comando;
		this.activo = activo;
		this.version = version;
	}

	public Integer getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getnObjeto() {
		return nObjeto;
	}

	public void setnObjeto(String nObjeto) {
		this.nObjeto = nObjeto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getObjetoPadre() {
		return objetoPadre;
	}

	public void setObjetoPadre(Integer objetoPadre) {
		this.objetoPadre = objetoPadre;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idObjeto == null) ? 0 : idObjeto.hashCode());
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
		Objeto other = (Objeto) obj;
		if (idObjeto == null) {
			if (other.idObjeto != null)
				return false;
		} else if (!idObjeto.equals(other.idObjeto))
			return false;
		return true;
	}
}
