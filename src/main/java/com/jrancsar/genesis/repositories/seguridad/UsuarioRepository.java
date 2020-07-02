package com.jrancsar.genesis.repositories.seguridad;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrancsar.genesis.entities.seguridad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{		
}
