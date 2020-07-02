package com.jrancsar.genesis.dto.asociacion;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;

public class CargoAdministrativoEntityDTO implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	private Integer idCargoAdministrativo;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=3, max=50, message="Tamaño de texto: min 3 y max 50")
	@NotBlank
	private String nCargoAdministrativo;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean activo;
	@NotEmpty(message="El campo obligatorio.")
	@NotNull(message="El campo no puede ser nulo")
	@Length(min=32, max=32, message="Tamaño de texto es de 32")
	@NotBlank
	private String version;
	@NotNull(message="El campo no puede ser nulo")
	private Boolean existe;

	public CargoAdministrativoEntityDTO () {		
	}
	
	public CargoAdministrativoEntityDTO(CargoAdministrativo objeto) {
		idCargoAdministrativo = objeto.getIdCargoAdministrativo();
		nCargoAdministrativo = objeto.getnCargoAdministrativo();
		activo = objeto.getActivo();
		version = objeto.getVersion();
		this.setExiste(true);
	}
	
	public CargoAdministrativoEntityDTO(CargoAdministrativo objeto, Boolean existe) {
		idCargoAdministrativo = objeto.getIdCargoAdministrativo();
		nCargoAdministrativo = objeto.getnCargoAdministrativo();
		activo = objeto.getActivo();
		version = objeto.getVersion();
		this.setExiste(existe);
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
}
