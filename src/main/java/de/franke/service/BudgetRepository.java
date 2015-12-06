package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.franke.model.BudgetModel;

@RepositoryRestResource(collectionResourceRel="budget", path="budget" )
public interface BudgetRepository extends CrudRepository<BudgetModel, Integer> {
	
	@PreAuthorize("#username == principal.username")
	BudgetModel findByUserId (@Param("username") int username);
}
