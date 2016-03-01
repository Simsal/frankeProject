package de.franke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.franke.model.ProviderModel;
import de.franke.service.ProviderRepository;
import de.franke.service.UserRepository;

@RestController
public class ProviderController {
	
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/save/newProvider", method = RequestMethod.POST)
	public @ResponseBody void saveItem(@RequestBody ProviderModel provider) {
		providerRepository.save(new ProviderModel(	provider.getName(),
												provider.getStreet(),
												provider.getPostalCode(),
												provider.getTown(),
												provider.getEmail(),
												provider.getTelephone(),
												provider.getMobilephone(),
												provider.getComment(),
												userRepository.findByUserName(getCurrentlyAuthenticatedUserId())));
		
	}
	
	@RequestMapping(value = "/delete/provider/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteItem(@PathVariable long id) {
		
		providerRepository.delete(id);
	}
	
	@RequestMapping(value = "/update/provider/{id}", method = RequestMethod.PUT)
	public void updateById(@PathVariable("id") Long id, @RequestBody ProviderModel provider) {
		
		ProviderModel oldProvider = providerRepository.findOne(id);
		oldProvider.setName(provider.getName());
		oldProvider.setStreet(provider.getStreet());
		oldProvider.setPostalCode(provider.getPostalCode());
		oldProvider.setTown(provider.getTown());
		oldProvider.setEmail(provider.getEmail());
		oldProvider.setTelephone(provider.getTelephone());
		oldProvider.setMobilephone(provider.getMobilephone());
		oldProvider.setComment(provider.getComment());
		providerRepository.save(oldProvider);
	}

	public String getCurrentlyAuthenticatedUserId() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
