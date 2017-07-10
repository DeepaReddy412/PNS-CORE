package com.pns.demo.service;

import java.util.List;

import com.pns.demo.dto.UserDTO;

public interface FriendService {

	List<UserDTO> doGetFriendsList(String email);

	void doBlockUser(String fromUser, int toId);

	void doUnBlockUser(String fromUser, int toId);

}
