package com.cpena.previred.backend.apirest.sevice.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TrabajadorDto {
	
	private Long id;
	private Integer rut;
	private String nombre;
	private String apellido;
	private String direccion;
	private Date createAt;
	private Date updateAt;

}
