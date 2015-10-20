package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.franke.model.UserModel;

@RepositoryRestResource(collectionResourceRel="user", path="user" )
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	

}
