package com.example.exitTest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exitTest.Repo.UserRepo;
import com.example.exitTest.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
public class UserCotroller {
	@Autowired
	UserRepo repo;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {

	    Optional<User> existingUser = repo.findByuserName(user.getUser_name());

	    if (existingUser.isPresent()) {

	        return ResponseEntity.badRequest().build();

	    }
	    User savedUser = repo.save(user);

	    return ResponseEntity.ok(savedUser);

	}
    

    
	@PostMapping("/login")
	public Boolean login(@RequestParam("userName") String userName, @RequestParam("pass") String pass,
			HttpSession session) {
		Optional<User> user = repo.findByuserName(userName);
		if (user.isPresent() && user.get().getPass().equals(pass)) {
			session.setAttribute("user_name", userName);
			System.out.println(session);
			return true;
		} else {
			System.out.println("Wrong Credentials");
			return false;
		}
	}

	@GetMapping("/logout")
    public void logout(HttpServletRequest request) {
			
        // Invalidate the user's session
        request.getSession().invalidate();
        System.out.println(request.getSession());
       
    }

}
