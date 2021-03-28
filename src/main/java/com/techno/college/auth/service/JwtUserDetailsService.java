package com.techno.college.auth.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
 * this method is called for getting the user details from the database 
 * when authenticating the user details provided by the user. 
 * Here we are getting the user details from a hardcoded User List.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("guneet".equals(username)){
			return new User("guneet", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
		}
		else{
			throw new UsernameNotFoundException("No user found with username " + username);
		}
	}

}
