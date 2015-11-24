package de.franke.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.franke.model.UserModel;
import de.franke.service.UserRepository;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/save/newUser", method = RequestMethod.POST)
	public @ResponseBody void saveItem(@RequestBody UserModel user) {
		userRepository.save(new UserModel(user.getFirstName(),
										  user.getLastName(),
										  user.getUserName(),
										  encryptPassword(user.getPassword()),
										  user.getFutureLastName(),
										  user.getMarriagePartner()));
		
	}

	private String encryptPassword(String password) {
		// TODO Auto-generated method stub
		return password;
	}
	
	@RequestMapping(value = "get/allUserNames", method = RequestMethod.GET)
	public @ResponseBody List<String> getAllUserNames(){
		List<String> response = new ArrayList<String>();
		List<UserModel> allUsers = (List<UserModel>) userRepository.findAll();
		
		for (UserModel userModel : allUsers) {
			response.add(userModel.getUserName());
		}
		
		return response;
	}

}
