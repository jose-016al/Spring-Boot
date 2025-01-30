package com.example.Ejercicio5;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio5Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5Application.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("API Persona")
				.version("0.0.1")
				.description("API para gestionar personas"));
	}
}
