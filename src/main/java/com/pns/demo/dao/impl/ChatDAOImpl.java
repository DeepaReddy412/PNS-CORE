package com.pns.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pns.demo.dao.ChatDAO;
import com.pns.demo.dto.ChatDTO;

@Repository
public class ChatDAOImpl implements ChatDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void sendMessageToFriend(int id, int fid, String msg,
			LocalDateTime now) {
		String qry = "INSERT INTO chat(user_id,friend_id,started_on,ended_on,is_recent) VALUES(?,?,?,?,?);";
		int row = jdbcTemplate.update(qry,
				new Object[] { id, fid, now, now, 1 });
		if (row > 0) {
			String qry1 = "INSERT INTO `chat_history`(chat_id,message,`delievered_on`) VALUES((SELECT id FROM chat WHERE `user_id`=? "
					+ "AND `friend_id`=? ORDER BY id DESC LIMIT 1),?,?)";
			jdbcTemplate.update(qry1, new Object[] { id, fid, msg,
					LocalDateTime.now() });
		}
	}

	@Override
	public List<ChatDTO> getMessages(int from, int to) {
		List<ChatDTO> msgs = null;
		StringBuilder sql = new StringBuilder(
				"SELECT c.`user_id`,c.`friend_id`,ch.`chat_id`,ch.`message`,ch.`delievered_on` FROM chat c JOIN `chat_history` ch ")
				.append("ON c.`id`=ch.`chat_id` WHERE (c.`user_id`=? AND c.`friend_id`=?) ")
				.append("||(c.`user_id`=? AND c.`friend_id`=?) ORDER BY ch.`delievered_on`");

		msgs = jdbcTemplate.query(sql.toString(), new Object[] { from, to, to,
				from }, (rs, rowNum) -> {
			return convertToobj(rs);
		});
		return msgs;
	}

	private ChatDTO convertToobj(ResultSet rs) throws SQLException {
		ChatDTO c = new ChatDTO();
		c.setChatId(rs.getInt("chat_id"));
		c.setMsg(rs.getString("message"));
		c.setDelieveredOn(rs.getTimestamp("delievered_on").toLocalDateTime());
		c.setUserId(rs.getInt("user_id"));
		c.setFriendId(rs.getInt("friend_id"));
		return c;
	}

	@Override
	public void updateChatNotificationStatus(int from, int to) {
		String qry = "UPDATE `chat` c SET c.`is_recent`=0 WHERE (c.`user_id`=? OR c.`friend_id`=?)";
		jdbcTemplate.update(qry, new Object[] { to, from });
	}

}
