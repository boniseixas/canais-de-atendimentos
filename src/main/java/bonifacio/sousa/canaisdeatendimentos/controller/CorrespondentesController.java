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

import bonifacio.sousa.canaisdeatendimentos.controller.dto.CorrespondentesBancariosDto;
import bonifacio.sousa.canaisdeatendimentos.controller.form.AtualizacaoCorrespondentesForm;
import bonifacio.sousa.canaisdeatendimentos.controller.form.CorrespondentesForm;
import bonifacio.sousa.canaisdeatendimentos.repository.CorrespondentesRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.CorrespondentesBancarios;

@RestController
@RequestMapping("/correspondentes-bancarios")
public class CorrespondentesController {
	
	//criado um construtor para os testes
	private CorrespondentesRepository correspondentesRepository;
	
	@Autowired
	public CorrespondentesController(CorrespondentesRepository correspondentesRepository) {
		this.correspondentesRepository = correspondentesRepository;
	}
	
	@GetMapping
	public List<CorrespondentesBancariosDto> correspondentes(String nomeDoCorrespondente) {
		
		if(nomeDoCorrespondente == null) {
			List<CorrespondentesBancarios> correspondentesBancarios = correspondentesRepository.findAll();
			return CorrespondentesBancariosDto.converter(correspondentesBancarios);
		} else {
			List<CorrespondentesBancarios> correspondentesBancarios = correspondentesRepository.findByNomeDoCorrespondente(nomeDoCorrespondente);
			return CorrespondentesBancariosDto.converter(correspondentesBancarios);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CorrespondentesBancariosDto> cadastrar(@RequestBody @Valid CorrespondentesForm form, UriComponentsBuilder uriBuilder) {
		CorrespondentesBancarios correspondentesBancarios = form.converter();
		correspondentesRepository.save(correspondentesBancarios);
		
		URI uri = uriBuilder.path("/correspondentes-bancarios/{id}").buildAndExpand(correspondentesBancarios.getId()).toUri();
		return ResponseEntity.created(uri).body(new CorrespondentesBancariosDto(correspondentesBancarios));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CorrespondentesBancariosDto> detalhar(@PathVariable Long id) {
		Optional<CorrespondentesBancarios> correspondentesBancarios = correspondentesRepository.findById(id);
		if (correspondentesBancarios.isPresent()) {
			
			return ResponseEntity.ok(new CorrespondentesBancariosDto(correspondentesBancarios.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CorrespondentesBancariosDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCorrespondentesForm form) {
		Optional<CorrespondentesBancarios> optional = correspondentesRepository.findById(id);
		if (optional.isPresent()) {
			CorrespondentesBancarios correspondentesBancarios = form.atualizar(id, correspondentesRepository);
			
			return ResponseEntity.ok(new CorrespondentesBancariosDto(correspondentesBancarios));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<CorrespondentesBancarios> optional = correspondentesRepository.findById(id);
		if (optional.isPresent()) {
			correspondentesRepository.deleteById(id);
			
			//return ResponseEntity.ok().build(); //Não retorna mensagem
			return ResponseEntity.ok("Operação realizada com sucesso!"); //Retorna a mensagem
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
