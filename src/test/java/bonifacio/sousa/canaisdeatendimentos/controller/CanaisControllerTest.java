package bonifacio.sousa.canaisdeatendimentos.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
	private CanaisRepository repository;
	
	//@Mock
	//private Object cadastrar;
	
	@BeforeEach
	public void beforeEach() {
		
		MockitoAnnotations.openMocks(this);
		this.controller = new CanaisController(repository);
		
		MockitoAnnotations.openMocks(this);
		new CanaisDeAtendimentoEletronico();
	}

	@SuppressWarnings("unused")
	@Test
	void TestaCanaisController () {
		CanaisController mock = Mockito.mock(CanaisController.class);
		//List<CanaisDeAtendimentoEletronicoDto> list = mock.CanaisRepository(null);
		
		//assertTrue(list.isEmpty());
		
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
		
		assertTrue(cadastro.add(null));
		Mockito.verify(repository);
		
	}

}
