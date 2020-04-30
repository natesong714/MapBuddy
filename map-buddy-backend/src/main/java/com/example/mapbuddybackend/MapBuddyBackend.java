package com.example.mapbuddybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MapBuddyBackend {

	public static void main(String[] args) {
		SpringApplication.run(MapBuddyBackend.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/search").allowedOrigins("http://localhost:3000");
				registry.addMapping("/return").allowedOrigins("http://localhost:3000");
			}
		};
	}

}



