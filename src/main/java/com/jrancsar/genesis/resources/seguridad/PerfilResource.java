package com.jrancsar.genesis.resources.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Perfil> findById(@PathVariable Long idPerfil){
		Perfil objeto = service.findById(idPerfil);
		return ResponseEntity.ok().body(objeto);		
	}
	
}
