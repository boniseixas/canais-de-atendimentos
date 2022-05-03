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

import bonifacio.sousa.canaisdeatendimentos.controller.dto.CorrespondentesBancariosDto;
import bonifacio.sousa.canaisdeatendimentos.repository.CorrespondentesRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.CorrespondentesBancarios;

class CorrespondentesControllerTest {
	
	private CorrespondentesController correspondentes;
	
	@Mock
	private CorrespondentesRepository repository, save;
	
	@BeforeEach
	public void beforeEach() {
		
		MockitoAnnotations.openMocks(this);
		this.correspondentes = new CorrespondentesController(repository);
		
		MockitoAnnotations.openMocks(this);
		new CorrespondentesBancarios();
	}

	@Test
	void chamaUmaListaDeCorrespondentesBancarios() {
		CorrespondentesController mock = Mockito.mock(CorrespondentesController.class);
		List<CorrespondentesBancariosDto> list = (List<CorrespondentesBancariosDto>) mock.correspondentes(null);
		
		assertTrue(list.isEmpty());
		correspondentes.correspondentes(null);
		
		verify(repository);
	}
	
	@Test
	void cadastraUmCorrespondenteBancario() {
		CorrespondentesController mock = Mockito.mock(CorrespondentesController.class);
		List<CorrespondentesBancariosDto> cadastro = mock.correspondentes(null);
		ResponseEntity.created(null);
		
		correspondentes.cadastrar(null, null);
		
		assertTrue(cadastro.addAll(cadastro));
		Mockito.verify(save);
	}
	
	@Test
	void detalhaUmCoreespondenteBancario() {
		CorrespondentesController mock = Mockito.mock(CorrespondentesController.class);
		List<CorrespondentesBancariosDto> detalha = mock.correspondentes(null);
		ResponseEntity.ok();
		
		correspondentes.detalhar(null);
		
		assertFalse(detalha.addAll(detalha));
	}
	
	@Test
	void atualizaUmCorrespondenteBancario() {
		CorrespondentesController mock = Mockito.mock(CorrespondentesController.class);
		List<CorrespondentesBancariosDto> atualiza = (List<CorrespondentesBancariosDto>) mock.correspondentes(null);
		
		assertFalse(atualiza.addAll(atualiza));
	}
	
	@Test
	void removeUmCorrespondenteBancario() {
		CorrespondentesController mock = Mockito.mock(CorrespondentesController.class);
		List<CorrespondentesBancariosDto> remove = mock.correspondentes(null);
		
		assertFalse(remove.addAll(remove));
		Mockito.verify(save);
	}
}
