package com.jrancsar.genesis.resources.asociacion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;

@RestController
@RequestMapping(value= "/cargoAdministrativo")
public class CargoAdministrativoResource {
	
	@GetMapping
	public ResponseEntity<CargoAdministrativo> findAll(){
		CargoAdministrativo cargoAdmi = new CargoAdministrativo(1L, "Administrador", true);
		return ResponseEntity.ok().body(cargoAdmi);
	}
}
