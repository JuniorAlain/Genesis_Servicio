package com.jrancsar.genesis.services.seguridad;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.entities.seguridad.Perfil;
import com.jrancsar.genesis.repositories.seguridad.PerfilRepository;
import com.jrancsar.genesis.services.exceptions.DatabaseException;
import com.jrancsar.genesis.services.exceptions.ResourceNotFoundException;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;
	
	public List<Perfil> findAll() {
		return repository.findAll();
	}
		
	public Perfil findById(Integer idPerfil) {		
		Optional<Perfil> objeto = repository.findById(idPerfil);
		return objeto.orElseThrow(() -> new ResourceNotFoundException(idPerfil));		
	}
	
	public Perfil insert(Perfil objeto) {
		return repository.save(objeto);
	}
	
	public void delete(Integer idPerfil) {
		try {
			repository.deleteById(idPerfil);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idPerfil);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Perfil update(Integer idPerfil, Perfil objeto) {
		try {
			Perfil entity = repository.getOne(idPerfil);
			updateData(entity, objeto);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idPerfil);
		}
	}

	private void updateData(Perfil entity, Perfil objeto) {
		entity.setnPerfil(objeto.getnPerfil());
		entity.setActivo(objeto.getActivo());
	}
	
	
	
	/*
	public List<Perfil> findAllByPerfil() {		
		return repository.findAllByPerfil();			
	}*/
}
