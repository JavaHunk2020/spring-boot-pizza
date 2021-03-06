package com.pizza.service;

import java.util.List;

import com.pizza.dto.SignupDTO;

public interface SignupService {
	
	SignupDTO authUser(String username, String password);
	void persist(SignupDTO signupDTO);
	SignupDTO findById(int sid);
	void deleteById(int sid);
	List<SignupDTO> findAll();
	void updateSignup(SignupDTO signupEntity);
	List<SignupDTO> getSignups(int pageid, int total);
	int findTotalSignup();
	byte[] findImageById(int sid);

}
