package slzfood.domain.slz.repository;


import java.util.List;
import java.util.Optional;

import slzfood.domain.slz.model.Cozinha;

public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findByNomeContaining(String nome);

	Optional<Cozinha> findByNome(String nome);

	boolean existsByNome(String nome);

}
