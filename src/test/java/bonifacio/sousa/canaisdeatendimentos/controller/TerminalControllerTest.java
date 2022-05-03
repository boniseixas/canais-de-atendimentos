package bonifacio.sousa.canaisdeatendimentos.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import bonifacio.sousa.canaisdeatendimentos.controller.dto.TerminalDeAutoatendimentoCompartilhadoDto;
import bonifacio.sousa.canaisdeatendimentos.repository.TerminalRepository;

class TerminalControllerTest {
	
	private TerminalController terminal;
	
	@Mock
	private TerminalRepository repository, save;
	
	@BeforeEach
	public void beforeEach() {
		
		MockitoAnnotations.openMocks(this);
		this.terminal = new TerminalController(repository);
		
		MockitoAnnotations.openMocks(this);
		new TerminalController(repository);
	}

	@Test
	void chamaUmaListaDeTerminalDeAutoatendimentoCompartilhado() {
		TerminalController mock = Mockito.mock(TerminalController.class);
		List<TerminalDeAutoatendimentoCompartilhadoDto> list = mock.terminal(null);
		
		assertTrue(list.isEmpty());
		terminal.terminal(null);
		
		verify(repository);
	}
	
	@Test
	void cadastraUmaListaDeTerminalDeAutoatendimentoCompartilhado() {
		TerminalController mock = Mockito.mock(TerminalController.class);
		List<TerminalDeAutoatendimentoCompartilhadoDto> cadastro = mock.terminal(null);
		
		terminal.cadastrar(null, null);
		
		assertTrue(cadastro.addAll(cadastro));
		Mockito.verify(save);
	}
	
	@Test
	void detalhaUmaListaDeTerminalDeAutoatendimentoCompartilhado() {
		TerminalController mock = Mockito.mock(TerminalController.class);
		List<TerminalDeAutoatendimentoCompartilhadoDto> detalha = mock.terminal(null);
		
		terminal.detalhar(null);
		
		assertFalse(detalha.addAll(detalha));
	}
	
	@Test
	void atualizaUmaListaDeTerminalDeAutoatendimentoCompartilhado() {
		TerminalController mock = Mockito.mock(TerminalController.class);
		List<TerminalDeAutoatendimentoCompartilhadoDto> atualiza = mock.terminal(null);
		
		//terminal.atualizar(null);
		
		assertFalse(atualiza.addAll(atualiza));
	}
	
	@Test
	void removeUmaListaDeTerminalDeAutoatendimentoCompartilhado() {
		TerminalController mock = Mockito.mock(TerminalController.class);
		List<TerminalDeAutoatendimentoCompartilhadoDto> remove = mock.terminal(null);
		
		assertFalse(remove.addAll(remove));
		Mockito.verify(save);
	}

}
