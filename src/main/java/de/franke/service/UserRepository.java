package de.franke.service;

import org.springframework.data.repository.CrudRepository;

import de.franke.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
	

}
