package com.pizza.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupDaoRepository  extends JpaRepository<SignupEntity, Integer> {
	
	public Optional<SignupEntity> findByUsernameAndPassword(String username,String password);
}
