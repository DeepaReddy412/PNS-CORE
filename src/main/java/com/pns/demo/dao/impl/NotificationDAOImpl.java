package com.pns.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pns.demo.dao.NotificationDAO;
import com.pns.demo.models.User;

@Repository
public class NotificationDAOImpl implements NotificationDAO {

	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public void sendFriendRequest(int senderId, int receriverId,
			LocalDateTime today, boolean status) {
		int id = 3;
		String qry = "insert into notifications(sender_id,receiver_id,sent_on,status) values(?,?,?,?)";
		JdbcTemplate.update(qry, new Object[] { senderId, receriverId, today,
				id });
	}

	@Override
	public void cancelFriendRequest(int senderId, int receiverId,
			LocalDateTime today) {

		String qry = "UPDATE notifications SET STATUS=1 WHERE sender_id=? AND receiver_id=?";
		JdbcTemplate.update(qry, new Object[] { senderId, receiverId });

	}

	@Override
	public void acceptFriendRequest(int senderId, int receiverId) {

		String qry = "update notifications set status=2 where sender_id=? and receiver_id=?";
		JdbcTemplate.update(qry, new Object[] { receiverId, senderId });
		saveObject(senderId, receiverId);
		saveObject(receiverId, senderId);
	}

	private void saveObject(int senderId, int receiverId) {
		String qry = "INSERT INTO friends(user_id,friend_id) VALUES (?,?)";
		JdbcTemplate.update(qry, new Object[] { senderId, receiverId });
	}

	@Override
	public List<User> getRequestedUsersList(int senderId) {
		String qry = "SELECT u.`id`,u.`name`,u.email,u.`mobile_no`,n.`sent_on` FROM USER u JOIN notifications n ON n.`sender_id`=u.id "
				+ "WHERE n.`receiver_id`=? AND n.`status`=3";

		List<User> list = JdbcTemplate.query(qry, new Object[] { senderId }, (
				rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}

	private User convert(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));

		return u;
	}

}
