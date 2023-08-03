package com.cpena.previred.backend.apirest.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.cpena.previred.backend.apirest.domain.entities.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
	
	Optional<Trabajador> findByRut(@NonNull Integer rut);
	
	

}
