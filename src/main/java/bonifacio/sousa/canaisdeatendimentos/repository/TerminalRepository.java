package bonifacio.sousa.canaisdeatendimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bonifacio.sousa.canaisdeatendimentos.tipos.TerminalDeAutoatendimentoCompartilhado;

public interface TerminalRepository extends JpaRepository<TerminalDeAutoatendimentoCompartilhado, Long> {

	List<TerminalDeAutoatendimentoCompartilhado> findByLocalidade(String localidade);

}
