package com.jrancsar.genesis.resources.asociacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;
import com.jrancsar.genesis.services.asociacion.CargoAdministrativoService;

@RestController
@RequestMapping(value= "/cargoAdministrativos")
public class CargoAdministrativoResource {
	
	@Autowired
	private CargoAdministrativoService service;
	
	@GetMapping
	public ResponseEntity<List <CargoAdministrativo>> findAll(){		
		List<CargoAdministrativo> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{idCargoAdministrativo}")
	public ResponseEntity<CargoAdministrativo> findById(@PathVariable Integer idCargoAdministrativo){
		CargoAdministrativo objeto = service.findById(idCargoAdministrativo);
		return ResponseEntity.ok().body(objeto);		
	}
	
}
