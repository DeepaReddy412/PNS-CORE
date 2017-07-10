package com.pns.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pns.demo.dao.FriendDAO;
import com.pns.demo.dto.UserDTO;

@Repository
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public List<UserDTO> getFriendsList(int id) {
		String qry = "SELECT u.`id`,u.`name`,u.`email`,u.`mobile_no`,f.`is_block`,COUNT(c.`is_recent`) AS msgcount FROM USER u JOIN friends f "
				+ "ON f.`friend_id`=u.`id` LEFT JOIN chat c ON (c.`user_id`=u.`id` AND c.`friend_id`=? AND c.`is_recent`=1) WHERE f.`user_id`=? GROUP BY u.`id`";

		List<UserDTO> list = JdbcTemplate.query(qry, new Object[] { id, id }, (
				rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}

	private UserDTO convert(ResultSet rs) throws SQLException {
		UserDTO u = new UserDTO();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));
		u.setMobileNo(rs.getString("mobile_no"));
		u.setBlocked(rs.getBoolean("is_block"));
		u.setMsgCount(rs.getInt("msgcount"));
		return u;
	}

	@Override
	public void blockUser(int userId, int fId) {
		String qry = "update friends set is_block=1 where user_id=? and friend_id=?";
		JdbcTemplate.update(qry, new Object[] { userId, fId });

	}

	@Override
	public void unBlockUser(int userId, int fId) {
		String qry = "update friends set is_block=0 where user_id=? and friend_id=?";
		JdbcTemplate.update(qry, new Object[] { userId, fId });
	}
}
