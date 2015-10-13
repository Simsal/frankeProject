package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.BudgetModel;

@RepositoryRestResource(collectionResourceRel="budget", path="budget" )
public interface BudgetRepository extends CrudRepository<BudgetModel, Integer> {

}
