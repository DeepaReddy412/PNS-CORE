package com.pns.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.pns.demo.dto.ChatDTO;

public interface ChatDAO {

	void sendMessageToFriend(int id, int fid, String msg, LocalDateTime now);

	List<ChatDTO> getMessages(int i, int to);

	void updateChatNotificationStatus(int id, int to);

}
