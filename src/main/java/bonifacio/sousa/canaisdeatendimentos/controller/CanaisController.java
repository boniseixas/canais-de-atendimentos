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

import bonifacio.sousa.canaisdeatendimentos.controller.dto.CanaisDeAtendimentoEletronicoDto;
import bonifacio.sousa.canaisdeatendimentos.controller.form.AtualizacaoCanaisForm;
import bonifacio.sousa.canaisdeatendimentos.controller.form.CanaisForm;
import bonifacio.sousa.canaisdeatendimentos.repository.CanaisRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.CanaisDeAtendimentoEletronico;

@RestController
@RequestMapping("/canais-de-atendimento-eletronico")
public class CanaisController {
	
	//criado um construtor para os testes
	private CanaisRepository canaisRepository;
	
	@Autowired
	public CanaisController(CanaisRepository canaisRepository) {
		this.canaisRepository = canaisRepository;
	}

	@GetMapping
	public List<CanaisDeAtendimentoEletronicoDto> canais(String tipo) {
		
		if(tipo == null) {
			List<CanaisDeAtendimentoEletronico> canaisDeAtendimentoEletronico = canaisRepository.findAll();
			return CanaisDeAtendimentoEletronicoDto.converter(canaisDeAtendimentoEletronico);
		} else {
			List<CanaisDeAtendimentoEletronico> canaisDeAtendimentoEletronico = canaisRepository.findByTipo(tipo);
			return CanaisDeAtendimentoEletronicoDto.converter(canaisDeAtendimentoEletronico);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CanaisDeAtendimentoEletronicoDto> cadastrar(@RequestBody @Valid CanaisForm form, UriComponentsBuilder uriBuilder) {
		CanaisDeAtendimentoEletronico canaisDeAtendimentoEletronico = form.converter();
		canaisRepository.save(canaisDeAtendimentoEletronico);
		
		URI uri = uriBuilder.path("/canais-de-atendimento-eletronico/{id}").buildAndExpand(canaisDeAtendimentoEletronico.getId()).toUri();
		return ResponseEntity.created(uri).body(new CanaisDeAtendimentoEletronicoDto(canaisDeAtendimentoEletronico));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CanaisDeAtendimentoEletronicoDto> detalhar(@PathVariable Long id) {
		Optional<CanaisDeAtendimentoEletronico> canaisDeAtendimentoEletronico = canaisRepository.findById(id);
		if (canaisDeAtendimentoEletronico.isPresent()) {
			
			return ResponseEntity.ok(new CanaisDeAtendimentoEletronicoDto(canaisDeAtendimentoEletronico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CanaisDeAtendimentoEletronicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCanaisForm form) {
		Optional<CanaisDeAtendimentoEletronico> optional = canaisRepository.findById(id);
		if (optional.isPresent()) {
			CanaisDeAtendimentoEletronico canaisDeAtendimentoEletronico = form.atualizar(id, canaisRepository);
			
			return ResponseEntity.ok(new CanaisDeAtendimentoEletronicoDto(canaisDeAtendimentoEletronico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<CanaisDeAtendimentoEletronico> optional = canaisRepository.findById(id);
		if(optional.isPresent()) {
			canaisRepository.deleteById(id);
			//return ResponseEntity.ok().build(); //Não retorna mensagem
			return ResponseEntity.ok("Operação realizada com sucesso!"); //Retorna a mensagem
		}
		
		return ResponseEntity.notFound().build();
	}

	
}
