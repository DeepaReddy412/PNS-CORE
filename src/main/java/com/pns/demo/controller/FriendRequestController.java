package com.pns.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.models.User;
import com.pns.demo.service.FriendRequestService;
import com.pns.demo.service.NotificationService;

@CrossOrigin
@RestController
@RequestMapping("/requests")
public class FriendRequestController {

	@Autowired
	FriendRequestService friendRequestService;

	@Autowired
	NotificationService notificationService;

	@GetMapping("/getallusers")
	public List<User> getUserByEmail(@RequestParam(value = "email") String email) {
		return friendRequestService.doGetUserByEmail(email);

	}

	@PostMapping("/acceptReq")
	public void acceptFriendRequest(@RequestParam(value = "from") String from,
			@RequestParam(value = "to") int to) {
		notificationService.doAcceptfriendRequest(from, to);

	}
}
