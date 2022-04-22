package bonifacio.sousa.canaisdeatendimentos.tipos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CanaisDeAtendimentoEletronico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private String nome;
	//private String cnpj;
	
	public CanaisDeAtendimentoEletronico() {
	
	}
	
	public CanaisDeAtendimentoEletronico(String tipo, String nome) {
		this.tipo = tipo;
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CanaisDeAtendimentoEletronico other = (CanaisDeAtendimentoEletronico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//public String getCnpj() {
	//	return cnpj;
	//}

	//public void setCnpj(String cnpj) {
	//	this.cnpj = cnpj;
	//}
	
}
