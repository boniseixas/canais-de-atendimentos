package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.repository.CorrespondentesRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.CorrespondentesBancarios;

public class AtualizacaoCorrespondentesForm {
	
	//define quais campos serão atualizado pelo cliente
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

		public CorrespondentesBancarios atualizar(Long id, CorrespondentesRepository correspondentesRepository) {
			CorrespondentesBancarios correspondentesBancarios = correspondentesRepository.getById(id);
			
			correspondentesBancarios.setNomeDoCorrespondente(this.nomeDoCorrespondente);
			correspondentesBancarios.setCnpjDoCorrespondente(this.cnpjDoCorrespondente);
			correspondentesBancarios.setLocal(this.local);
			
			return correspondentesBancarios;
		}
}
