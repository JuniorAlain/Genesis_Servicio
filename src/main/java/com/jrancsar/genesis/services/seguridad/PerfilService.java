package com.jrancsar.genesis.services.seguridad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.entities.seguridad.Perfil;
import com.jrancsar.genesis.repositories.seguridad.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;
	
	public List<Perfil> findAll() {
		return repository.findAll();
	}
		
	public Perfil findById(Integer idPerfil) {		
		Optional<Perfil> objeto = repository.findById(idPerfil);
		return objeto.get();		
	}
}
