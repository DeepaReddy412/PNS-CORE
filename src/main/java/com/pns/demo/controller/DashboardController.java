package com.pns.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.dto.UserDTO;
import com.pns.demo.models.User;
import com.pns.demo.service.DashboardService;

@CrossOrigin
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;

	@GetMapping("/users")
	public UserDTO getUserByEmail(
			@RequestParam(value = "from") String fromEmail,
			@RequestParam(value = "to") String toEmail) {
		return dashboardService.doGetUserByEmail(fromEmail, toEmail);
	}

	@GetMapping("/getallusers")
	public List<User> getAllUsers(@RequestParam(value = "email") String email) {
		return dashboardService.doGetllUsers(email);
	}

}
