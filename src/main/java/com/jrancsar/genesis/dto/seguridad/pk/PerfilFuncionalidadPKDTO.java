package com.jrancsar.genesis.dto.seguridad.pk;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.jrancsar.genesis.dto.seguridad.ObjetoDTO;
import com.jrancsar.genesis.entities.seguridad.Perfil;

public class PerfilFuncionalidadPKDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private Perfil perfil;	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private ObjetoDTO objetoDTO;
	
	public PerfilFuncionalidadPKDTO() {		
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public ObjetoDTO getObjetoDTO() {
		return objetoDTO;
	}
	
	public void setObjetoDTO(ObjetoDTO objetoDTO) {
		this.objetoDTO = objetoDTO;
	}	
}
