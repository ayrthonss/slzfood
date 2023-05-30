package slzfood.domain.slz.repository;


import java.math.BigDecimal;
import java.util.List;

import slzfood.domain.slz.model.Restaurante;


public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);
}