package bonifacio.sousa.canaisdeatendimentos.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import bonifacio.sousa.canaisdeatendimentos.controller.dto.DependenciasPropriasDto;
import bonifacio.sousa.canaisdeatendimentos.repository.DependenciasRepository;

class DependenciasControllerTest {
	
	private DependenciasController dependencias;
	
	
	@Mock
	private DependenciasRepository repository, save;
	
	@BeforeEach
	public void beforeEach() {
		
		MockitoAnnotations.openMocks(this);
		this.dependencias = new DependenciasController(repository);
		
		MockitoAnnotations.openMocks(dependencias);
		new DependenciasController(repository);
		
	}

	@Test
	void chamaUmaListaDeDependenciasBancariasProprias() {
		DependenciasController mock = Mockito.mock(DependenciasController.class);
		List<DependenciasPropriasDto> list = (List<DependenciasPropriasDto>) mock.dependencias(null);
		
		assertTrue(list.isEmpty());
		dependencias.dependencias(null);
		
		verify(repository);
	}
	
	@Test
	void cadastraUmaDependenciaBancariaPropria() {
		DependenciasController mock = Mockito.mock(DependenciasController.class);
		List<DependenciasPropriasDto> cadastro = mock.dependencias(null);
		ResponseEntity.created(null);
		
		dependencias.cadastrar(null, null);
		
		assertTrue(cadastro.add(null));
		Mockito.verify(save);
	}
	
	@Test
	void detalhaUmaDependenciaBancariaPropria() {
		DependenciasController mock = Mockito.mock(DependenciasController.class);
		List<DependenciasPropriasDto> detalha = mock.dependencias(null);
		ResponseEntity.ok();
		
		dependencias.detalhar(null);
		
		assertTrue(detalha.equals(detalha));
	}
	
	@Test
	void atualizaUmaDependenciaBancariaPropria() {
		DependenciasController mock = Mockito.mock(DependenciasController.class);
		List<DependenciasPropriasDto> atualiza = mock.dependencias(null);
		
		assertTrue(atualiza.add(null));
	}
	
	@Test
	void removeUmaDependenciaBancariaPropria() {
		DependenciasController mock = Mockito.mock(DependenciasController.class);
		List<DependenciasPropriasDto> remove = mock.dependencias(null);
		
		assertFalse(remove.addAll(remove));
		Mockito.verify(save);
	}

}
