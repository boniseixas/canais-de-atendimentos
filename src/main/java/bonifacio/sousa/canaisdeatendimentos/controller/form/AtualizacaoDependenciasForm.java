package bonifacio.sousa.canaisdeatendimentos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bonifacio.sousa.canaisdeatendimentos.repository.DependenciasRepository;
import bonifacio.sousa.canaisdeatendimentos.tipos.DependenciasProprias;

public class AtualizacaoDependenciasForm {
	
	//define quais campos serão atualizados pelo cliente
		@NotNull @NotEmpty
		private String nome;
		
		@NotNull @NotEmpty
		private String localidade;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getLocalidade() {
			return localidade;
		}

		public void setLocalidade(String localidade) {
			this.localidade = localidade;
		}
		
		public DependenciasProprias atualizar(Long id, DependenciasRepository dependenciasRepository) {
			DependenciasProprias dependenciasProprias = dependenciasRepository.getById(id);
			
			dependenciasProprias.setNome(this.nome);
			dependenciasProprias.setLocalidade(this.localidade);
			
			return dependenciasProprias;
		}
}
