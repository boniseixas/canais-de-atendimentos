package bonifacio.sousa.canaisdeatendimentos.tipos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CorrespondentesBancarios {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoCorrespondente;
	private String cnpjDoCorrespondente;
	private String local;
	
	public CorrespondentesBancarios() {
	
	}
	
	public CorrespondentesBancarios(String nomeDoCorrespondente, String cnpjDoCorrespondente, String local) {
		this.nomeDoCorrespondente = nomeDoCorrespondente;
		this.cnpjDoCorrespondente = cnpjDoCorrespondente;
		this.local = local;
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
		CorrespondentesBancarios other = (CorrespondentesBancarios) obj;
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

}
