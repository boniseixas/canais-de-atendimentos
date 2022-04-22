package bonifacio.sousa.canaisdeatendimentos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import bonifacio.sousa.canaisdeatendimentos.tipos.CanaisDeAtendimentoEletronico;

public class CanaisDeAtendimentoEletronicoDto {

	private String tipo;
	private String nome;
	//private String cnpj;
	
	
	public CanaisDeAtendimentoEletronicoDto(CanaisDeAtendimentoEletronico canaisDeAtendimentoEletronico) {
		this.tipo = canaisDeAtendimentoEletronico.getTipo();
		this.nome = canaisDeAtendimentoEletronico.getNome();
		//this.cnpj = canaisDeAtendimentoEletronico.getCnpj();
	}
	
	public String getTipo() {
		return tipo;
	}
	public String getNome() {
		return nome;
	}
	//public String getCnpj() {
	//	return cnpj;
	//}

	public static List<CanaisDeAtendimentoEletronicoDto> converter(List<CanaisDeAtendimentoEletronico> canaisDeAtendimentoEletronico) {
		
		return canaisDeAtendimentoEletronico.stream().map(CanaisDeAtendimentoEletronicoDto::new).collect(Collectors.toList());
	}
	
	
}
