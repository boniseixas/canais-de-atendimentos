package bonifacio.sousa.canaisdeatendimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bonifacio.sousa.canaisdeatendimentos.tipos.DependenciasProprias;

public interface DependenciasRepository extends JpaRepository<DependenciasProprias, Long> {

	List<DependenciasProprias> findByLocalidade(String localidade);

}
