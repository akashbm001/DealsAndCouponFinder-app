package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.model.Users;

import com.cg.repository.UserRepositiory;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepositiory userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Users user = userRepository.findByuserName(username);
		Users user = null;
		Users[] users = restTemplate.getForObject("http://localhost:8081/api/jwt/users", Users[].class);
		for (Users u:users) {
			if(u.getUserName().equals(username))
			{
				user = u;
			}
		}
		String usern=user.getUserName();
		String passwrd=user.getPassWord();
		if(user==null)
			throw new UsernameNotFoundException(username, null);

		return new User(usern,passwrd,new ArrayList<>());
	}
}