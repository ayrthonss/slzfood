package slzfood.api.slz.am.copy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import slzfood.infrastructure.slz.repository.CustomJpaRepositoryImpl;
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class SlzfoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlzfoodApiApplication.class, args);
	}

}
