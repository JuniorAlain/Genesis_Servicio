package com.jrancsar.genesis.services.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.entities.seguridad.Perfil;
import com.jrancsar.genesis.repositories.seguridad.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;
	
	private Boolean existe = false;			
	
	public List<Perfil> findAll() {
		return repository.findAll();
	}
	
	public List<Perfil> findByActivoTrue() {
		return repository.findByActivoTrue();
	}
	/*
	public Perfil findById(Integer idPerfil) {		
		Optional<Perfil> objeto = repository.findById(idPerfil);
		return objeto.orElseThrow(()->new ResourceNotFoundException(idPerfil));
	}	
	
	@Transactional
	public Perfil insert(Perfil objeto) {						
		existe = repository.existsById(objeto.getIdPerfil());		
		if(existe) {			
			Optional<Perfil> existe = repository.findById(objeto.getIdPerfil());
			return existe.orElseThrow(()->new DatabaseException(objeto.getIdPerfil().toString()));
		}else {			
			return repository.save(objeto);
		}				
	}

	public Perfil fromDTO(PerfilDTOSet objetoDTOSet) {		
		return new Perfil(
				repository.findByIdPerfilMax(objetoDTOSet.getPerfilPadre()), 
				objetoDTOSet.getnPerfil(), 
				objetoDTOSet.getDescripcion(), 
				objetoDTOSet.getPerfilPadre(), 
				objetoDTOSet.getComando(), 
				objetoDTOSet.getActivo(), 
				repository.newVersion());		
	}
	
	@Transactional
	public void delete(Integer idPerfil) {
		try {
			repository.deleteById(idPerfil);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idPerfil);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Transactional
	public Perfil update(Integer idPerfil, PerfilEntityDTO objeto) {
		try {
			Perfil entity = repository.getOne(idPerfil);
			updateData(entity, objeto);			
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idPerfil);
		}
	}
	
	private void updateData(Perfil entity, PerfilEntityDTO objeto) {		
		if(entity.getVersion().equals(objeto.getVersion()) 
				&& entity.getIdPerfil().equals(objeto.getIdPerfil())) {
			entity.setnPerfil(objeto.getnPerfil()); 
			entity.setDescripcion(objeto.getDescripcion()); 
			entity.setPerfilPadre(objeto.getPerfilPadre()); 
			entity.setComando(objeto.getComando());
			entity.setActivo(objeto.getActivo());
			entity.setVersion(repository.newVersion());
			existe = true;
		}
	}
	*/
	public Boolean getExiste() {
		return existe;	
	}
}
