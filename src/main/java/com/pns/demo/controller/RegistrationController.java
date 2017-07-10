package com.pns.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.models.User;
import com.pns.demo.service.RegistrationService;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	public RegistrationService getRegistrationService() {
		return registrationService;
	}

	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@PutMapping("/save")
	public void saveUserInformation(@RequestBody User u) {
		try {
			getRegistrationService().doSaveUserInformation(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/getUserByEmail")
	public Optional<User> getUserInfo(@RequestParam(value = "email") String email) {
		return registrationService.doCheckUserExistsOrNot(email);

	}
}