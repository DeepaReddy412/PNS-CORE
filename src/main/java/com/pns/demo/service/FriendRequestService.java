package com.pns.demo.service;

import java.util.List;

import com.pns.demo.models.User;

public interface FriendRequestService {

	List<User> doGetUserByEmail(String email);

}
