package com.pns.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.models.User;
import com.pns.demo.service.PasswordService;

@CrossOrigin
@RestController
@RequestMapping("password")
public class PasswordController {

	@Autowired
	PasswordService passwordService;

	@GetMapping
	public User getUserByEmail(@RequestParam(value = "email") String email) {
		return passwordService.doGetUserByEmail(email);

	}
}
