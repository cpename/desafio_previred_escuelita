package com.cpena.previred.backend.apirest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.previred.backend.apirest.domain.entities.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

}
