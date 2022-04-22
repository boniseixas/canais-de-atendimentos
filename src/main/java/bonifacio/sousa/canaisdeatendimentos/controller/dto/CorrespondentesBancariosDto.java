package bonifacio.sousa.canaisdeatendimentos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import bonifacio.sousa.canaisdeatendimentos.tipos.CorrespondentesBancarios;

public class CorrespondentesBancariosDto {
	
	private String nomeDoCorrespondente;
	private String cnpjDoCorrespondente;
	private String local;
	
	public CorrespondentesBancariosDto(CorrespondentesBancarios correspondentesBancarios) {
		this.nomeDoCorrespondente = correspondentesBancarios.getNomeDoCorrespondente();
		this.cnpjDoCorrespondente = correspondentesBancarios.getCnpjDoCorrespondente();
		this.local = correspondentesBancarios.getLocal();
		
	}

	public String getNomeDoCorrespondente() {
		return nomeDoCorrespondente;
	}

	public String getCnpjDoCorrespondente() {
		return cnpjDoCorrespondente;
	}

	public String getLocal() {
		return local;
	}
	
	public static List<CorrespondentesBancariosDto> converter(List<CorrespondentesBancarios> correspondentesBancarios) {
		
		return correspondentesBancarios.stream().map(CorrespondentesBancariosDto::new).collect(Collectors.toList());
	}
}
