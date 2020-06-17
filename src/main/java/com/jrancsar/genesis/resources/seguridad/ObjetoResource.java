package com.jrancsar.genesis.resources.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrancsar.genesis.entities.seguridad.Objeto;
import com.jrancsar.genesis.services.seguridad.ObjetoService;

@RestController
@RequestMapping(value= "/objetos")
public class ObjetoResource {
	
	@Autowired
	private ObjetoService service;
	
	@GetMapping
	public ResponseEntity<List <Objeto>> findAll(){		
		List<Objeto> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{idObjeto}")
	public ResponseEntity<Objeto> findById(@PathVariable Integer idObjeto){
		Objeto objeto = service.findById(idObjeto);
		return ResponseEntity.ok().body(objeto);		
	}	
}
