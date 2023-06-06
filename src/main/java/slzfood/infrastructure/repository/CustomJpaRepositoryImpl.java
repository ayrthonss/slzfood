package slzfood.infrastructure.repository;


import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import slzfood.domain.repository.CustomJpaRepository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomJpaRepository<T, ID> {

	private EntityManager manager;

	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscarPrimeiro() {

		var jpql = "FROM " + getDomainClass().getName();

		T entity = manager.createQuery(jpql, getDomainClass())
		.setMaxResults(1)
		.getSingleResult();
		
		return Optional.ofNullable(entity);
	}

	@Override
	public List<T> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T> findFirstByNameContaining(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
