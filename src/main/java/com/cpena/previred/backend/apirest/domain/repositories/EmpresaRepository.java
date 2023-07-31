package com.cpena.previred.backend.apirest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
