package com.jrancsar.genesis.resources.asociacion;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jrancsar.genesis.dto.asociacion.CargoAdministrativoDTO;
import com.jrancsar.genesis.dto.asociacion.CargoAdministrativoDTOSet;
import com.jrancsar.genesis.dto.asociacion.CargoAdministrativoEntityDTO;
import com.jrancsar.genesis.services.asociacion.CargoAdministrativoService;

@RestController
@RequestMapping(value= "/cargoAdministrativos")
public class CargoAdministrativoResource {
	
	@Autowired
	private CargoAdministrativoService service;
	
	@GetMapping
	public ResponseEntity<List <CargoAdministrativoEntityDTO>> findAll(){		
		List<CargoAdministrativoEntityDTO> listEntityDTO =service.findAll().stream().map(objeto -> new CargoAdministrativoEntityDTO(objeto)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listEntityDTO);
	}
	
	@GetMapping(value = "/activos")
	public ResponseEntity<List <CargoAdministrativoDTO>> findByActivoTrue(){		
		List<CargoAdministrativoDTO> listDTO = service.findByActivoTrue().stream().map(objeto -> new CargoAdministrativoDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{idCargoAdministrativo}")
	public ResponseEntity<CargoAdministrativoEntityDTO> findById(@PathVariable Integer idCargoAdministrativo){
		CargoAdministrativoEntityDTO objetoEntityDTO = new  CargoAdministrativoEntityDTO(service.findById(idCargoAdministrativo));
		return ResponseEntity.ok().body(objetoEntityDTO);		
	}
	
	@PostMapping
	public ResponseEntity<CargoAdministrativoEntityDTO> insert(@Valid @RequestBody CargoAdministrativoDTOSet objetoDTOSet){			
		CargoAdministrativoEntityDTO objetoEntityDTO = new CargoAdministrativoEntityDTO(service.insert(service.fromDTO(objetoDTOSet)), service.getExiste());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCargoAdministrativo}").buildAndExpand(objetoEntityDTO.getIdCargoAdministrativo()).toUri();
		return ResponseEntity.created(uri).body(objetoEntityDTO);
	}
	@DeleteMapping(value = "/{idCargoAdministrativo}")
	public ResponseEntity<Void> delete(@PathVariable Integer idCargoAdministrativo){
		service.delete(idCargoAdministrativo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{idCargoAdministrativo}")
	public ResponseEntity<CargoAdministrativoEntityDTO> update(@Valid @PathVariable Integer idCargoAdministrativo, @RequestBody CargoAdministrativoEntityDTO objetoEntityDTO){
		objetoEntityDTO = new CargoAdministrativoEntityDTO(service.update(idCargoAdministrativo, objetoEntityDTO), service.getExiste());
		return ResponseEntity.ok().body(objetoEntityDTO);
	}
}
