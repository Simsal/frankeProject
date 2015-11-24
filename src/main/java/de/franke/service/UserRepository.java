package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import de.franke.model.UserModel;

@Repository
@RepositoryRestResource(collectionResourceRel="users", path="users" )
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	
	UserModel findByUserName(String userName);
	
}
