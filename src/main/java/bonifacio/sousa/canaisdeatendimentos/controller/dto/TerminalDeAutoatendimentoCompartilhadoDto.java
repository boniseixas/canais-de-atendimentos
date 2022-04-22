package bonifacio.sousa.canaisdeatendimentos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import bonifacio.sousa.canaisdeatendimentos.tipos.TerminalDeAutoatendimentoCompartilhado;

public class TerminalDeAutoatendimentoCompartilhadoDto {
	
	private String nomeEmpresa;
	private String cnpjEmpresa;
	
	public TerminalDeAutoatendimentoCompartilhadoDto(TerminalDeAutoatendimentoCompartilhado 
			terminalDeAutoatendimentoCompartilhado) {
		this.nomeEmpresa = terminalDeAutoatendimentoCompartilhado.getNomeEmpresa();
		this.cnpjEmpresa = terminalDeAutoatendimentoCompartilhado.getCnpjEmpresa();
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public static List<TerminalDeAutoatendimentoCompartilhadoDto> converter(
			List<TerminalDeAutoatendimentoCompartilhado> terminalDeAutoatendimentoCompartilhado) {

		return terminalDeAutoatendimentoCompartilhado.stream().map(TerminalDeAutoatendimentoCompartilhadoDto::new).collect(Collectors.toList());
	}

}
