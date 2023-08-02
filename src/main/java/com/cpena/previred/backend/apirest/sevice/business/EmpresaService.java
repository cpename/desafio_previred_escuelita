package com.cpena.previred.backend.apirest.sevice.business;

import java.util.Collection;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;
import com.cpena.previred.backend.apirest.domain.repositories.EmpresaRepository;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;
import com.cpena.previred.backend.apirest.sevice.dtos.UpdateEmpresaDto;
import com.cpena.previred.backend.apirest.sevice.dtos.exceptions.PreviredException;
import com.cpena.previred.backend.apirest.sevice.enums.ErrorMessageEnum;
import com.cpena.previred.backend.apirest.sevice.utils.GeneralUtils;

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
	
	/**
	 * Crea una empresa empresa en la base de datos.
	 * @param empresaDto
	 * @return empresaDto
	 */
	public EmpresaDto createEmpresa( EmpresaDto empresaDto ) {
		
		Empresa empresa = convertToEntity(empresaDto);
		Empresa nuevaEmpresa = empresaRepository.save(empresa);
		
		return convertToDto(nuevaEmpresa);
				
	}
	
	
	/**
	 * Modifca los datos de una empresa a partir de su id
	 * @param updateEmpresaDto
	 * @return EmpresaDto actualizada
	 */
	public EmpresaDto modificarEmpresa( UpdateEmpresaDto updateEmpresaDto, Long empresaId ) {
		EmpresaDto empresaActualDto = busquedaEmpresaPorId(empresaId);
		Empresa empresaActual = convertToEntity(empresaActualDto);
		
		empresaActual.setRazonSocial(empresaActualDto.getRazonSocial());
		empresaActual.setRut(empresaActualDto.getRut());
		empresaActual.setUpdateAt(new Date());
		empresaActual.setIdentificadorEmpresa(empresaActualDto.getIdentificadorEmpresa());
		
		return convertToDto( empresaRepository.save(empresaActual) );
	}
	
	/**
	 * Obtiene Empresa por id 
	 * @param id
	 * @return empresa
	 */
	public EmpresaDto busquedaEmpresaPorId(Long id) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow( () -> new PreviredException(HttpStatus.NOT_FOUND, ErrorMessageEnum.EMPRESA_NO_ENCONTRADA) );
		return convertToDto( empresa);
	}
	
	/**
	 * Obtiene Emprea a traves de su identificador
	 * @param identificadorEmpresa
	 * @return
	 */
	public EmpresaDto busquedaEmpresaPorIdentificador( String identificadorEmpresa ) {
		Empresa empresa = empresaRepository.findByIdentificadorEmpresa(identificadorEmpresa)
				.orElseThrow( () -> new PreviredException(HttpStatus.NOT_FOUND, ErrorMessageEnum.EMPRESA_NO_ENCONTRADA) );
		
		return convertToDto(empresa);
	}
	
	
	public EmpresaDto busquedaEmpresaPorRut( Integer rut) {
		Empresa empresa = empresaRepository.findByRut(rut)
				.orElseThrow( () -> new PreviredException(HttpStatus.NOT_FOUND, ErrorMessageEnum.EMPRESA_NO_ENCONTRADA));
		return convertToDto(empresa);
		
	}
	
	/**
	 * Borra empresa. Borrara los registos de la empresa y los trabajadores asociados a ella.
	 * @param id
	 */
	public void borraEmpresa( Long empresaId ) {				
		Empresa empresa = convertToEntity(busquedaEmpresaPorId(empresaId));		
		
		empresaRepository.delete(empresa);
	}
	
	/**
	 * Recibe una entidad empresa y la convierte o mapea a su respectivo DTO
	 * @param empresa tipo entity
	 * @return empresaDto
	 */
	
	private EmpresaDto convertToDto(Empresa empresa) {
		EmpresaDto empresaDto = modelMapper.map(empresa, EmpresaDto.class);
		return empresaDto;		
	}
	
	/**
	 * Convierte a entity de empresa después de mapear los valores de su respectivo Dto
	 * @param empresaDto
	 * @return empresa entity
	 */
	private Empresa convertToEntity( EmpresaDto empresaDto) {
		Empresa empresa = modelMapper.map(empresaDto, Empresa.class);
		
		return empresa;
	}


}
