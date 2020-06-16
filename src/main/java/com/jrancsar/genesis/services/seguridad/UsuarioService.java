package com.jrancsar.genesis.services.seguridad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrancsar.genesis.entities.seguridad.Usuario;
import com.jrancsar.genesis.repositories.seguridad.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
		
	public Usuario findById(String login) {		
		Optional<Usuario> objeto = repository.findById(login);
		return objeto.get();		
	}
}
