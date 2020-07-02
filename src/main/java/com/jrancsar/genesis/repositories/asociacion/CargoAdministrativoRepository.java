package com.jrancsar.genesis.repositories.asociacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;

public interface CargoAdministrativoRepository extends JpaRepository<CargoAdministrativo, Integer>{
	
	List<CargoAdministrativo> findByActivoTrue();
	
	@Query(value = "SELECT MAX(a_ca.idCargoAdministrativo)+1 nextId FROM Asociacion_tbCargoAdministrativo a_ca", 
			nativeQuery = true)
	Integer findByIdCargoAdministrativoMax();
	/*
	@Query(value = "SELECT MAX(a_ca.idCargoAdministrativo)+1 nextId FROM Asociacion_tbCargoAdministrativo a_ca", 
			nativeQuery = true)
	CargoAdministrativo save(Integer idCargoAdministrativo,String version);
	*/
	
	@Query(value = "SELECT MD5(CONV(UNIX_TIMESTAMP(NOW()),10,16)) newVersion", 
			nativeQuery = true)
	String newVersion();
}
