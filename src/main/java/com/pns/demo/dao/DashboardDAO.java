package com.pns.demo.dao;

import java.util.List;

import com.pns.demo.dto.UserDTO;
import com.pns.demo.models.User;

public interface DashboardDAO {

	List<User> getUsersToSendFriendRequest(int senderId);

	List<UserDTO> getUserToSendFriendRequest(int fromId, int toId);

}
