package org.tsofen.Shopapplcation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsofen.Shopapplcation.BL.UserBL;
import org.tsofen.Shopapplcation.Bean.User;
import org.tsofen.Shopapplcation.Exptions.EmailIsAlreadyExistExciption;

@RestController
@RequestMapping("Users")
@CrossOrigin
public class Usercontroller {
	
	@Autowired
	UserBL userBL;
	
	@PostMapping("add")
	public ResponseEntity addUser(@RequestBody User user){
		try {
			User user1 = userBL.addnewUser(user);
			return ResponseEntity.ok(user1);
		}catch(EmailIsAlreadyExistExciption e) {	
			return ResponseEntity.status(HttpStatus.CONFLICT).body("user already exist"); 
		}
	}
	
	@GetMapping("all")
	public List<User> getAllUsers(){
		return userBL.getallusers();
		
	}
}
