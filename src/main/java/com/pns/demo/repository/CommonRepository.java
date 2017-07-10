/**
 * 
 */
package com.pns.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pns.demo.models.User;

/**
 * @author Revature
 *
 */

public interface CommonRepository extends JpaRepository<User, Integer> {

	@Query(name = "select * from user where email=?1", nativeQuery = true)
	public User findByEmail(String emailId);
	
	@Query(value = "select * from user where email=?1 and password=?2", nativeQuery = true)
	public User findByEmailAndPassword(String emailId, String password);


}
