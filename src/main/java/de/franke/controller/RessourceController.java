package de.franke.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.franke.model.UserModel;
import de.franke.service.UserRepository;

@RestController
public class RessourceController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/isUserAuthenticated")
	public Boolean isUserAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}

	@RequestMapping("/userDetails")
	public Map<String, String> userDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserModel user = getCurrentlyAuthenticatedUser(auth.getName());
		String firstName = user.getFirstName();
		String marriagePartner = user.getMarriagePartner();
		String userId = String.valueOf(user.getId());
		Map<String, String> userDetailsMap = new TreeMap<>();

		userDetailsMap.put("marriagePartner", marriagePartner);
		userDetailsMap.put("id", userId);
		userDetailsMap.put("firstName", firstName);
		return userDetailsMap;
	}
	
	public UserModel getCurrentlyAuthenticatedUser(String userName){
		return userRepository.findByUserName(userName);
	}
}
