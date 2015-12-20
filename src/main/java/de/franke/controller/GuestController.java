package de.franke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.franke.model.GuestModel;
import de.franke.service.GuestRepository;
import de.franke.service.UserRepository;

@RestController
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/save/newGuest", method = RequestMethod.POST)
	public @ResponseBody void saveItem(@RequestBody GuestModel guest) {
		guestRepository.save(new GuestModel(guest.getFirstName(),
											guest.getLastName(),
											guest.getPostalCode(),
											guest.getStreet(),
											guest.getTown(),
											guest.getMarriageSide(),
											guest.getEmail(),
											guest.getInvited(),
											userRepository.findByUserName(getCurrentlyAuthenticatedUserId())));
		
	}
	
	public String getCurrentlyAuthenticatedUserId() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
