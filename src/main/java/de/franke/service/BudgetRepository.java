package de.franke.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.BudgetModel;

@RepositoryRestResource(collectionResourceRel="budget", path="budget" )
public interface BudgetRepository extends CrudRepository<BudgetModel, Long> {
	
//	@PreAuthorize("#username == principal.username")
	List<BudgetModel> findByUserId (@Param("id") int id);
}
