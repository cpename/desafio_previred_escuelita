package com.cpena.previred.backend.apirest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpena.previred.backend.apirest.sevice.business.EmpresaService;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;
import com.cpena.previred.backend.apirest.sevice.dtos.UpdateEmpresaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class EmpresaController {
	
	@Autowired
	private final EmpresaService empresaService;
	
	@GetMapping(value = "/empresas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpresaDto>> obtenerEmpreas(){
		
		List<EmpresaDto> empresasDto = empresaService.obtenerEmpresas();
		
		return ResponseEntity.ok(empresasDto);
	}
	
	@GetMapping(value = "/empresas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaDto> getEmpresaPorId(@PathVariable Long id){
		
		EmpresaDto empresaDto = empresaService.busquedaEmpresaPorId(id);
		
		return ResponseEntity.ok(empresaDto);
	}
	
	
	@GetMapping(value = "/empresas/rut/{rut}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaDto> getEmpresaPorRut(@NotNull @PathVariable Integer rut){
		
		EmpresaDto empresaDto = empresaService.busquedaEmpresaPorRut(rut);
		
		return ResponseEntity.ok(empresaDto);
	}
	
	@GetMapping(value = "/empresas/identificador{identificador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaDto> getEmpresaPorRut(@PathVariable String identificador){
		
		EmpresaDto empresaDto = empresaService.busquedaEmpresaPorIdentificador(identificador);
		
		return ResponseEntity.ok(empresaDto);
	}
	
	
	@PostMapping(value = "/empresas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaDto> createEmpresa(@RequestBody @Valid @NotNull EmpresaDto empresaDto ){
		
		EmpresaDto nuevaEmpresaDto = empresaService.createEmpresa(empresaDto);
		
		return ResponseEntity.ok(nuevaEmpresaDto);
	}
	
	@PostMapping(value = "/empresas/{empresaId}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createEmpresa(@PathVariable Long empresaId ){
		empresaService.borraEmpresa(empresaId);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/empresas/{idEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaDto> modificaEmpresa( 	@RequestBody @Valid @NotNull UpdateEmpresaDto updateEmpresaDto, 
													 	@PathVariable Long idEmpresa ){
		EmpresaDto empresaDto = empresaService.modificarEmpresa(updateEmpresaDto, idEmpresa);
		
		return ResponseEntity.ok(empresaDto);
	}
	

}
