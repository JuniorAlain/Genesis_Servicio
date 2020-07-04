package com.jrancsar.genesis.repositories.seguridad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrancsar.genesis.entities.seguridad.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	
	List<Perfil> findByActivoTrue();
	/*
	@Query(value = ""
			+ "SELECT "
			+ "p.idPerfil"			
			+ " FROM Seguridad_tbPerfil p "
			//+ "WHERE u.nombreCompleto LIKE %?1% "
	, nativeQuery = true)
			
	List<Perfil> findAllByPerfil();*/
}
