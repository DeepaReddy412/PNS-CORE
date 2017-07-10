package com.pns.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.demo.dao.FriendDAO;
import com.pns.demo.dto.UserDTO;
import com.pns.demo.models.User;
import com.pns.demo.repository.CommonRepository;
import com.pns.demo.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendDAO friendDAO;

	@Autowired
	CommonRepository commonRepository;

	@Override
	public List<UserDTO> doGetFriendsList(String email) {
		User user = commonRepository.findByEmail(email);
		return friendDAO.getFriendsList(user.getId());
	}

	@Override
	public void doBlockUser(String email, int toId) {
		User user = commonRepository.findByEmail(email);
		friendDAO.blockUser(user.getId(), toId);
		/*friendDAO.blockUser(toId, user.getId());*/

	}

	@Override
	public void doUnBlockUser(String email, int toId) {
		User user = commonRepository.findByEmail(email);
		friendDAO.unBlockUser(user.getId(), toId);
	}

}
