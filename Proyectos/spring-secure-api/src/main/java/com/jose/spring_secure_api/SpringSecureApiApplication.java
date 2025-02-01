package com.jose.spring_secure_api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecureApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecureApiApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Spring Boot API - Autenticación y Autorización con JWT")
				.version("0.0.1")
				.description("Este proyecto simula una tienda con gestión de usuarios y productos, " +
						"implementando autenticación y autorización utilizando Spring Security y JWT. " +
						"El enfoque principal está en la seguridad, manejo de tokens y permisos, asegurando " +
						"el acceso a las rutas de la API según el rol del usuario."));
	}
}
