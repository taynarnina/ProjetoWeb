package br.edu.ufab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Classe responsável pelas configurações de segurança da informação dos dados com Spring Security.
 * 
 * @author Murilo Gustavo e taynar Sousa
 * */
@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
	/**
	 * método que faz a autenticação do usuário
	 * @param auth
	 * 
	 * */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");;
	}
	
	/**
	 * método que vai configurar a requisição
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
