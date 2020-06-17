package com.jrancsar.genesis.services.seguridad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.entities.seguridad.Objeto;
import com.jrancsar.genesis.repositories.seguridad.ObjetoRepository;

@Service
public class ObjetoService {

	@Autowired
	private ObjetoRepository repository;
	
	public List<Objeto> findAll() {
		return repository.findAll();
	}
		
	public Objeto findById(Integer idObjeto) {		
		Optional<Objeto> objeto = repository.findById(idObjeto);
		return objeto.get();		
	}
}
