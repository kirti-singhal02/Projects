package com.example.exitTest.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;
    String userName;
    String pass;
	public User(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}
	public String getUser_name() {
		return userName;
	}
	public void setUser_name(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    
}
