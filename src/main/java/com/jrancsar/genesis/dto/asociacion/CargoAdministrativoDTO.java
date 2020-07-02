package com.jrancsar.genesis.dto.asociacion;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;

public class CargoAdministrativoDTO implements Serializable {		
	
	private static final long serialVersionUID = 1L;

	@NotNull(message="El campo no puede ser nulo")
	private Integer idCargoAdministrativo;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=3, max=50, message="Tamaño de texto: min 3 y max 50")
	@NotBlank
	private String nCargoAdministrativo;	
	
	public CargoAdministrativoDTO() {		
	}

	public CargoAdministrativoDTO(CargoAdministrativo objeto) {
		idCargoAdministrativo = objeto.getIdCargoAdministrativo();
		nCargoAdministrativo = objeto.getnCargoAdministrativo();		
	}

	public Integer getIdCargoAdministrativo() {
		return idCargoAdministrativo;
	}

	public void setIdCargoAdministrativo(Integer idCargoAdministrativo) {
		this.idCargoAdministrativo = idCargoAdministrativo;
	}

	public String getnCargoAdministrativo() {
		return nCargoAdministrativo;
	}

	public void setnCargoAdministrativo(String nCargoAdministrativo) {
		this.nCargoAdministrativo = nCargoAdministrativo;
	}
}
