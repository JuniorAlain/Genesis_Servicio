package com.jrancsar.genesis.resources.seguridad;

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

import com.jrancsar.genesis.dto.seguridad.ObjetoDTO;
import com.jrancsar.genesis.dto.seguridad.ObjetoDTOSet;
import com.jrancsar.genesis.dto.seguridad.ObjetoEntityDTO;
import com.jrancsar.genesis.services.seguridad.ObjetoService;

@RestController
@RequestMapping(value= "/objetos")
public class ObjetoResource {
	
	@Autowired
	private ObjetoService service;
	
	@GetMapping
	public ResponseEntity<List <ObjetoEntityDTO>> findAll(){		
		List<ObjetoEntityDTO> listEntityDTO =service.findAll().stream().map(objeto -> new ObjetoEntityDTO(objeto)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listEntityDTO);
	}
	
	@GetMapping(value = "/activos")
	public ResponseEntity<List <ObjetoDTO>> findByActivoTrue(){		
		List<ObjetoDTO> listDTO = service.findByActivoTrue().stream().map(objeto -> new ObjetoDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{idObjeto}")
	public ResponseEntity<ObjetoEntityDTO> findById(@PathVariable Integer idObjeto){
		ObjetoEntityDTO objetoEntityDTO = new  ObjetoEntityDTO(service.findById(idObjeto));
		return ResponseEntity.ok().body(objetoEntityDTO);		
	}
	
	@PostMapping
	public ResponseEntity<ObjetoEntityDTO> insert(@Valid @RequestBody ObjetoDTOSet objetoDTOSet){			
		ObjetoEntityDTO objetoEntityDTO = new ObjetoEntityDTO(service.insert(service.fromDTO(objetoDTOSet)), service.getExiste());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idObjeto}").buildAndExpand(objetoEntityDTO.getIdObjeto()).toUri();
		return ResponseEntity.created(uri).body(objetoEntityDTO);
	}
	@DeleteMapping(value = "/{idObjeto}")
	public ResponseEntity<Void> delete(@PathVariable Integer idObjeto){
		service.delete(idObjeto);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{idObjeto}")
	public ResponseEntity<ObjetoEntityDTO> update(@Valid @PathVariable Integer idObjeto, @RequestBody ObjetoEntityDTO objetoEntityDTO){
		objetoEntityDTO = new ObjetoEntityDTO(service.update(idObjeto, objetoEntityDTO), service.getExiste());
		return ResponseEntity.ok().body(objetoEntityDTO);
	}
}
