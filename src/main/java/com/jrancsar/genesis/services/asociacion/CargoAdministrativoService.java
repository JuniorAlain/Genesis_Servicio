package com.jrancsar.genesis.services.asociacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;
import com.jrancsar.genesis.repositories.asociacion.CargoAdministrativoRepository;

@Service
public class CargoAdministrativoService {

	@Autowired
	private CargoAdministrativoRepository repository;
	
	public List<CargoAdministrativo> findAll() {
		return repository.findAll();
	}
		
	public CargoAdministrativo findById(Long idCargoAdministrativo) {		
		Optional<CargoAdministrativo> objeto = repository.findById(idCargoAdministrativo);
		return objeto.get();		
	}
}
