package com.cpena.previred.backend.apirest.sevice.dtos;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.cpena.previred.backend.apirest.constants.Messages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaDto {
	
	private Long id;
	
	@NotNull(message = Messages.RUT_EMPRESA_OBLIGATORIO)	
	private Integer rut;
	
	@Length(max = 250, message = Messages.RAZON_SOCIAL_MUY_LARGO)
	private String razonSocial;
	
	private Date createAt;
	
	private Date updateAt;	
	
	@Length(max = 50, message = Messages.IDENTIFICADOR_EMPRESA_MUY_LARTO)
	@Length(min = 10, message = Messages.IDENTIFICADOR_EMPRESA_MUY_CORTO)
	@NotBlank(message = Messages.IDENTIFICADOR_EMPRESA_OBLIGATORIO)
	private String identificadorEmpresa;
	
}
