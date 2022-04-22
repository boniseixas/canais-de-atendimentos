package bonifacio.sousa.canaisdeatendimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bonifacio.sousa.canaisdeatendimentos.tipos.CorrespondentesBancarios;

public interface CorrespondentesRepository extends JpaRepository<CorrespondentesBancarios, Long> {
	
	List<CorrespondentesBancarios> findByNomeDoCorrespondente(String nomeDoCorrespondente);

}
