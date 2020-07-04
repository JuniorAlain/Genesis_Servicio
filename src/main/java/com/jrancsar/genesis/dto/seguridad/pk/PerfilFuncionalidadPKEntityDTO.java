package com.jrancsar.genesis.dto.seguridad.pk;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.jrancsar.genesis.dto.seguridad.ObjetoDTO;
import com.jrancsar.genesis.dto.seguridad.PerfilDTO;

public class PerfilFuncionalidadPKEntityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private PerfilDTO perfilDTO;	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private ObjetoDTO objetoDTO;
	
	public PerfilFuncionalidadPKEntityDTO() {		
	}
	
	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}
	
	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}
	
	public ObjetoDTO getObjetoDTO() {
		return objetoDTO;
	}
	
	public void setObjetoDTO(ObjetoDTO objetoDTO) {
		this.objetoDTO = objetoDTO;
	}	
}
