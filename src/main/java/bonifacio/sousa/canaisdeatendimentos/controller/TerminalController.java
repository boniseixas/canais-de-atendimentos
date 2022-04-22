package bonifacio.sousa.canaisdeatendimentos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import bonifacio.sousa.canaisdeatendimentos.controller.dto.TerminalDeAutoatendimentoCompartilhadoDto;
import bonifacio.sousa.canaisdeatendimentos.controller.form.AtualizacaoTerminaisForm;
import bonifacio.sousa.canaisdeatendimentos.controller.form.TerminaisForm;
import bonifacio.sousa.canaisdeatendimentos.repository.TerminalRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.TerminalDeAutoatendimentoCompartilhado;

@RestController
@RequestMapping("/terminal-de-autoatendimento-compartilhado")
public class TerminalController {
	
	@Autowired
	private TerminalRepository terminalRepository;

	@GetMapping
	public List<TerminalDeAutoatendimentoCompartilhadoDto> terminal(String localidade) {
		
		if(localidade == null) {
			List<TerminalDeAutoatendimentoCompartilhado> terminalDeAutoatendimentoCompartilhado = terminalRepository.findAll();
			return TerminalDeAutoatendimentoCompartilhadoDto.converter(terminalDeAutoatendimentoCompartilhado);
			
		} else {
			List<TerminalDeAutoatendimentoCompartilhado> terminalDeAutoatendimentoCompartilhado = terminalRepository.findByLocalidade(localidade);
			return TerminalDeAutoatendimentoCompartilhadoDto.converter(terminalDeAutoatendimentoCompartilhado);
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TerminalDeAutoatendimentoCompartilhadoDto> cadastrar(@RequestBody @Valid TerminaisForm form, UriComponentsBuilder uriBuilder) {
		TerminalDeAutoatendimentoCompartilhado terminalDeAutoatendimentoCompartilhado = form.converter();
		terminalRepository.save(terminalDeAutoatendimentoCompartilhado);
		
		URI uri = uriBuilder.path("/terminal-de-autoatendimento-compartilhado/{id}").buildAndExpand(terminalDeAutoatendimentoCompartilhado.getId()).toUri();
		return ResponseEntity.created(uri).body(new TerminalDeAutoatendimentoCompartilhadoDto(terminalDeAutoatendimentoCompartilhado));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TerminalDeAutoatendimentoCompartilhadoDto> detalhar(@PathVariable Long id) {
		Optional<TerminalDeAutoatendimentoCompartilhado> terminalDeAutoatendimentoCompartilhado = terminalRepository.findById(id);
		if (terminalDeAutoatendimentoCompartilhado.isPresent()) {
			
			return ResponseEntity.ok(new TerminalDeAutoatendimentoCompartilhadoDto(terminalDeAutoatendimentoCompartilhado.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TerminalDeAutoatendimentoCompartilhadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTerminaisForm form) {
		Optional<TerminalDeAutoatendimentoCompartilhado> optional = terminalRepository.findById(id);
		if (optional.isPresent()) {
			TerminalDeAutoatendimentoCompartilhado terminalDeAutoatendimentoCompartilhado = form.atualizar(id, terminalRepository);
			
			return ResponseEntity.ok(new TerminalDeAutoatendimentoCompartilhadoDto(terminalDeAutoatendimentoCompartilhado));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<TerminalDeAutoatendimentoCompartilhado> optional = terminalRepository.findById(id);
		if (optional.isPresent()) {
			terminalRepository.deleteById(id);
			
			//return ResponseEntity.ok().build(); //Não retorna mensagem
			return ResponseEntity.ok("Operação realizada com sucesso!"); //Retorna mensagem
		}
		
		return ResponseEntity.notFound().build();
	}
}
