package com.pns.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pns.demo.dao.UserDAO;
import com.pns.demo.models.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void updateUserInformation(User user) {

		String qry = "update user set name=?,mobile_no=? where email=?";
		jdbcTemplate.update(qry, new Object[] { user.getName(),
				user.getPhone(), user.getEmail() });

	}

}
