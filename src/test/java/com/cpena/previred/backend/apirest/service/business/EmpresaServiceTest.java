package com.cpena.previred.backend.apirest.service.business;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cpena.previred.backend.apirest.domain.repositories.EmpresaRepository;
import com.cpena.previred.backend.apirest.sevice.business.EmpresaService;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmpresaServiceTest {
	
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll exceuted");
	}
	
	@BeforeEach
	void setupThis() {
		System.out.println("@BeforeEach excecuted");
	}
	
	
	
	@Test	
	void testAgregarEmpresa() throws InvocationTargetException {
		
//		Given
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setIdentificadorEmpresa("XXXX123456");
		empresaDto.setRazonSocial("nueva razon social");
		empresaDto.setCreateAt(new Date());
		empresaDto.setRut(13027561);
		
 //		when
		EmpresaDto nuevaEmpresaDto = empresaService.createEmpresa(empresaDto);
//		then
		assertEquals("XXXX123456", nuevaEmpresaDto.getIdentificadorEmpresa());
	}

}
