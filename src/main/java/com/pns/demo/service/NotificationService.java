package com.pns.demo.service;

public interface NotificationService {

	void doSendfriendRequest(String from, String to);

	void doCancelfriendRequest(String from, String to);

	void doAcceptfriendRequest(String from, int to);

}
