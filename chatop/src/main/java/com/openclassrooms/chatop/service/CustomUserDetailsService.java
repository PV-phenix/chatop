package com.openclassrooms.chatop.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.openclassrooms.chatop.model.DBUser;
import com.openclassrooms.chatop.repository.MyUserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;
    
   
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		logger.debug("Entering in loadUserByUsername Method...");
		DBUser myUser = myUserRepository.findByName(name);
        if (myUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        logger.info("User Authenticated Successfully..!!!");
        logger.info(myUser.getName());
        return new User(myUser.getName(),myUser.getPassword(),getGrantedAuthorities(myUser.getRole()));
       //return myUserDetails;
	
	}
	

	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

		DBUser myUser = myUserRepository.findUserByEmail(email);
        if (myUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new User(myUser.getName(),myUser.getPassword(),getGrantedAuthorities(myUser.getRole()));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}

}
