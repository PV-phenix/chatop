package com.openclassrooms.chatop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.openclassrooms.chatop.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig {
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
		
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
                .cors(cors -> cors.disable())
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> {
					                            auth.requestMatchers("/admin").hasRole("ADMIN");
					                            auth.requestMatchers("/user").hasRole("USER");
//					                            auth.requestMatchers("/api/auth/register").hasRole("ADMIN");
					                            auth.requestMatchers("/**").authenticated();
					                            auth.anyRequest().authenticated();
                                				}
                        			)
                 .formLogin(Customizer.withDefaults()).build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}

}
