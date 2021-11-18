package com.websitenhaccu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.websitenhaccu.util.CustomSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService) // Cung cáp userservice cho spring security
				.passwordEncoder(passwordEncoder()); // cung cấp password encoder
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers("/quan-ly-don-hang/**" ).hasAnyRole("USER", "ADMIN")
				.antMatchers("/tai-khoan/**" ).hasAnyRole("USER", "ADMIN") 
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest()
	            
				.permitAll()
				.and()
					.formLogin()
					.loginPage("/login")
					.usernameParameter("email")
					.passwordParameter("password")
//					.successHandler(customSuccessHandler)
					.defaultSuccessUrl("/")
				.failureUrl("/login?error")
				.permitAll()
				.and()
					.logout()
					.logoutSuccessUrl("/trang-chu")
					.permitAll()
				.and()
					.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000)// Cấu hình remember me, thời gian là 1296000 giây
				.and()
					.exceptionHandling()
					.accessDeniedPage("/403");
	}
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/static/**");
	}
	
}
