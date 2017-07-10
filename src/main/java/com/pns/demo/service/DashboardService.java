package com.pns.demo.service;

import java.util.List;

import com.pns.demo.dto.UserDTO;
import com.pns.demo.models.User;

public interface DashboardService {

	/*UserDTO doGetUserByEmail(String email);*/

	List<User> doGetllUsers(String email);

	UserDTO doGetUserByEmail(String fromEmail, String toEmail);

	/*void doSendfriendRequest(String femail, String toemail);*/
}
