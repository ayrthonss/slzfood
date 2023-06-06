package slzfood.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import slzfood.domain.model.Cozinha;
@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findByNomeContaining(String nome);

	Optional<Cozinha> findByNome(String nome);

	boolean existsByNome(String nome);

}
