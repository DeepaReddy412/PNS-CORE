package com.pns.demo.service;

import java.util.Optional;

import com.pns.demo.models.User;

public interface RegistrationService {

	void doSaveUserInformation(User u) throws Exception;

	Optional<User> doCheckUserExistsOrNot(String email);

}
