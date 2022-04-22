package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.repository.TerminalRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.TerminalDeAutoatendimentoCompartilhado;

public class AtualizacaoTerminaisForm {

	//define quais campos serão atualizados pelo cliente
		@NotNull @NotEmpty
		private String nomeEmpresa;
		
		@NotNull @NotEmpty
		private String localidade;

		public String getNomeEmpresa() {
			return nomeEmpresa;
		}

		public void setNomeEmpresa(String nomeEmpresa) {
			this.nomeEmpresa = nomeEmpresa;
		}

		public String getLocalidade() {
			return localidade;
		}

		public void setLocalidade(String localidade) {
			this.localidade = localidade;
		}
		
		public TerminalDeAutoatendimentoCompartilhado atualizar(Long id, TerminalRepository terminalRepository) {
			TerminalDeAutoatendimentoCompartilhado terminalDeAutoatendimentoCompartilhado = terminalRepository.getById(id);
			
			terminalDeAutoatendimentoCompartilhado.setNomeEmpresa(this.nomeEmpresa);
			terminalDeAutoatendimentoCompartilhado.setLocalidade(this.localidade);
			
			return terminalDeAutoatendimentoCompartilhado;
		}
}
