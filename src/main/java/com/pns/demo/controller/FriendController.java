package com.pns.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.dto.UserDTO;
import com.pns.demo.service.FriendService;

@CrossOrigin
@RestController
@RequestMapping("/friends")
public class FriendController {

	@Autowired
	FriendService friendService;

	@GetMapping
	public List<UserDTO> getFriendsList(
			@RequestParam(value = "email") String email) {
		return friendService.doGetFriendsList(email);

	}

	@PutMapping("/block")
	public void blockUser(@RequestParam(value = "from") String fromUser,
			@RequestParam(value = "to") int toId) {
		friendService.doBlockUser(fromUser, toId);

	}

	@PutMapping("/unblock")
	public void unBlockUser(@RequestParam(value = "from") String fromUser,
			@RequestParam(value = "to") int toId) {
		friendService.doUnBlockUser(fromUser, toId);

	}
}
