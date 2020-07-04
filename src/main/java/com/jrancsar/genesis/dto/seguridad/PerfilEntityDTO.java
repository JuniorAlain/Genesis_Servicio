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

public class PerfilEntityDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private Integer idPerfil;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=3, max=25, message="Tamaño de texto: min 3 y max 25")
	@NotBlank
	private String nPerfil;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean activo;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=32, max=32, message="Tamaño de texto es de 32")
	@NotBlank
	private String version;
	
	@NotNull(message="El campo no puede ser nulo")
	private Boolean existe;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private Set<PerfilFuncionalidadEntityDTO> funcionalidadEntityDTO = new HashSet<>();		
	
	public PerfilEntityDTO() {		
	}
	
	public PerfilEntityDTO(Perfil objeto) {		
		this.idPerfil = objeto.getIdPerfil();
		this.nPerfil = objeto.getnPerfil();
		this.activo = objeto.getActivo();
		this.version = objeto.getVersion();					
		this.setExiste(true);
		
		for(PerfilFuncionalidad perfilFuncionalidadH : objeto.getFuncionalidad()) {
			if(perfilFuncionalidadH.getObjeto().getActivo()){
				if(perfilFuncionalidadH.getObjeto().getObjetoPadre() == 0) {
					funcionalidadEntityDTO.add(new PerfilFuncionalidadEntityDTO(
							new PerfilDTO(perfilFuncionalidadH.getPerfil()),
							new ObjetoDTO(perfilFuncionalidadH.getObjeto()),
							perfilFuncionalidadH));			
				}
				else {
					for(PerfilFuncionalidad perfilFuncionalidadP : objeto.getFuncionalidad()) {
						if(perfilFuncionalidadP.getObjeto().getIdObjeto().equals(perfilFuncionalidadH.getObjeto().getObjetoPadre())
								&&
								perfilFuncionalidadP.getObjeto().getActivo()
								) {
							funcionalidadEntityDTO.add(new PerfilFuncionalidadEntityDTO(
									new PerfilDTO(perfilFuncionalidadH.getPerfil()),					
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
	
	public Boolean getExiste() {
		return existe;
	}
	
	public void setExiste(Boolean existe) {
		this.existe = existe;
	}
	
	public Set<PerfilFuncionalidadEntityDTO> getFuncionalidad() {
		return funcionalidadEntityDTO;
	}
}
