package com.pns.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.dao.NotificationDAO;
import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.FriendRequestService;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {

	@Autowired
	CommonRepository commonRepository;

	@Autowired
	NotificationDAO notificationDAO;

	@Override
	public List<User> doGetUserByEmail(String email) {
		User u = commonRepository.findByEmail(email);
		return notificationDAO.getRequestedUsersList(u.getId());

	}

}
