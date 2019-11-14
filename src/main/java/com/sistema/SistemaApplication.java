package com.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SistemaApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	
	/*Permite ao spring localizar a página dentro de /WEB-INF/jsp/*/
	@Override
	public void configureViewResolvers(final ViewResolverRegistry registry) {
	    registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
}
