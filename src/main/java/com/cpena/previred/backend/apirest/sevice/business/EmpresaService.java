package com.cpena.previred.backend.apirest.sevice.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;
import com.cpena.previred.backend.apirest.domain.repositories.EmpresaRepository;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public EmpresaDto createEmpresa( EmpresaDto empresaDto ) {
		
		Empresa empresa = convertToEntity(empresaDto);
		Empresa nuevaEmpresa = empresaRepository.save(empresa);
		
		return convertToDto(nuevaEmpresa);
		
		
	}
	
	private EmpresaDto convertToDto(Empresa empresa) {
		EmpresaDto empresaDto = modelMapper.map(empresa, EmpresaDto.class);
		return empresaDto;		
	}
	
	private Empresa convertToEntity( EmpresaDto empresaDto) {
		Empresa empresa = modelMapper.map(empresaDto, Empresa.class);
		
		return empresa;
	}

}
