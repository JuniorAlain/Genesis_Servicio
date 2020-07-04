package com.jrancsar.genesis.resources.seguridad;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrancsar.genesis.dto.seguridad.PerfilDTO;
import com.jrancsar.genesis.dto.seguridad.PerfilEntityDTO;
import com.jrancsar.genesis.services.seguridad.PerfilService;

@RestController
@RequestMapping(value= "/perfiles")
public class PerfilResource {
	
	@Autowired	
	private PerfilService service;
			
	@GetMapping
	public ResponseEntity<List <PerfilEntityDTO>> findAll(){
	//public ResponseEntity<List <Perfil>> findAll(){
		//List<Perfil> listEntityDTO =service.findAll();
		List<PerfilEntityDTO> listEntityDTO =service.findAll().stream().map(objeto -> new PerfilEntityDTO(objeto)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listEntityDTO);
	}
	
	@GetMapping(value = "/activos")
	public ResponseEntity<List <PerfilDTO>> findByActivoTrue(){				
		List<PerfilDTO> listDTO = service.findByActivoTrue().stream().map(objeto -> new PerfilDTO(objeto)).collect(Collectors.toList());							
		return ResponseEntity.ok().body(listDTO);
	}
	/*
	@GetMapping(value = "/{idPerfil}")
	public ResponseEntity<PerfilEntityDTO> findById(@PathVariable Integer idPerfil){
		PerfilEntityDTO objetoEntityDTO = new  PerfilEntityDTO(service.findById(idPerfil));
		return ResponseEntity.ok().body(objetoEntityDTO);		
	}
	
	@PostMapping
	public ResponseEntity<PerfilEntityDTO> insert(@Valid @RequestBody PerfilDTOSet objetoDTOSet){			
		PerfilEntityDTO objetoEntityDTO = new PerfilEntityDTO(service.insert(service.fromDTO(objetoDTOSet)), service.getExiste());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPerfil}").buildAndExpand(objetoEntityDTO.getIdPerfil()).toUri();
		return ResponseEntity.created(uri).body(objetoEntityDTO);
	}
	@DeleteMapping(value = "/{idPerfil}")
	public ResponseEntity<Void> delete(@PathVariable Integer idPerfil){
		service.delete(idPerfil);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{idPerfil}")
	public ResponseEntity<PerfilEntityDTO> update(@Valid @PathVariable Integer idPerfil, @RequestBody PerfilEntityDTO objetoEntityDTO){
		objetoEntityDTO = new PerfilEntityDTO(service.update(idPerfil, objetoEntityDTO), service.getExiste());
		return ResponseEntity.ok().body(objetoEntityDTO);
	}
	*/
}
