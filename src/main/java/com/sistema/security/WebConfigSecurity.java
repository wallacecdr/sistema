package com.sistema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	@Override // Configura as solicitações de acesso por Http
	protected void configure(HttpSecurity http) throws Exception {
		
//		CharacterEncodingFilter filter = new CharacterEncodingFilter();
//	    filter.setEncoding("UTF-8");
//	    filter.setForceEncoding(true);
//	    http.addFilterBefore(filter,CsrfFilter.class);
		
		http.csrf()
		.disable() // Desativa as configurações padrão de memória.
		.authorizeRequests() // Pertimi restringir acessos
		.antMatchers("/bootstrap-4.3.1/**").permitAll()
		.antMatchers("/jquery/**").permitAll()
		.antMatchers("/style_css/**").permitAll()
		.antMatchers("/style_js/**").permitAll()
		.antMatchers("/style_scss/**").permitAll()
		.antMatchers("/vendor/**").permitAll()
		.antMatchers(HttpMethod.GET, "/").permitAll() // Qualquer usuário acessa a pagina inicial
		//.antMatchers(HttpMethod.GET, "/main").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()// permite qualquer usuário
        .loginPage("/login")
        .defaultSuccessUrl("/main")
        .failureUrl("/login?error=true")
        .and()
        .logout().logoutSuccessUrl("/login")
		// Mapeia URL de Logout e invalida usuário autenticado
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}
	
	
	@Override // Cria autenticação do usuário com banco de dados ou em memória
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(implementacaoUserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
		
		System.out.println("senha" + new BCryptPasswordEncoder().encode("admin"));
		
	
	}
	
	@Override // Ignora URL especificas
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/materialize/**");
	}

}
