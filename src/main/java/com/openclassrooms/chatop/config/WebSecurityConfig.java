package com.openclassrooms.chatop.config;

import java.util.Arrays;

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
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.openclassrooms.chatop.security.CustomAccessDeniedHandler;
import com.openclassrooms.chatop.security.CustomAuthenticationFailureHandler;
import com.openclassrooms.chatop.security.CustomAuthenticationSuccessHandler;
import com.openclassrooms.chatop.service.MyUserDetailsService;


@Configuration
@EnableWebMvc
@EnableWebSecurity(debug = true)
@CrossOrigin(origins = "http://localhost:4200/*")
public class WebSecurityConfig {
	
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
			
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
                .cors(cors->cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(authorize -> {
//								                	authorize.requestMatchers("/admin").hasRole("ADMIN");
//								                	authorize.requestMatchers("/user").hasRole("USER");
//								                	authorize.requestMatchers("/api/auth/register").hasRole("ADMIN");
//								                	authorize.requestMatchers("/**").authenticated();
                									authorize.requestMatchers("/api/auth/login").permitAll();
                									authorize.anyRequest().authenticated();
                                					}
                        				)
                .httpBasic(Customizer.withDefaults()).build();
				 //.formLogin(Customizer.withDefaults()).build();	// le cheminement est à lire en sens inverse le login d'abord
																	//puis l'authentification basic, puis l'autorisaton enfin csrf et cors
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("*"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
	    return new CustomAuthenticationFailureHandler();
	} 

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
	   return new CustomAuthenticationSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
	   return new CustomAccessDeniedHandler();
	}

}
