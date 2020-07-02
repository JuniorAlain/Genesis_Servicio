package com.jrancsar.genesis.dto.asociacion;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CargoAdministrativoDTOSet implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=3, max=50, message="Tamaño de texto: min 3 y max 50")
	@NotBlank
	private String nCargoAdministrativo;	
	@NotNull(message="El campo no puede ser nulo")	
	private Boolean activo;	
	
	public CargoAdministrativoDTOSet() {		
	}

	public String getnCargoAdministrativo() {
		return nCargoAdministrativo;
	}

	public void setnCargoAdministrativo(String nCargoAdministrativo) {
		this.nCargoAdministrativo = nCargoAdministrativo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {		
		this.activo = activo;
	}	
}
