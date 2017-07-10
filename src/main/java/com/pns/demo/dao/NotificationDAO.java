package com.pns.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.pns.demo.models.User;

public interface NotificationDAO {

	void sendFriendRequest(int senderId, int receiverId, LocalDateTime now,
			boolean status);

	void cancelFriendRequest(int senderId, int receiverId, LocalDateTime now);

	void acceptFriendRequest(int senderId, int receiverI);


	List<User> getRequestedUsersList(int senderId);

}
