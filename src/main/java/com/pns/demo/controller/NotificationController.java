package com.pns.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.service.NotificationService;


@CrossOrigin
@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	@PutMapping("/sendFriendReq")
	public void sendRequest(@RequestParam(value = "from") String from,
			@RequestParam(value = "to") String to) {
		notificationService.doSendfriendRequest(from, to);

	}
	
	@PutMapping("/cancelReq")
	public void cancelRequest(@RequestParam(value = "from") String from,
			@RequestParam(value = "to") String to) {
		notificationService.doCancelfriendRequest(from, to);

	}
	
	/*@PutMapping("/acceptReq")
	public void acceptRequest(@RequestParam(value = "from") String from,
			@RequestParam(value = "to") String to) {
		notificationService.doAcceptfriendRequest(from, to);

	}*/

}
