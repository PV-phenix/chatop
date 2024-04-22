package com.openclassrooms.chatop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.openclassrooms.chatop.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/admin").hasRole("ADMIN");
			auth.requestMatchers("/user").hasRole("USER");
			auth.anyRequest().authenticated();
		}).formLogin(Customizer.withDefaults()).build();
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
	
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//            .csrf(Customizer.withDefaults())
//            .authorizeHttpRequests(authorize -> {
//            	
//            	authorize.requestMatchers("/admin").hasRole("ADMIN");
//            	authorize.requestMatchers("/user").hasRole("USER");
//            	authorize.anyRequest().authenticated();
//                })
//            .httpBasic(Customizer.withDefaults())
//            .formLogin(Customizer.withDefaults())
//       .build();
//    }
//	
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		return http.authorizeHttpRequests(auth -> {
//			auth.requestMatchers("/admin").hasRole("ADMIN");
//			auth.requestMatchers("/user").hasRole("USER");
//			auth.anyRequest().authenticated();
//		}).formLogin(org.springframework.security.config.Customizer.withDefaults()).build();
//	}

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(customUserDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//         
//        return authProvider;
//    }
//    

//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(auth -> {
//			auth.requestMatchers("/admin").hasRole("ADMIN");
//			auth.requestMatchers("/user").hasRole("USER");
//			auth.anyRequest().authenticated();
//		}).formLogin(login -> login.permitAll()).logout(logout -> logout.permitAll());
//
//		return http.build();
//	}

//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
//			throws Exception {
//		AuthenticationManagerBuilder authenticationManagerBuilder = http
//				.getSharedObject(AuthenticationManagerBuilder.class);
//		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
//		return authenticationManagerBuilder.build();
//	}
}
