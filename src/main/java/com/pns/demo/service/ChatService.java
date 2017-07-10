package com.pns.demo.service;

import java.util.List;

import com.pns.demo.dto.ChatDTO;

public interface ChatService {

	void doSendMessageToFriend(String from, int to, String msg);

	List<ChatDTO> doGetMessages(String from, int to);

	void doUpdateChatNotificationStatus(String from, int to);

}
