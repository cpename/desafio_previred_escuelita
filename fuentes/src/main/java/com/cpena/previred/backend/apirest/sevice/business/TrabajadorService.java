package com.cpena.previred.backend.apirest.sevice.business;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;
import com.cpena.previred.backend.apirest.domain.entities.Trabajador;
import com.cpena.previred.backend.apirest.domain.repositories.TrabajadorRepository;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;
import com.cpena.previred.backend.apirest.sevice.dtos.TrabajadorDto;
import com.cpena.previred.backend.apirest.sevice.dtos.exceptions.PreviredException;
import com.cpena.previred.backend.apirest.sevice.enums.ErrorMessageEnum;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class TrabajadorService {
	
	@Autowired
	TrabajadorRepository trabajadorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Obtiene trabajador segun rut
	 * @param rut
	 * @return trabajdor Dto
	 */
	public TrabajadorDto getTrabajadorByRut( Integer rut ) {
		Trabajador trabajador = trabajadorRepository.findByRut(rut)
				.orElseThrow( () -> new PreviredException(HttpStatus.NOT_FOUND, ErrorMessageEnum.RUT_NO_REGISTRADO) );
		
		return convertToDto(trabajador);
	}
	
	/**
	 * Borra trabajador según id
	 * @param idTrabajador
	 */
	public void deleteTrabajador(Long idTrabajador) {
		Optional<Trabajador> trabajadorOpt = trabajadorRepository.findById(idTrabajador);
		if(trabajadorOpt.isEmpty()) {
			throw new PreviredException(HttpStatus.NOT_FOUND, ErrorMessageEnum.ID_TRABAJADOR_NO_CORRESPONDE);
		}
		trabajadorRepository.delete(trabajadorOpt.get());
	}
	
	
	
	
	/**
	 * Recibe una entidad empresa y la convierte o mapea a su respectivo DTO
	 * @param empresa tipo entity
	 * @return empresaDto
	 */
	
	private TrabajadorDto convertToDto(Trabajador trabajdor) {
		TrabajadorDto trabajadorDto = modelMapper.map(trabajdor, TrabajadorDto.class);
		return trabajadorDto;		
	}
	
	/**
	 * Convierte a entity de empresa después de mapear los valores de su respectivo Dto
	 * @param empresaDto
	 * @return empresa entity
	 */
	private Trabajador convertToEntity( TrabajadorDto trabajadorDto) {
		Trabajador trabajador = modelMapper.map(trabajadorDto, Trabajador.class);
		
		return trabajador;
	}
	

}
