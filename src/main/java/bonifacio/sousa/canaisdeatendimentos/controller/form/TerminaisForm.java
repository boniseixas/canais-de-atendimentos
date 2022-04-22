package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.tipos.TerminalDeAutoatendimentoCompartilhado;

public class TerminaisForm {
	
	//define quais campos serão cadastrado pelo cliente
	@NotNull @NotEmpty
	private String nomeEmpresa;
	
	@NotNull @NotEmpty
	private String cnpjEmpresa;
	
	@NotNull @NotEmpty
	private String localidade;
	
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public TerminalDeAutoatendimentoCompartilhado converter() {
		
		return new TerminalDeAutoatendimentoCompartilhado(nomeEmpresa, cnpjEmpresa, localidade);
	}
	
	

}
