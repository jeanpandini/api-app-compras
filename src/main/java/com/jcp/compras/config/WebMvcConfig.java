package com.jcp.compras.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(CorsConfiguration.ALL)
				.allowedMethods("HEA", "POST", "PUT", "PATCH", "DELETE", "GET", "OPTIONS")
				.allowedHeaders("Access-Control-Allow-Headers", "Authorization", "Access-Control-Allow-Headers",
						"Origin", "Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method",
						"Access-Control-Request-Headers");
	}
}
