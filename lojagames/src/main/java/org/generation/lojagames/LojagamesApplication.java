package org.generation.lojagames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages =  "org.generation.lojagames.model")
@SpringBootApplication
public class LojagamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojagamesApplication.class, args);
	}

}
