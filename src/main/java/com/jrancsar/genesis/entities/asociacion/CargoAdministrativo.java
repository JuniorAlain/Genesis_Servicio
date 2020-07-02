package com.jrancsar.genesis.entities.asociacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrancsar.genesis.entities.seguridad.Usuario;

@Entity
@Table(name = "Asociacion_tbCargoAdministrativo")
public class CargoAdministrativo implements Serializable {		
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idCargoAdministrativo;	
	private String nCargoAdministrativo;	
	private Boolean activo;	
	private String version;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cargoAdministrativo")//, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuarios = new ArrayList<>();
	
	public CargoAdministrativo () {		
	}

	public CargoAdministrativo(Integer idCargoAdministrativo, String nCargoAdministrativo, Boolean activo, String version) {
		super();
		this.idCargoAdministrativo = idCargoAdministrativo;
		this.nCargoAdministrativo = nCargoAdministrativo;
		this.activo = activo;
		this.version = version;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
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
