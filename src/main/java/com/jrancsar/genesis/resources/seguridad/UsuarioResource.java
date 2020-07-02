package com.jrancsar.genesis.resources.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrancsar.genesis.entities.seguridad.Usuario;
import com.jrancsar.genesis.services.seguridad.UsuarioService;

@RestController
@RequestMapping(value= "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List <Usuario>> findAll(){		
		List<Usuario> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{login}")
	public ResponseEntity<Usuario> findById(@PathVariable String login){
		Usuario objeto = service.findById(login);
		return ResponseEntity.ok().body(objeto);		
	}
}
