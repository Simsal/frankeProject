package de.franke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.franke.model.BudgetModel;
import de.franke.service.BudgetRepository;
import de.franke.service.UserRepository;

@RestController
public class BudgetController {
	
	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/save/newBudgetItem", method = RequestMethod.POST)
	public @ResponseBody void saveItem(@RequestBody BudgetModel budget) {
		budgetRepository.save(new BudgetModel(	budget.getTopic(),
												budget.getName(),
												budget.getPlannedValue(),
												budget.getRealValue(),
												budget.getPaid(),
												budget.getServiceProviderName(),
												budget.getServiceProviderInformation(),
												userRepository.findByUserName(getCurrentlyAuthenticatedUserId())));
		
	}
	
	@RequestMapping(value = "/delete/budget/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteItem(@PathVariable long id) {
		
		budgetRepository.delete(id);
	}
	
	@RequestMapping(value = "/update/budget/{id}", method = RequestMethod.PUT)
	public void updateById(@PathVariable("id") Long id, @RequestBody BudgetModel budgetItem) {
		
		BudgetModel oldBudgetItem = budgetRepository.findOne(id);
		oldBudgetItem.setName(budgetItem.getName());
		oldBudgetItem.setPlannedValue(budgetItem.getPlannedValue());
		oldBudgetItem.setRealValue(budgetItem.getRealValue());
		oldBudgetItem.setPaid(budgetItem.getPaid());
		oldBudgetItem.setServiceProviderName(budgetItem.getServiceProviderName());
		oldBudgetItem.setServiceProviderInformation(budgetItem.getServiceProviderInformation());
		budgetRepository.save(oldBudgetItem);
	}

	public String getCurrentlyAuthenticatedUserId() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
