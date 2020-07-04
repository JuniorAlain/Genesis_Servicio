package com.jrancsar.genesis.dto.seguridad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jrancsar.genesis.entities.seguridad.Perfil;
import com.jrancsar.genesis.entities.seguridad.PerfilFuncionalidad;

public class PerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private Integer idPerfil;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=3, max=25, message="Tamaño de texto: min 3 y max 25")
	@NotBlank
	private String nPerfil;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private Set<PerfilFuncionalidadDTO> funcionalidadDTO = new HashSet<>();	

	public PerfilDTO() {		
	}
	
	public PerfilDTO(Perfil objeto) {					
		this.idPerfil = objeto.getIdPerfil();
		this.nPerfil = objeto.getnPerfil();			
		for(PerfilFuncionalidad perfilFuncionalidadH : objeto.getFuncionalidad()) {
			if(perfilFuncionalidadH.getObjeto().getActivo()){
				if(perfilFuncionalidadH.getObjeto().getObjetoPadre() == 0) {
					funcionalidadDTO.add(new PerfilFuncionalidadDTO(
							perfilFuncionalidadH.getPerfil(), 
							new ObjetoDTO(perfilFuncionalidadH.getObjeto()),
							perfilFuncionalidadH));
				}
				else {
					for(PerfilFuncionalidad perfilFuncionalidadP : objeto.getFuncionalidad()) {
						if(perfilFuncionalidadP.getObjeto().getIdObjeto().equals(perfilFuncionalidadH.getObjeto().getObjetoPadre())
								&&
								perfilFuncionalidadP.getObjeto().getActivo()
								) {
							funcionalidadDTO.add(new PerfilFuncionalidadDTO(
									perfilFuncionalidadH.getPerfil(), 
									new ObjetoDTO(perfilFuncionalidadH.getObjeto()),
									perfilFuncionalidadH));
						}
					}
				}
			}
		}				 				
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
	
	public Set<PerfilFuncionalidadDTO> getFuncionalidad() {
		return funcionalidadDTO;
	}
}
