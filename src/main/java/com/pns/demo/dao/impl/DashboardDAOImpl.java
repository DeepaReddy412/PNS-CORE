package com.pns.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pns.demo.dao.DashboardDAO;
import com.pns.demo.dto.UserDTO;
import com.pns.demo.models.User;

@Repository
public class DashboardDAOImpl implements DashboardDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getUsersToSendFriendRequest(int senderId) {
		List<User> userList = null;
		StringBuilder sql = new StringBuilder(
				"SELECT u.email FROM USER u JOIN `notifications` n ON u.id=n.`sender_id` WHERE u.`id`=?1 AND n.`status`=0");
		userList = jdbcTemplate.query(sql.toString(),
				new Object[] { senderId }, (rs, rowNum) -> {
					return convert(rs);
				});

		return userList;
	}

	private User convert(ResultSet rs) throws SQLException {
		User u = new User();
		u.setEmail(rs.getString("email"));
		return u;
	}

	private UserDTO convert1(ResultSet rs) throws SQLException {
		UserDTO u = new UserDTO();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setMobileNo(rs.getString("mobile_no"));
		u.setEmail(rs.getString("email"));
		u.setStatus(rs.getString("status"));
		u.setUserType(rs.getString("userType"));
		u.setBlocked(rs.getBoolean("is_block"));
		return u;
	}

	@Override
	public List<UserDTO> getUserToSendFriendRequest(int fromId, int toId) {
		List<UserDTO> userList = null;
		StringBuilder sql = new StringBuilder(
				"SELECT u.id,u.`name`,u.`email`,u.`mobile_no`,sq.`status`,f.`is_block`,(CASE WHEN u.id=n.`sender_id` THEN 'SENDER' ELSE 'RECEIVER' END) AS userType ")
				.append("FROM USER u LEFT JOIN `notifications` n ON ((n.`sender_id`=? AND n.`receiver_id`=?) ||(n.`sender_id`=? AND n.`receiver_id`=?)) ")
				.append("LEFT JOIN `friends` f ON f.`friend_id`=u.`id` AND f.`user_id`=? LEFT JOIN `seed_request` sq ON sq.`id`=n.`status` WHERE u.id=?");

		userList = jdbcTemplate.query(sql.toString(), new Object[] { fromId,
				toId, toId, fromId,fromId, toId }, (rs, rowNum) -> {
			return convert1(rs);
		});
		return userList;
	}

}
