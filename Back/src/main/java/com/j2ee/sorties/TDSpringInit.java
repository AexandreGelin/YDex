package com.j2ee.sorties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.j2ee.sorties")
@EntityScan("com.j2ee.sorties.entities")
@EnableJpaRepositories("com.j2ee.sorties.repositories")
public class TDSpringInit extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(TDSpringInit.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TDSpringInit.class);
	}

}
