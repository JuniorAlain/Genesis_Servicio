package com.jrancsar.genesis.repositories.seguridad;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrancsar.genesis.entities.seguridad.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	/*
	@Query(value = ""
			+ "SELECT "
			+ "p.idPerfil"			
			+ " FROM Seguridad_tbPerfil p "
			//+ "WHERE u.nombreCompleto LIKE %?1% "
	, nativeQuery = true)
			
	List<Perfil> findAllByPerfil();*/
}
