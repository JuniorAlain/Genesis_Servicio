package com.jrancsar.genesis.entities.asociacion;

import java.io.Serializable;

public class CargoAdministrativo implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	
	private Long idCargoAdministrativo;
	private String nCargoAdministrativo;
	private Boolean activo;
	
	public CargoAdministrativo () {		
	}

	public CargoAdministrativo(Long idCargoAdministrativo, String nCargoAdministrativo, Boolean activo) {
		super();
		this.idCargoAdministrativo = idCargoAdministrativo;
		this.nCargoAdministrativo = nCargoAdministrativo;
		this.activo = activo;
	}

	public Long getIdCargoAdministrativo() {
		return idCargoAdministrativo;
	}

	public void setIdCargoAdministrativo(Long idCargoAdministrativo) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCargoAdministrativo == null) ? 0 : idCargoAdministrativo.hashCode());
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
		CargoAdministrativo other = (CargoAdministrativo) obj;
		if (idCargoAdministrativo == null) {
			if (other.idCargoAdministrativo != null)
				return false;
		} else if (!idCargoAdministrativo.equals(other.idCargoAdministrativo))
			return false;
		return true;
	}		
}