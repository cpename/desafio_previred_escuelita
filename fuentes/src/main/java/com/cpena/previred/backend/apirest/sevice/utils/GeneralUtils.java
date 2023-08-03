package com.cpena.previred.backend.apirest.sevice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GeneralUtils {
	
	@Autowired
	static private ModelMapper modelMapper;
	
	/**
	 * Recibe una entidad empresa y la convierte o mapea a su respectivo DTO
	 * @param empresa tipo entity
	 * @return empresaDto
	 */
	
	public static EmpresaDto convertEmpresaToEmpresaDto(Empresa empresa) {
		EmpresaDto empresaDto = modelMapper.map(empresa, EmpresaDto.class);
		return empresaDto;		
	}
	
	/**
	 * Convierte a entity de empresa después de mapear los valores de su respectivo Dto
	 * @param empresaDto
	 * @return empresa entity
	 */
	public static Empresa convertEmpresaDtoToEmpresa( EmpresaDto empresaDto) {
		Empresa empresa = modelMapper.map(empresaDto, Empresa.class);
		
		return empresa;
	}

}
