package com.pns.demo.service;

import com.pns.demo.models.User;

public interface LoginService {

	public User getUserByEmailAndPassword(String email, String password);

	public User doGetUserProfile(String email);

	public void doUpdateUserInformation(User user);

}
