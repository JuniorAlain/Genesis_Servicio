	package com.jrancsar.genesis.dto.seguridad;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jrancsar.genesis.dto.seguridad.pk.PerfilFuncionalidadPKEntityDTO;
import com.jrancsar.genesis.entities.seguridad.PerfilFuncionalidad;

public class PerfilFuncionalidadEntityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private PerfilFuncionalidadPKEntityDTO idPerfilFuncionalidad = new PerfilFuncionalidadPKEntityDTO();
	
	@NotNull(message="El campo no puede ser nulo")
	private Boolean leer;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean escribir;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean ejecutar;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean imprimir;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean visualizar;
	@NotNull(message="El campo no puede ser nulo")	
	private Boolean exportar;	
	@NotNull(message="El campo no puede ser nulo")
	private Boolean activo;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=32, max=32, message="Tamaño de texto es de 32")
	@NotBlank
	private String version; 
	@NotNull(message="El campo no puede ser nulo")
	private Boolean existe;
	
	public PerfilFuncionalidadEntityDTO() {		
	}
	
	public PerfilFuncionalidadEntityDTO(PerfilDTO perfilDTO, ObjetoDTO objetoDTO, PerfilFuncionalidad perfilFuncionalidad) {		
		idPerfilFuncionalidad.setPerfilDTO(perfilDTO);
		idPerfilFuncionalidad.setObjetoDTO(objetoDTO);
		this.leer = perfilFuncionalidad.getLeer();
		this.escribir = perfilFuncionalidad.getEscribir();
		this.ejecutar = perfilFuncionalidad.getEjecutar();
		this.imprimir = perfilFuncionalidad.getImprimir();
		this.visualizar = perfilFuncionalidad.getVisualizar();
		this.exportar = perfilFuncionalidad.getExportar();
		this.activo = perfilFuncionalidad.getActivo();
		this.version = perfilFuncionalidad.getVersion();
		this.setActivo(true);
	}
	/*	
	public PerfilDTO getPerfilDTO() {
		return idPerfilFuncionalidad.getPerfilDTO();
	}
	*/
	public void setPerfilDTO(PerfilDTO perfilDTO) {
		idPerfilFuncionalidad.setPerfilDTO(perfilDTO);
	}

	public ObjetoDTO getObjetoDTO() {
		return idPerfilFuncionalidad.getObjetoDTO();
	}
	
	public void setObjetoDTO(ObjetoDTO objetoDTO) {
		idPerfilFuncionalidad.setObjetoDTO(objetoDTO);
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
}
