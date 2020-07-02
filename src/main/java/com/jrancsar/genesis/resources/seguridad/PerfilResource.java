package com.jrancsar.genesis.resources.seguridad;

import java.net.URI;
import java.util.List;

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

import com.jrancsar.genesis.entities.seguridad.Perfil;
import com.jrancsar.genesis.services.seguridad.PerfilService;

@RestController
@RequestMapping(value= "/perfiles")
public class PerfilResource {
	
	@Autowired
	private PerfilService service;
	
	@GetMapping
	public ResponseEntity<List <Perfil>> findAll(){		
		List<Perfil> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{idPerfil}")
	public ResponseEntity<Perfil> findById(@PathVariable Integer idPerfil){
		Perfil objeto = service.findById(idPerfil);
		return ResponseEntity.ok().body(objeto);		
	}	
	
	@PostMapping
	public ResponseEntity<Perfil> insert(@RequestBody Perfil objeto){
		objeto = service.insert(objeto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPerfil}").buildAndExpand(objeto.getIdPerfil()).toUri();
		return ResponseEntity.created(uri).body(objeto);
	}
	
	@DeleteMapping(value = "/{idPerfil}")
	public ResponseEntity<Void> delete(@PathVariable Integer idPerfil){
		service.delete(idPerfil);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{idPerfil}")
	public ResponseEntity<Perfil> update(@PathVariable Integer idPerfil, @RequestBody Perfil objeto){
		objeto = service.update(idPerfil, objeto);
		return ResponseEntity.ok().body(objeto);
	}
	
	/*
	@GetMapping(value = "/perfil")
	public ResponseEntity<List <Perfil>> findAllByPerfil(){
		List<Perfil> listObjeto = service.findAllByPerfil();		
		return ResponseEntity.ok().body(listObjeto);		
	}*/
}
