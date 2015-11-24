package de.franke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.franke.model.UserModel;

@Service
public class UserBuilder implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserBuilder(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(
			String username) throws UsernameNotFoundException {
		
		UserModel user = userRepository.findByUserName(username);
		if (user == null) {
			return null;
		}
		
		List<GrantedAuthority> auth = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		if (username.equals("admin")) {
			auth = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
		}
		
		String password = user.getPassword();
		
		return new User(username, password, auth);
	}

}
