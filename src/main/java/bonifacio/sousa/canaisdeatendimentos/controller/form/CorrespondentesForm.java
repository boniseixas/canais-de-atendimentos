package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.tipos.CorrespondentesBancarios;

public class CorrespondentesForm {

	//define quais campos serão cadastrado pelo cliente
	@NotNull @NotEmpty
	private String nomeDoCorrespondente;
	
	@NotNull @NotEmpty
	private String cnpjDoCorrespondente;
	
	@NotNull @NotEmpty
	private String local;
	
	
	public String getNomeDoCorrespondente() {
		return nomeDoCorrespondente;
	}
	public void setNomeDoCorrespondente(String nomeDoCorrespondente) {
		this.nomeDoCorrespondente = nomeDoCorrespondente;
	}
	public String getCnpjDoCorrespondente() {
		return cnpjDoCorrespondente;
	}
	public void setCnpjDoCorrespondente(String cnpjDoCorrespondente) {
		this.cnpjDoCorrespondente = cnpjDoCorrespondente;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public CorrespondentesBancarios converter() {
		
		return new CorrespondentesBancarios(nomeDoCorrespondente, cnpjDoCorrespondente, local);
	}
}
