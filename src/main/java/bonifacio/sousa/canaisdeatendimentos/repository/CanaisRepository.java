package bonifacio.sousa.canaisdeatendimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bonifacio.sousa.canaisdeatendimentos.tipos.CanaisDeAtendimentoEletronico;

public interface CanaisRepository extends JpaRepository<CanaisDeAtendimentoEletronico, Long> {

	List<CanaisDeAtendimentoEletronico> findByTipo(String tipo);

}
