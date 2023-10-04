package com.example.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = { "com.example.servicio", "com.example.controlador" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Creamos el @Bean para nuestro template que inyectaremos en nuestro servicio
	 * 
	 * @return template
	 */
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
