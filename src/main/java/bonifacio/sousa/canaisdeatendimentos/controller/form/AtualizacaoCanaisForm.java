package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.repository.CanaisRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.CanaisDeAtendimentoEletronico;

public class AtualizacaoCanaisForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public CanaisDeAtendimentoEletronico atualizar(Long id, CanaisRepository canaisRepository) {
		CanaisDeAtendimentoEletronico canaisDeAtendimentoEletronico = canaisRepository.getById(id);
		
		canaisDeAtendimentoEletronico.setNome(this.nome);
		canaisDeAtendimentoEletronico.setTipo(this.tipo);
		
		return canaisDeAtendimentoEletronico;
	}
}
