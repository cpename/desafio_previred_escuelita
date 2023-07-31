package com.cpena.previred.backend.apirest.sevice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessageEnum {
	
	EMPRESA_YA_REGISTRADA("EMPRESA_01", "Empresa ya existe registrada"),
	RUT_EMPRESA_NO_VALIDO("EMPRESA_02", "Rut empresa no valido");
	
	private final String code;
	private final String message;
	
	
}
