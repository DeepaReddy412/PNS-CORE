package com.pns.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.demo.models.UserDetails;

public interface MainRepository extends JpaRepository<UserDetails, Long> {

}
