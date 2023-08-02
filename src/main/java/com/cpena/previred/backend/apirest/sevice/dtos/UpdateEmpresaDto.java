package com.cpena.previred.backend.apirest.sevice.dtos;

import org.hibernate.validator.constraints.Length;
import com.cpena.previred.backend.apirest.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateEmpresaDto {
	
	@NotBlank(message = Messages.RUT_EMPRESA_OBLIGATORIO)
	@Length(max = 9, message = Messages.RUT_EMPRESA_MUY_LARGO)
	private Integer rut;
	
	@Length(max = 250, message = Messages.RAZON_SOCIAL_MUY_LARGO)
	private String razonSocial;
	
	@Length(max = 50, message = Messages.IDENTIFICADOR_EMPRESA_MUY_LARTO)
	@Length(min = 10, message = Messages.IDENTIFICADOR_EMPRESA_MUY_CORTO)
	private String identificadorEmpresa;
	
}
