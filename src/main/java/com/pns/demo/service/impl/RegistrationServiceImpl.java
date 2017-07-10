package com.pns.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	CommonRepository registrationRepository;

	public CommonRepository getRegistrationRepository() {
		return registrationRepository;
	}

	public void setRegistrationRepository(
			CommonRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	@Override
	public void doSaveUserInformation(User u) throws Exception {

		Optional<User> optionalProject = Optional
				.ofNullable(registrationRepository.findByEmail(u.getEmail()));
		try {
			if (optionalProject.isPresent()) {

				throw new Exception("duplicated user");
			} else {
				registrationRepository.save(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Optional<User> doCheckUserExistsOrNot(String email) {
		Optional<User> optionalProject = Optional
				.ofNullable(registrationRepository.findByEmail(email));
		if (optionalProject.isPresent()) {
			return optionalProject;
		}
		return optionalProject;
	}

}
