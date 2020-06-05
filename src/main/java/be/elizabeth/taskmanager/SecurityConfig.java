package be.elizabeth.taskmanager;

import be.elizabeth.taskmanager.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//ALL
				.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
				.mvcMatchers("/").permitAll()
				.mvcMatchers("/signup").permitAll()
				//ADMIN
				.mvcMatchers("/tasks/new").hasAuthority("ADMIN")
				.mvcMatchers("/tasks/edit/*").hasAuthority("ADMIN")
				.mvcMatchers("tasks/*/sub/create").hasAuthority("ADMIN")
				.mvcMatchers("/new").hasAuthority("ADMIN")
				//AUTHENTICATED
				.mvcMatchers("/tasks").fullyAuthenticated()
				.mvcMatchers("/tasks/*").fullyAuthenticated()
				//API
				.mvcMatchers("/api/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and()
				.logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
				.passwordEncoder(passwordEncoder);
	}
}
