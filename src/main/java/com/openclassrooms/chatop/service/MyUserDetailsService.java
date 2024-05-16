package com.openclassrooms.chatop.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
	
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassrooms.chatop.model.User;
import com.openclassrooms.chatop.model.UserPrincipal;
import com.openclassrooms.chatop.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
   
    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("Entering in loadUserByUsername Method...");
		User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        logger.info("User Authenticated By Name Successfully..!!!");
        //logger.info(userPrincipal.getRole());
                
        return new UserPrincipal(user);
       
	
	}
	
	
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		
		logger.info("Entering in findUserByEmail Method...");
		User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        logger.info("User Authenticated by email Successfully..!!!");
        return new UserPrincipal(user);
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		logger.info(authorities.get(0).toString());
		return authorities;
	}
	
    @Transactional
    public Iterable<User> loadAllUsers(){
        return userRepository.findAll();
    }
	
    @Transactional
    public User saveUsers(User user){
        return userRepository.save(user);
    }
    

}
