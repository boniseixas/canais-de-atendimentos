package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.tipos.DependenciasProprias;

public class DependenciasForm {
	
	//define quais campos serão cadastrado pelo cliente
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String cnpj;
	
	@NotNull @NotEmpty
	private String localidade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public DependenciasProprias converter() {
		
		return new DependenciasProprias(nome, cnpj, localidade);
	}

	
}
