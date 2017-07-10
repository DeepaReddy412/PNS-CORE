package com.pns.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.dao.DashboardDAO;
import com.pns.demo.dto.UserDTO;
import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.repository.NotificationRepository;
import com.pns.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	CommonRepository commonRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	DashboardDAO dashboardDAO;

	@Override
	public UserDTO doGetUserByEmail(String fromEmail, String toEmail) {
		UserDTO u = null;
		User fromuser = commonRepository.findByEmail(fromEmail);
		User toUser = commonRepository.findByEmail(toEmail);
		List<UserDTO> users = dashboardDAO.getUserToSendFriendRequest(
				fromuser.getId(), toUser.getId());
		for (UserDTO user : users) {
			u = user;
		}
		return u;
	}

	@Override
	public List<User> doGetllUsers(String email) {
		List<User> users = commonRepository.findAll();
		return users.stream().filter(u -> !u.getEmail().equals(email))
				.collect(Collectors.toList());
	}
}
