package com.cpena.previred.backend.apirest.sevice.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmpresaDto {
	
	private Long id;
	private Integer rut;
	private String razonSocial;
	private Date createAt;
	private Date updateAt;
	private String identificadorEmpresa;
	
}
