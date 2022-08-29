package com.timetracker.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/*
	 * private final Logger log = LoggerFactory.getLogger(getClass());
	 * 
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * 
	 * WebMvcConfigurer.super.addResourceHandlers(registry);
	 * 
	 * String resourcePath =
	 * Paths.get("uploads").toAbsolutePath().toUri().toString();
	 * log.info("resourcePath:" + resourcePath);
	 * 
	 * registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath)
	 * ; }
	 */
	
	//Sirve para indicar en caso de error por permisos a una url en particular cual va a ser la web a mostrar con el error
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
	
	@Bean
    static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
