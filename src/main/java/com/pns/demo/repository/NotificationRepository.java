package com.pns.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.demo.models.Notification;

public interface NotificationRepository extends
		JpaRepository<Notification, Integer> {

	/*
	 * @Query(name =
	 * "insert into notifications(sender_id,receiver_id,sent_on,status) values(?1,?2,?3,?4) "
	 * , nativeQuery = true) void sendFriendRequest(int senderId, int
	 * receiverId, LocalDateTime now, boolean status);
	 */

}
