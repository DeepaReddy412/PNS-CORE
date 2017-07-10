package com.pns.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pns.demo.dto.ChatDTO;
import com.pns.demo.service.ChatService;

@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	ChatService chatService;

	@PostMapping
	public void chatWithFriend(@RequestParam(value = "from") String from,
			@RequestParam(value = "toId") int to,
			@RequestParam(value = "msg") String msg) {
		chatService.doSendMessageToFriend(from, to, msg);

	}
	
	@PostMapping("/update")
	public void updateChatNotificationStatus(@RequestParam(value = "from") String from,
			@RequestParam(value = "toId") int to) {
		chatService.doUpdateChatNotificationStatus(from, to);

	}

	@GetMapping("/getAllMessages")
	public List<ChatDTO> getChatMessages(
			@RequestParam(value = "from") String from,
			@RequestParam(value = "toId") int to) {
		return chatService.doGetMessages(from, to);

	}
	/*@GetMapping("/getAllMessages")
	public List<ChatDTO> getChatMessages(
			@RequestParam(value = "from") int from,
			@RequestParam(value = "toId") int to) {
		return chatService.doGetMessages(from, to);

	}*/
}
