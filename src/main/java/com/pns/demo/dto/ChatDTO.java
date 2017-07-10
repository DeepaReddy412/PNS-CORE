package com.pns.demo.dto;

import java.time.LocalDateTime;

public class ChatDTO {

	private int id;
	private int chatId;
	private String msg;

	private LocalDateTime delieveredOn;
	private int userId;
	private int friendId;
	private boolean recentNotification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public LocalDateTime getDelieveredOn() {
		return delieveredOn;
	}

	public void setDelieveredOn(LocalDateTime delieveredOn) {
		this.delieveredOn = delieveredOn;
	}

	public boolean isRecentNotification() {
		return recentNotification;
	}

	public void setRecentNotification(boolean recentNotification) {
		this.recentNotification = recentNotification;
	}

}
