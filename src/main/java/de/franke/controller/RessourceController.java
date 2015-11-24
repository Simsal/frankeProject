package de.franke.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.franke.model.UserModel;
import de.franke.service.UserRepository;

@RestController
public class RessourceController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	  

	@RequestMapping("/isUserAuthenticated")
	public Boolean isUserAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}

	@RequestMapping("/userDetails")
	public Map<String, String> userDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserModel user = getCurrentlyAuthenticatedUser(auth.getName());
		String firstName = user.getFirstName();
		Map<String, String> userDetailsMap = new TreeMap<>();

		userDetailsMap.put("username", auth.getName());
		userDetailsMap.put("firstName", firstName);
		return userDetailsMap;
	}
	
	public UserModel getCurrentlyAuthenticatedUser(String userName){
		return userRepository.findByUserName(userName);
	}
}
