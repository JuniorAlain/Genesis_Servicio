package com.jrancsar.genesis.dto.seguridad;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.jrancsar.genesis.dto.seguridad.pk.PerfilFuncionalidadPKDTO;
import com.jrancsar.genesis.entities.seguridad.Perfil;
import com.jrancsar.genesis.entities.seguridad.PerfilFuncionalidad;

public class PerfilFuncionalidadDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private PerfilFuncionalidadPKDTO idPerfilFuncionalidad = new PerfilFuncionalidadPKDTO();	

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
	
	public PerfilFuncionalidadDTO() {		
	}
	
	public PerfilFuncionalidadDTO(Perfil perfil, ObjetoDTO objetoDTO, PerfilFuncionalidad perfilFuncionalidad) {		
		idPerfilFuncionalidad.setPerfil(perfil);
		idPerfilFuncionalidad.setObjetoDTO(objetoDTO);		
		this.leer = perfilFuncionalidad.getLeer();
		this.escribir = perfilFuncionalidad.getEscribir();
		this.ejecutar = perfilFuncionalidad.getEjecutar();
		this.imprimir = perfilFuncionalidad.getImprimir();
		this.visualizar = perfilFuncionalidad.getVisualizar();
		this.exportar = perfilFuncionalidad.getExportar();		
	}
	/*	
	public Perfil getPerfil() {
		return idPerfilFuncionalidad.getPerfil();
	}
	*/
	public void setPerfil(Perfil perfil) {
		idPerfilFuncionalidad.setPerfil(perfil);
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
}
