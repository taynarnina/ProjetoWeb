package br.edu.ufab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Classe respons�vel pelas configura��es de seguran�a da informa��o dos dados com Spring Security.
 * 
 * @author Murilo Gustavo e taynar Sousa
 * */
@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
	/**
	 * m�todo que faz a autentica��o do usu�rio
	 * @param auth
	 * 
	 * */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");;
	}
	
	/**
	 * m�todo que vai configurar a requisi��o
	 * @param http
	 * 
	 * */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/editora/**", "/autor/**", "/anais/**",
					 "/livro/**", "/orientador/**",  "/aluno/**",
					 "/funcionario/**", "/curso/**", "/divida/**", "/emprestimo/**",
					 "/jornal/**", "/tcc/**", "/revista/**", "/midia/**").hasRole("ADMIN")
			.anyRequest().permitAll()
		.and()
			.formLogin()
				.loginPage("/login.jsp")
				.loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/emprestimo")
				.failureUrl("/login.jsp?semacesso=true")
				.usernameParameter("usuario")
				.passwordParameter("senha")
			.and()
				.logout()
					.logoutUrl("/sair")
					.logoutSuccessUrl("/login.jsp?saiu=true");
	}
}
