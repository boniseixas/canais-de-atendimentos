package bonifacio.sousa.canaisdeatendimentos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import bonifacio.sousa.canaisdeatendimentos.repository.CanaisRepository;

class CanaisControllerTest {
	
	@SuppressWarnings("unused")
	private CanaisController controller;
	
	@Mock
	private CanaisRepository repository;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.openMocks(this);
		this.controller = new CanaisController(repository);
	}

	@Test
	void deveriaChamarUmaLista() {
		
			}

}
