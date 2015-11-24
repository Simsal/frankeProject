package de.franke.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.franke.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	
	UserModel findByUserName(String userName);

}
