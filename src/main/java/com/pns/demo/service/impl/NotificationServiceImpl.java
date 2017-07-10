package com.pns.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.dao.NotificationDAO;
import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationDAO notificationDAO;

	@Autowired
	CommonRepository commonRepository;

	@Override
	public void doSendfriendRequest(String from, String to) {
		boolean status = false;
		User fromUser = commonRepository.findByEmail(from);
		User toUser = commonRepository.findByEmail(to);
		notificationDAO.sendFriendRequest(fromUser.getId(), toUser.getId(),
				LocalDateTime.now(), status);
	}

	@Override
	public void doCancelfriendRequest(String from, String to) {
		User fromUser = commonRepository.findByEmail(from);
		User toUser = commonRepository.findByEmail(to);
		notificationDAO.cancelFriendRequest(fromUser.getId(), toUser.getId(),
				LocalDateTime.now());

	}

	/*
	 * @Override public void doAcceptfriendRequest(String from, String to) {
	 * User fromUser = commonRepository.findByEmail(from); User toUser =
	 * commonRepository.findByEmail(to);
	 * notificationDAO.acceptFriendRequest(fromUser.getId(), toUser.getId(),
	 * LocalDateTime.now());
	 * 
	 * }
	 */

	@Override
	public void doAcceptfriendRequest(String from, int to) {
		User fromUser = commonRepository.findByEmail(from);
		notificationDAO.acceptFriendRequest(fromUser.getId(), to);
	}

}
