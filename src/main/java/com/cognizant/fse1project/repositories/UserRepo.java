package com.cognizant.fse1project.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.fse1project.models.Tweet;
import com.cognizant.fse1project.models.User;

@Repository
public interface UserRepo extends MongoRepository<User, Integer>{
	
	@Query("{'email':?0}")
	User findByEmail(String email);
	
	@Query("{},{'tweets':1}")
	List<Tweet> findAllTweets();
	
}
