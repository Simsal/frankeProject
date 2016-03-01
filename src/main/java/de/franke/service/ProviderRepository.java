package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.ProviderModel;

@RepositoryRestResource(collectionResourceRel="provider", path="provider" )
public interface ProviderRepository  extends CrudRepository<ProviderModel, Long>{

}

