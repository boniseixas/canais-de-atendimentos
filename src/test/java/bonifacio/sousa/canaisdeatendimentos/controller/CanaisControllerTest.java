package bonifacio.sousa.canaisdeatendimentos.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import bonifacio.sousa.canaisdeatendimentos.controller.dto.CanaisDeAtendimentoEletronicoDto;
import bonifacio.sousa.canaisdeatendimentos.repository.CanaisRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.CanaisDeAtendimentoEletronico;

class CanaisControllerTest {
	
	private CanaisController controller;
	
	@Mock
	private CanaisRepository repository, save;
	
	//@Mock
	//private Object cadastrar;
	
	@BeforeEach
	public void beforeEach() {
		
		MockitoAnnotations.openMocks(this);
		this.controller = new CanaisController(repository);
		
		MockitoAnnotations.openMocks(this);
		new CanaisDeAtendimentoEletronico();
		
		//MockitoAnnotations.openMocks(this);
		//this.controller = new CanaisController(save);
	}

	@Test
	void TestaCanaisController() {
		CanaisController mock = Mockito.mock(CanaisController.class);
		List<CanaisDeAtendimentoEletronicoDto> list = mock.canais(null);
		
		assertTrue(list.isEmpty());
		controller.canais(null);
		
		 verify(repository);
		
	}
	
	@Test
	void ChamaUmaListaDeCanaisDeAtendimentoEletronico () {
		CanaisController mock = Mockito.mock(CanaisController.class);
		List<CanaisDeAtendimentoEletronicoDto> list = mock.canais(null);
		
		assertTrue(list.isEmpty());
		
	}
	
	@Test
	void CadastraUmCanalDeAtendimentoEletronico () {
		CanaisController mock = Mockito.mock(CanaisController.class);
		List<CanaisDeAtendimentoEletronicoDto> cadastro = mock.canais(null);
		ResponseEntity.created(null);
		
		controller.cadastrar(null, null);
		
		assertTrue(cadastro.addAll(cadastro));
		//Mockito.verify(null, null);
		
	}

	@Test
	void DetalhaUmCanalDeAtendimentoEletronico () {
		CanaisController mock = Mockito.mock(CanaisController.class);
		List<CanaisDeAtendimentoEletronicoDto> detalha = mock.canais(null);
		ResponseEntity.ok(null);
			
		controller.detalhar(null);
			
		assertFalse(detalha.addAll(detalha));
		//Mockito.verify(repository);
			
	}
	
	@Test
	void AtualizaUmCanalDeAtendimentoEletronico () {
		CanaisController mock = Mockito.mock(CanaisController.class);
		List<CanaisDeAtendimentoEletronicoDto> atualiza = mock.canais(null);
		ResponseEntity.ok(null);
			
		//controller.atualizar(null);
			
		assertFalse(atualiza.addAll(atualiza));
		//Mockito.verify(save);
			
	}
	
	@Test
	void RemoveUmCanalDeAtendimentoEletronico () {
		CanaisController mock = Mockito.mock(CanaisController.class);
		List<CanaisDeAtendimentoEletronicoDto> remove = mock.canais(null);
		ResponseEntity.ok(null);
			
		//controller.atualizar(null);
			
		assertFalse(remove.addAll(remove));
		Mockito.verify(save);
			
	}
}
