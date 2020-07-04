package com.jrancsar.genesis.entities.seguridad;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.jrancsar.genesis.entities.seguridad.pk.PerfilFuncionalidadPK;

@Entity
@Table(name = "Seguridad_tbPerfilFuncionalidad")
public class PerfilFuncionalidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@JsonProperty(access = Access.WRITE_ONLY)
	private PerfilFuncionalidadPK idPerfilFuncionalidad = new PerfilFuncionalidadPK();	

	private Boolean leer;
	private Boolean escribir;
	private Boolean ejecutar;
	private Boolean imprimir;
	private Boolean visualizar;
	private Boolean exportar;
	private Boolean activo;
	private String version; 
	
	public PerfilFuncionalidad() {		
	}
	
	public PerfilFuncionalidad(Perfil perfil, Objeto objeto, Boolean leer, Boolean escribir, Boolean ejecutar, Boolean imprimir, Boolean visualizar,
			Boolean exportar, Boolean activo, String version) {
		super();
		idPerfilFuncionalidad.setPerfil(perfil);
		idPerfilFuncionalidad.setObjeto(objeto);;
		this.leer = leer;
		this.escribir = escribir;
		this.ejecutar = ejecutar;
		this.imprimir = imprimir;
		this.visualizar = visualizar;
		this.exportar = exportar;
		this.activo = activo;
		this.version = version;
	}
	
	@JsonIgnore
	public Perfil getPerfil() {
		return idPerfilFuncionalidad.getPerfil();
	}
	
	public void setPerfil(Perfil perfil) {
		idPerfilFuncionalidad.setPerfil(perfil);
	}

	public Objeto getObjeto() {
		return idPerfilFuncionalidad.getObjeto();
	}
	
	public void setObjeto(Objeto objeto) {
		idPerfilFuncionalidad.setObjeto(objeto);
	}
	
	public Boolean getLeer() {
		return leer;
	}

	public void setLeer(Boolean leer) {
		this.leer = leer;
	}

	public Boolean getEscribir() {
		return escribir;
	}

	public void setEscribir(Boolean escribir) {
		this.escribir = escribir;
	}

	public Boolean getEjecutar() {
		return ejecutar;
	}

	public void setEjecutar(Boolean ejecutar) {
		this.ejecutar = ejecutar;
	}

	public Boolean getImprimir() {
		return imprimir;
	}

	public void setImprimir(Boolean imprimir) {
		this.imprimir = imprimir;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}

	public Boolean getExportar() {
		return exportar;
	}

	public void setExportar(Boolean exportar) {
		this.exportar = exportar;
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
		result = prime * result + ((idPerfilFuncionalidad == null) ? 0 : idPerfilFuncionalidad.hashCode());
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
		PerfilFuncionalidad other = (PerfilFuncionalidad) obj;
		if (idPerfilFuncionalidad == null) {
			if (other.idPerfilFuncionalidad != null)
				return false;
		} else if (!idPerfilFuncionalidad.equals(other.idPerfilFuncionalidad))
			return false;
		return true;
	}
}
