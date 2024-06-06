package com.example.exitTest.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exitTest.entity.User;


public interface UserRepo extends JpaRepository<User,String> {
	
	Optional<User> findByuserName(String userName);

}
