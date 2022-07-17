package com.cognizant.fse1project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.fse1project.models.Reply;
import com.cognizant.fse1project.models.Tweet;
import com.cognizant.fse1project.models.User;
import com.cognizant.fse1project.services.UserService;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user){
		return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		User u = userService.login(user);
		if(u!=null) {			
			return new ResponseEntity<>("You are successfully logged In", HttpStatus.OK);
		}
		return new ResponseEntity<>("Wrong email or password!", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/{username}/add")
	public ResponseEntity<?> addTweet(@PathVariable String username, @RequestBody Tweet t){
		return new ResponseEntity<>(userService.addNewTweet(username, t), HttpStatus.CREATED);
	}
	
	@PostMapping("/{username}/reply/{id}")
	public ResponseEntity<?> addReply(@PathVariable String username, @PathVariable String id, @RequestBody Reply reply){
		return new ResponseEntity<>(userService.addNewReply(username, id, reply), HttpStatus.CREATED);
	}

	
	@GetMapping("/users")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllTweets(){
		return new ResponseEntity<>(userService.getAllTweets(), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<?> getAllTweets(@PathVariable String username){
		return new ResponseEntity<>(userService.getAllTweetsForUser(username), HttpStatus.OK);
	}

	@GetMapping("/user/search/{username}")
	public ResponseEntity<?> searchByUsername(@PathVariable String username){
		return new ResponseEntity<>(userService.searchByUsername(username), HttpStatus.OK);
	}
	
	@PutMapping("/{username}/update/{id}")
	public ResponseEntity<?> updateTweet(@PathVariable String username, @PathVariable String id, @RequestBody Tweet t){
		return new ResponseEntity<>(userService.updateTweet(username, id, t), HttpStatus.OK);	
	}

	@PutMapping("/{username}/like/{id}")
	public ResponseEntity<?> likeTweet(@PathVariable String username, @PathVariable String id){
		return new ResponseEntity<>(userService.likeTweet(username, id), HttpStatus.OK);	
	}
	
	@DeleteMapping("/{username}/delete/{id}")
	public ResponseEntity<?> deleteTweet(@PathVariable String username, @PathVariable String id){
		return new ResponseEntity<>(userService.deleteTweet(username, id), HttpStatus.OK);	
	}

}
