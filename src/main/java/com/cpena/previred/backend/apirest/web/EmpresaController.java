package com.cpena.previred.backend.apirest.web;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpena.previred.backend.apirest.sevice.business.EmpresaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/Empresa")
public class EmpresaController {
	
	private final EmpresaService empresaService;
	
	

}
