package com.pns.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.dao.UserDAO;
import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CommonRepository commonRepository;

	@Autowired
	UserDAO userDAO;

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return commonRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User doGetUserProfile(String email) {
		return commonRepository.findByEmail(email);
	}

	@Override
	public void doUpdateUserInformation(User user) {
		userDAO.updateUserInformation(user);
	}

}
