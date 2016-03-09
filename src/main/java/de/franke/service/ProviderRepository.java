package de.franke.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.GuestModel;
import de.franke.model.ProviderModel;

@RepositoryRestResource(collectionResourceRel="provider", path="provider" )
public interface ProviderRepository  extends CrudRepository<ProviderModel, Long>{
	
	List<GuestModel> findByUserId (@Param("id") long id);

}

