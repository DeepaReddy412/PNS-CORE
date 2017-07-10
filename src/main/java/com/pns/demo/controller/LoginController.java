package com.pns.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.models.User;
import com.pns.demo.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/getUser")
	public User authenticateUserByEmailAndPassword(
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		return loginService.getUserByEmailAndPassword(email, password);
	}
	
	@GetMapping("/getProfile")
	public User getProfileInfo(@RequestParam(value = "email") String email) {
		return loginService.doGetUserProfile(email);
	}
	
	@PutMapping("/update/user")
	public void updateUserInformation(@RequestBody User user) {
		try {
			loginService.doUpdateUserInformation(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
