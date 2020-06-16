package com.jrancsar.genesis.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jrancsar.genesis.entities.asociacion.CargoAdministrativo;
import com.jrancsar.genesis.entities.seguridad.Usuario;
import com.jrancsar.genesis.repositories.asociacion.CargoAdministrativoRepository;
import com.jrancsar.genesis.repositories.seguridad.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CargoAdministrativoRepository cargoAdministrativoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		CargoAdministrativo cargoAdministrativo1 = new CargoAdministrativo(null, "DESARROLO", true);
		CargoAdministrativo cargoAdministrativo2 = new CargoAdministrativo(null, "GERENTE", true);
		CargoAdministrativo cargoAdministrativo3 = new CargoAdministrativo(null, "SECRETARIO(A)", true);		
		
		Usuario usuario1 = new Usuario("jcontreras", "73748075", "CONTRERAS", "AGUILAR", "JUNIOR ALAIN",
				"12345678", Instant.parse("2020-06-15T21:49:15Z"), "sys", null, null, null, true, cargoAdministrativo1);
		
		Usuario usuario2 = new Usuario("wsardon", "12345678", "SARDON", "QUISPE", "WILSON",
				"12345678", Instant.parse("2020-06-15T21:49:15Z"), "sys", null, null, null, true, cargoAdministrativo2);
		
		Usuario usuario3 = new Usuario("squispe", "12345678", "QUISPE", "QUISPE", "SARA",
				"12345678", Instant.parse("2020-06-15T21:49:15Z"),"sys", null, null, null, true, cargoAdministrativo3);
		
		cargoAdministrativoRepository.saveAll(Arrays.asList(cargoAdministrativo1,cargoAdministrativo2, cargoAdministrativo3));
		
		usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2,usuario3));
	}
	
	
	
}
