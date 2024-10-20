package com.springboot.springboot_restaurant;

import java.beans.Customizer;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/").permitAll();
					auth.anyRequest().authenticated();
				})
				.formLogin(withDefaults())
				.oauth2Login(withDefaults())
				.build();
	}

}
