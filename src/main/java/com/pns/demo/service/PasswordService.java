package com.pns.demo.service;

import com.pns.demo.models.User;

public interface PasswordService {

	User doGetUserByEmail(String email);

}
