package com.pns.demo.dao;

import java.util.List;

import com.pns.demo.dto.UserDTO;

public interface FriendDAO {

	List<UserDTO> getFriendsList(int id);

	void blockUser(int id, int id2);

	void unBlockUser(int id, int toId);

}
