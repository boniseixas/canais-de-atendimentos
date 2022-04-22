package bonifacio.sousa.canaisdeatendimentos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import bonifacio.sousa.canaisdeatendimentos.tipos.DependenciasProprias;

public class DependenciasPropriasDto {
	
	private String id;
	private String nome;
	private String cnpj;
	
	public DependenciasPropriasDto(DependenciasProprias dependenciasProprias) {
		this.id = dependenciasProprias.getId();
		this.nome = dependenciasProprias.getNome();
		this.cnpj = dependenciasProprias.getCnpj();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public static List<DependenciasPropriasDto> converter(List<DependenciasProprias> dependenciasProprias) {
		
		return dependenciasProprias.stream().map(DependenciasPropriasDto::new).collect(Collectors.toList());
	}
	
	

}
