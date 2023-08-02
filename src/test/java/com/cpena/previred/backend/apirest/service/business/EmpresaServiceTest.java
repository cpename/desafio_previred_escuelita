package com.cpena.previred.backend.apirest.service.business;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import com.cpena.previred.backend.apirest.domain.entities.Empresa;
import com.cpena.previred.backend.apirest.domain.repositories.EmpresaRepository;
import com.cpena.previred.backend.apirest.sevice.business.EmpresaService;
import com.cpena.previred.backend.apirest.sevice.dtos.EmpresaDto;
import com.cpena.previred.backend.apirest.sevice.dtos.UpdateEmpresaDto;
import com.cpena.previred.backend.apirest.sevice.dtos.exceptions.PreviredException;
import com.cpena.previred.backend.apirest.sevice.enums.ErrorMessageEnum;
import com.cpena.previred.backend.apirest.sevice.utils.GeneralUtils;
import com.cpena.previred.backend.apirest.utils.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
//@AutoConfigureMockMvc
@Sql("classpath:/init/empresa-data.sql")
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class EmpresaServiceTest extends ServiceTest {
	
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
//	@Autowired
//	private MockMvc mockMvc;
	
	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll exceuted");
	}
	
	@BeforeEach
	void setupThis() {
		System.out.println("@BeforeEach excecuted");
	}
	
	
	
	@Test
	@Order(1)
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testCreateEmpresa() {
		
//		Given
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setIdentificadorEmpresa("XXXX123456");
		empresaDto.setRazonSocial("nueva razon social");
		empresaDto.setCreateAt(new Date());
		empresaDto.setRut(130275613);
		
 //		when
		EmpresaDto nuevaEmpresaDto = empresaService.createEmpresa(empresaDto);
//		then
		assertEquals("XXXX123456", nuevaEmpresaDto.getIdentificadorEmpresa());
		assertEquals("nueva razon social", nuevaEmpresaDto.getRazonSocial());
		assertEquals(dateFormatter.format(new Date()), dateFormatter.format(nuevaEmpresaDto.getCreateAt()));
		assertNull(nuevaEmpresaDto.getUpdateAt());
		assertEquals(130275613, nuevaEmpresaDto.getRut());		
	}
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testModificarEmpresa() {		
//		Given
		UpdateEmpresaDto updateEmpresaDto = new UpdateEmpresaDto();
		updateEmpresaDto.setIdentificadorEmpresa("NUEVA-IDENTI999");
		updateEmpresaDto.setRazonSocial("Nueva Razon Social");
		updateEmpresaDto.setRut(76372725);
//		When
		Empresa empresa = empresaRepository.findById(99991L).get();		
		EmpresaDto empresaDto = empresaService.modificarEmpresa(updateEmpresaDto,empresa.getId() );
//		Then
		assertEquals(empresaDto.getId(), empresa.getId());
		assertEquals(empresaDto.getRazonSocial(), updateEmpresaDto.getRazonSocial());
	}
	
	@Test
	@Order(2)
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBusquedaEmpresaPorRut() {
//		given
		Integer rutEmpresa = 78827280;		
//		when
		EmpresaDto empresaDto = empresaService.busquedaEmpresaPorRut(rutEmpresa);		
//		then
		assertEquals(rutEmpresa, empresaDto.getRut());
		assertEquals(9999L, empresaDto.getId());		
		assertEquals("Ki Teknology", empresaDto.getRazonSocial());
		assertEquals("4b2cf10-29072023-AB93", empresaDto.getIdentificadorEmpresa());
	}
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBusquedaEmpresaPorId() {
//		given
		Long empresaId = 9999L;
//		when
		EmpresaDto empresaDto = empresaService.busquedaEmpresaPorId(empresaId);
//		then
		assertEquals(9999L, empresaDto.getId());
		assertEquals(78827280, empresaDto.getRut());
		assertEquals("Ki Teknology", empresaDto.getRazonSocial());
		assertEquals("4b2cf10-29072023-AB93", empresaDto.getIdentificadorEmpresa());
	}
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBusquedaEmpresaPorIdentificador() {
//		given
		String identificadorEmpresa = "4b2cf10-29072023-AB93";
//		when
		EmpresaDto empresaDto = empresaService.busquedaEmpresaPorIdentificador(identificadorEmpresa);		
//		then
		assertEquals("4b2cf10-29072023-AB93", empresaDto.getIdentificadorEmpresa());
		assertEquals(9999L, empresaDto.getId());
		assertEquals(78827280, empresaDto.getRut());
		assertEquals("Ki Teknology", empresaDto.getRazonSocial());
	}
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBorraEmpresa() {
//		given
		Long empresaId = 9999L;
		EmpresaDto empresaAuxDto = empresaService.busquedaEmpresaPorId(empresaId);
//		when
		empresaService.borraEmpresa(empresaId);
		PreviredException exception = assertThrows(PreviredException.class, () -> empresaService.busquedaEmpresaPorId(empresaId));
//		then		
		assertEquals(9999L, empresaAuxDto.getId());
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getMessage(), exception.getError().getErrorMessage());		
	}
	
	@Test
	void testObtenerEmpresas() {
//		given
//		when		
		List<EmpresaDto> empresas = empresaService.obtenerEmpresas();
//		then
		assertNotNull(empresas);
		
	}
	
	// ******
	// test exceptions
	// *****
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBusquedaEmpresaPorIdNotFound() {
//		given
		Long empresaId = 19999L;
//		when
		PreviredException exception = assertThrows(PreviredException.class, () -> empresaService.busquedaEmpresaPorId(empresaId));
//		then
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getMessage(), exception.getError().getErrorMessage());
	}
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBusquedaEmpresaPorIdentificadorNotFound() {
//		given
		String identificadorEmpresa = "4b2cf10-29072023";
//		when
		PreviredException exception = assertThrows(PreviredException.class, () -> empresaService.busquedaEmpresaPorIdentificador(identificadorEmpresa));
//		then
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getMessage(), exception.getError().getErrorMessage());
	}
	
	@Test
//	@SqlGroup({		
//		@Sql(value = "classpath:init/empresa-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	})
	void testBusquedaEmpresaPorRutNotFound() {
//		given
		Integer rutEmpresa = 78827280;
//		when
		PreviredException exception = assertThrows(PreviredException.class, () -> empresaService.busquedaEmpresaPorRut(rutEmpresa));
//		then
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.EMPRESA_NO_ENCONTRADA.getMessage(), exception.getError().getErrorMessage());
	}

}
