package com.cpena.previred.backend.apirest.sevice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessageEnum {
	
	EMPRESA_YA_REGISTRADA("EMPRESA_01", "Empresa ya existe registrada"),
	RUT_EMPRESA_NO_VALIDO("EMPRESA_02", "Rut empresa no valido"),
	EMPRESA_NO_ENCONTRADA("EMPRESA_03", "Empresa no encontrada con valor entregado"),
	RUT_OR_IDENTIFICADOR_YA_EXISTE("EMPRESA_04", "Rut o identificador de empresa ya existe"),
	RUT_NO_REGISTRADO("TRABAJADOR_05", "Trabajador no registrado con Rut ingresad"),
	ID_TRABAJADOR_NO_CORRESPONDE("TRABAJADOR_06", "Id de trabajador no corresponde");
	
	private final String code;
	private final String message;
	
	
}
