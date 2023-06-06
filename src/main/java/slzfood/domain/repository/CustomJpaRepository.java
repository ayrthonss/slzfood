package slzfood.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

	Optional <T> buscarPrimeiro();
	   List<T> findByName(String name);
	    Optional<T> findFirstByNameContaining(String name);
}
