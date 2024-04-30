package com.openclassrooms.chatop.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassrooms.chatop.model.DBUser;
import com.openclassrooms.chatop.repository.DBUserRepository;

import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DBUserRepository myUserRepository;
    
   
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		logger.info("Entering in loadUserByUsername Method...");
		DBUser myUser = myUserRepository.findUserByName(name);
        if (myUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        logger.info("User Authenticated By Name Successfully..!!!");
        logger.info(myUser.getRole());
        return new User(myUser.getName(),myUser.getPassword(),getGrantedAuthorities(myUser.getRole()));
       
	
	}
	
	
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		
		logger.info("Entering in findUserByEmail Method...");
		DBUser myUser = myUserRepository.findUserByEmail(email);
        if (myUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        logger.info("User Authenticated by email Successfully..!!!");
        return new User(myUser.getName(),myUser.getPassword(),getGrantedAuthorities(myUser.getRole()));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		logger.info(authorities.get(0).toString());
		return authorities;
	}
	
    @Transactional
    public Iterable<DBUser> loadAllUsers(){
        return myUserRepository.findAll();
    }
	
    @Transactional
    public DBUser saveUsers(DBUser dbUser){
        return myUserRepository.save(dbUser);
    }
    

}
