package com.pns.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.dao.ChatDAO;
import com.pns.demo.dto.ChatDTO;
import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	CommonRepository commonRepository;

	@Autowired
	ChatDAO chatDAO;

	public CommonRepository getCommonRepository() {
		return commonRepository;
	}

	public void setCommonRepository(CommonRepository commonRepository) {
		this.commonRepository = commonRepository;
	}

	@Override
	public void doSendMessageToFriend(String from, int fid, String msg) {
		User user = commonRepository.findByEmail(from);
		chatDAO.sendMessageToFriend(user.getId(), fid, msg, LocalDateTime.now());

	}

	@Override
	public List<ChatDTO> doGetMessages(String from, int to) {
		User user = commonRepository.findByEmail(from);
		return chatDAO.getMessages(user.getId(), to);
	}

	@Override
	public void doUpdateChatNotificationStatus(String from, int to) {
		User user = commonRepository.findByEmail(from);
		chatDAO.updateChatNotificationStatus(user.getId(), to);
		
	}

}
