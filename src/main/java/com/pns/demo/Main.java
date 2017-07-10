package com.pns.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.pns.demo.models.UserDetails;

public class Main {

	@Autowired
	MainRepository mainRepository;

	public MainRepository getMainRepository() {
		return mainRepository;
	}

	public void setMainRepository(MainRepository mainRepository) {
		this.mainRepository = mainRepository;
	}

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setId(1);
		user.setName("deepa");

	}
}
