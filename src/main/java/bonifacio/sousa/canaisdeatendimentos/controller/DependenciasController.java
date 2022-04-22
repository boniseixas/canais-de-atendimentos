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

import bonifacio.sousa.canaisdeatendimentos.controller.dto.DependenciasPropriasDto;
import bonifacio.sousa.canaisdeatendimentos.controller.form.AtualizacaoDependenciasForm;
import bonifacio.sousa.canaisdeatendimentos.controller.form.DependenciasForm;
import bonifacio.sousa.canaisdeatendimentos.repository.DependenciasRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.DependenciasProprias;

@RestController
@RequestMapping("/dependencias-proprias")
public class DependenciasController {
	
	@Autowired
	private DependenciasRepository dependenciasRepository;
	
	@GetMapping
	public List<DependenciasPropriasDto> dependencias(String localidade) {
		
		if(localidade == null) {
			List<DependenciasProprias> dependenciasProprias = dependenciasRepository.findAll();
			return DependenciasPropriasDto.converter(dependenciasProprias);
		} else {
			List<DependenciasProprias> dependenciasProprias = dependenciasRepository.findByLocalidade(localidade);
			return DependenciasPropriasDto.converter(dependenciasProprias);
		}	
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DependenciasPropriasDto> cadastrar(@RequestBody @Valid DependenciasForm form, UriComponentsBuilder uriBuilder) {
		DependenciasProprias dependenciasProprias = form.converter();
		dependenciasRepository.save(dependenciasProprias);
		
		URI uri = uriBuilder.path("/dependencias-proprias/{id}").buildAndExpand(dependenciasProprias.getId()).toUri();
		return ResponseEntity.created(uri).body(new DependenciasPropriasDto(dependenciasProprias));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DependenciasPropriasDto> detalhar(@PathVariable Long id) {
		Optional<DependenciasProprias> dependenciasProprias = dependenciasRepository.findById(id);
		if (dependenciasProprias.isPresent()) {
			
			return ResponseEntity.ok(new DependenciasPropriasDto(dependenciasProprias.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DependenciasPropriasDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoDependenciasForm form) {
		Optional<DependenciasProprias> optional = dependenciasRepository.findById(id);
		if (optional.isPresent()) {
			DependenciasProprias dependenciasProprias = form.atualizar(id, dependenciasRepository);
			
			return ResponseEntity.ok(new DependenciasPropriasDto(dependenciasProprias));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<DependenciasProprias> optional = dependenciasRepository.findById(id);
		if (optional.isPresent()) {
			dependenciasRepository.deleteById(id);
			
			//return ResponseEntity.ok().build(); //Não retorna mensagem
			return ResponseEntity.ok("Operação realizada com sucesso!"); //Retorna mensagem
		}
		
		return ResponseEntity.notFound().build();
	}
}
