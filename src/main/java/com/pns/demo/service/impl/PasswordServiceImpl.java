package com.pns.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	CommonRepository repository;
	
	@Override
	public User doGetUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

}
