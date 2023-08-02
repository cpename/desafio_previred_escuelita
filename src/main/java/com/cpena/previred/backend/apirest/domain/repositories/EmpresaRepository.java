package com.cpena.previred.backend.apirest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;

import java.util.Collection;
import java.util.List;
import java.util.Optional;




public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Optional<Empresa> findByRut(@NonNull Integer rut);
	
    Optional<Empresa> findByIdentificadorEmpresa(@NonNull String identificadorEmpresa);
	
	
}
