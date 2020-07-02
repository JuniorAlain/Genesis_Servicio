package com.jrancsar.genesis.repositories.seguridad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jrancsar.genesis.entities.seguridad.Objeto;

public interface ObjetoRepository extends JpaRepository<Objeto, Integer>{
	
	List<Objeto> findByActivoTrue();
	
	@Query(value = "SELECT MAX(s_o.idObjeto)+1 nextId FROM Seguridad_tbObjeto s_o where s_o.objetoPadre = :objetoPadre", 
			nativeQuery = true)
	Integer findByIdObjetoMax(@Param("objetoPadre") Integer objetoPadre);
	
	@Query(value = "SELECT MD5(CONV(UNIX_TIMESTAMP(NOW()),10,16)) newVersion", 
			nativeQuery = true)
	String newVersion();
}
