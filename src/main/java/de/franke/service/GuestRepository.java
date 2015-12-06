package de.franke.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.GuestModel;

@RepositoryRestResource(collectionResourceRel="guests", path="guests" )
public interface GuestRepository extends CrudRepository<GuestModel, Long> {
	
	List<GuestModel> findByUserId (@Param("id") int id);

}
