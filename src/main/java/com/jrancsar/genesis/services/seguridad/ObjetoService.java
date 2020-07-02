package com.jrancsar.genesis.services.seguridad;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.dto.seguridad.ObjetoDTOSet;
import com.jrancsar.genesis.dto.seguridad.ObjetoEntityDTO;
import com.jrancsar.genesis.entities.seguridad.Objeto;
import com.jrancsar.genesis.repositories.seguridad.ObjetoRepository;
import com.jrancsar.genesis.services.exceptions.DatabaseException;
import com.jrancsar.genesis.services.exceptions.ResourceNotFoundException;

@Service
public class ObjetoService {

	@Autowired
	private ObjetoRepository repository;
	
	private Boolean existe = false;			
	
	public List<Objeto> findAll() {
		return repository.findAll();
	}
	
	public List<Objeto> findByActivoTrue() {
		return repository.findByActivoTrue();
	}
	
	public Objeto findById(Integer idObjeto) {		
		Optional<Objeto> objeto = repository.findById(idObjeto);
		return objeto.orElseThrow(()->new ResourceNotFoundException(idObjeto));
	}	
	
	@Transactional
	public Objeto insert(Objeto objeto) {						
		existe = repository.existsById(objeto.getIdObjeto());		
		if(existe) {			
			Optional<Objeto> existe = repository.findById(objeto.getIdObjeto());
			return existe.orElseThrow(()->new DatabaseException(objeto.getIdObjeto().toString()));
		}else {			
			return repository.save(objeto);
		}				
	}

	public Objeto fromDTO(ObjetoDTOSet objetoDTOSet) {		
		return new Objeto(
				repository.findByIdObjetoMax(objetoDTOSet.getObjetoPadre()), 
				objetoDTOSet.getnObjeto(), 
				objetoDTOSet.getDescripcion(), 
				objetoDTOSet.getObjetoPadre(), 
				objetoDTOSet.getComando(), 
				objetoDTOSet.getActivo(), 
				repository.newVersion());		
	}
	
	@Transactional
	public void delete(Integer idObjeto) {
		try {
			repository.deleteById(idObjeto);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idObjeto);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Transactional
	public Objeto update(Integer idObjeto, ObjetoEntityDTO objeto) {
		try {
			Objeto entity = repository.getOne(idObjeto);
			updateData(entity, objeto);			
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idObjeto);
		}
	}
	
	private void updateData(Objeto entity, ObjetoEntityDTO objeto) {		
		if(entity.getVersion().equals(objeto.getVersion()) 
				&& entity.getIdObjeto().equals(objeto.getIdObjeto())) {
			entity.setnObjeto(objeto.getnObjeto()); 
			entity.setDescripcion(objeto.getDescripcion()); 
			entity.setObjetoPadre(objeto.getObjetoPadre()); 
			entity.setComando(objeto.getComando());
			entity.setActivo(objeto.getActivo());
			entity.setVersion(repository.newVersion());
			existe = true;
		}
	}
	
	public Boolean getExiste() {
		return existe;	
	}
}
