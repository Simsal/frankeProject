package de.franke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
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
											guest.getStreet(),
											guest.getPostalCode(),
											guest.getTown(),
											guest.getEmail(),
											guest.getMarriageSide(),
											guest.getInvited(),
											userRepository.findByUserName(getCurrentlyAuthenticatedUserId())));
		
	}
	
	@RequestMapping(value = "/delete/guest/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteItem(@PathVariable long id) {
		
		guestRepository.delete(id);
	}
	
	@RequestMapping(value = "/update/guests/{id}", method = RequestMethod.PUT)
	public void updateById(@PathVariable("id") Long id, @RequestBody GuestModel guest) {
		
		GuestModel oldGuest = guestRepository.findOne(id);
		oldGuest.setFirstName(guest.getFirstName());
		oldGuest.setLastName(guest.getLastName());
		oldGuest.setStreet(guest.getStreet());
		oldGuest.setPostalCode(guest.getPostalCode());
		oldGuest.setTown(guest.getTown());
		oldGuest.setEmail(guest.getEmail());
		oldGuest.setMarriageSide(guest.getMarriageSide());
		oldGuest.setInvited(guest.getInvited());
		guestRepository.save(oldGuest);
	}
	
	public String getCurrentlyAuthenticatedUserId() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
