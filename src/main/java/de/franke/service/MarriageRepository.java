package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.MarriageModel;

@RepositoryRestResource(collectionResourceRel="marriage", path="marriage" )
public interface MarriageRepository  extends CrudRepository<MarriageModel, Integer>{

}
