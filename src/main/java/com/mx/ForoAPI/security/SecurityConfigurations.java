package com.mx.ForoAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	@Autowired
	private Filter secfilter;
	
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity httpsec) throws Exception {
		return httpsec.csrf(csrf -> csrf.disable()).sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.POST, "/login")
                .permitAll().anyRequest().authenticated())
				.addFilterBefore(secfilter, UsernamePasswordAuthenticationFilter.class)
				.build();
				
				
            //    .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            //    .authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.POST, "/hello/login")
            //    .permitAll().anyRequest().authenticated().and().build();
	}
	
	@Bean
	public AuthenticationManager authManag(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
