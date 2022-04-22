package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.tipos.CanaisDeAtendimentoEletronico;


public class CanaisForm {
	
	//define quais campos serão cadastrado pelo cliente
	//usando o bean validation
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
	public CanaisDeAtendimentoEletronico converter() {
		
		return new CanaisDeAtendimentoEletronico(tipo, nome);
	}
}
