package com.workschedule.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.workschedule.app.auth.handler.LoginSuccesHandler;


//@EnableGlobalMethodSecurity para que tome las anotation de los controller
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig {
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	
	
	//Para correrlo de manera vieja con JDBC (Comentar completa la clase JpaUserDetailsService())
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	@Autowired
//	private AuthenticationConfiguration authenticationConfiguration;
//	@Autowired
//	private DataSource dataSource;

	
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
//		/*.antMatchers("/ver/**").hasAnyRole("USER")*/
//		/*.antMatchers("/uploads/**").hasAnyRole("USER")*/
//		/*.antMatchers("/form/**").hasAnyRole("ADMIN")*/
//		/*.antMatchers("/eliminar/**").hasAnyRole("ADMIN")*/
//		/*.antMatchers("/factura/**").hasAnyRole("ADMIN")*/
//		.anyRequest().authenticated()
//		.and()
//		    .formLogin()
//		        .successHandler(successHandler)
//		        .loginPage("/login")
//		    .permitAll()
//		.and()
//		.logout().permitAll()
//		.and()
//		.exceptionHandling().accessDeniedPage("/error_403");
//
//	}
    
//    AuthenticationManager authenticationManager() throws Exception {
//      return authenticationConfiguration.getAuthenticationManager();
//    }
	
	// Esto es si no queremos ir contra la BD
//  @Bean
//  UserDetailsService userDetailsService() throws Exception {

//  	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//      manager.createUser(User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build());
//      manager.createUser(User.withUsername("gestion").password(passwordEncoder.encode("gestion")).roles("GESTION", "USER").build());
//      manager.createUser(User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN", "GESTION", "USER").build());
//
//      return manager;
//  }
	
//  @Bean
//  UserDetailsService userDetailsService(AuthenticationManagerBuilder build) throws Exception {
//
//	    build.jdbcAuthentication().dataSource(dataSource)
//	
//	    .passwordEncoder(passwordEncoder)
//	
//	    .usersByUsernameQuery("select usuario, pass, activo from usuario where usuario=?")
//	
//	    .authoritiesByUsernameQuery("select u.usuario, a.descripcion "
//						    		+ "from rol a "
//						    		+ "inner join usuario_rol ur on a.id=ur.rol_id "
//						    		+ "inner join usuario u on u.id=usuario_id "
//						    		+ "where u.usuario=? ");
//						
//	    return build.getDefaultUserDetailsService();
//
//  }
  
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	 
		http.authorizeRequests().antMatchers("/app/listar", "/css/**", "/js/**", "/images/**", "/listar", "/", "/bootstrap-icons/**").permitAll()
//		Se sacan las url de aca para implementar en los controller con anotaciones
//				.antMatchers("/app/ver/**").hasAnyRole("ADMIN")
//				.antMatchers("/uploads/**").hasAnyRole("USER")
//				.antMatchers("/form/**").hasAnyRole("ADMIN")
//				.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
//				.antMatchers("/factura/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and()
					.formLogin()
						.successHandler(successHandler)
						.loginPage("/login")
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.formLogin().permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/error_403");
 
		return http.build();
	}
    

    
}
