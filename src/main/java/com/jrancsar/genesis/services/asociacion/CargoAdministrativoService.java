package com.jrancsar.genesis.services.asociacion;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.dto.asociacion.CargoAdministrativoDTOSet;
import com.jrancsar.genesis.dto.asociacion.CargoAdministrativoEntityDTO;
import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;
import com.jrancsar.genesis.repositories.asociacion.CargoAdministrativoRepository;
import com.jrancsar.genesis.services.exceptions.DatabaseException;
import com.jrancsar.genesis.services.exceptions.ResourceNotFoundException;

@Service
public class CargoAdministrativoService {

	@Autowired
	private CargoAdministrativoRepository repository;
	
	private Boolean existe = false;			
	
	public List<CargoAdministrativo> findAll() {
		return repository.findAll();
	}
	
	public List<CargoAdministrativo> findByActivoTrue() {
		return repository.findByActivoTrue();
	}
	
	public CargoAdministrativo findById(Integer idCargoAdministrativo) {		
		Optional<CargoAdministrativo> objeto = repository.findById(idCargoAdministrativo);
		return objeto.orElseThrow(()->new ResourceNotFoundException(idCargoAdministrativo));
	}	
	
	@Transactional
	public CargoAdministrativo insert(CargoAdministrativo objeto) {						
		existe = repository.existsById(objeto.getIdCargoAdministrativo());		
		if(existe) {			
			Optional<CargoAdministrativo> existe = repository.findById(objeto.getIdCargoAdministrativo());
			return existe.orElseThrow(()->new DatabaseException(objeto.getIdCargoAdministrativo().toString()));
		}else {			
			return repository.save(objeto);
		}				
	}

	public CargoAdministrativo fromDTO(CargoAdministrativoDTOSet objetoDTOSet) {		
		return new CargoAdministrativo(
				repository.findByIdCargoAdministrativoMax(),
				objetoDTOSet.getnCargoAdministrativo(),
				objetoDTOSet.getActivo(),
				repository.newVersion());
	}
	
	@Transactional
	public void delete(Integer idCargoAdministrativo) {
		try {
			repository.deleteById(idCargoAdministrativo);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idCargoAdministrativo);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Transactional
	public CargoAdministrativo update(Integer idCargoAdministrativo, CargoAdministrativoEntityDTO objeto) {
		try {
			CargoAdministrativo entity = repository.getOne(idCargoAdministrativo);
			updateData(entity, objeto);			
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idCargoAdministrativo);
		}
	}
	
	private void updateData(CargoAdministrativo entity, CargoAdministrativoEntityDTO objeto) {		
		if(entity.getVersion().equals(objeto.getVersion()) 
				&& entity.getIdCargoAdministrativo().equals(objeto.getIdCargoAdministrativo())) {
			entity.setnCargoAdministrativo(objeto.getnCargoAdministrativo());
			entity.setActivo(objeto.getActivo());
			entity.setVersion(repository.newVersion());
			existe = true;
		}
	}
	
	public Boolean getExiste() {
		return existe;	
	}
}
