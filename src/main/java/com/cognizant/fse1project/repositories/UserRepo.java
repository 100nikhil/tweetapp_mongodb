package com.cognizant.fse1project.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.fse1project.models.User;
import com.cognizant.fse1project.models.UserTweets;

@Repository
public interface UserRepo extends MongoRepository<User, Integer>{
	
	@Query("{'email':?0}")
	User findByEmail(String email);
	
	@Query(value="{}",fields="{'tweets':1, '_id':0}")
	List<UserTweets> findAllTweets();
	
	//By above query I am getting only 'tweets' field from all documents
	
	/*
	 * List findByNameAndBandOrderBySalary(String name, String band);
	 * 
	 * @Query("{'name' : ?0 , 'band' : ?1}")   //AND Operator
	   List findEmployeeByNameAndBand(String name, String band);  
	 * 
	 * 
	 * @Query(value = "{'employees.name': ?0, 'employees.salary' : { $gt: ?1 }}", fields = "{'employees' : 0}")
	 * name = ?0 passed name, salary greater than ?1 passed salary, excluding 'employees' field
	 *
	 * 
	 * @Query("{salary : {$lt : ?0, $gt : ?1}}")
	   List findEmployeeBySalaryRange(double maxSalary, double minSalary);

	 * @Query("{ 'name' : { $regex: ?0 } }")
	   List findByRegex(String regexp);
	 * 
	 * @Query("{name : {$ne : ?0}}")
		List findByNameNotEqual(String countryName);
		
		@Query("{'name' : null}")
		List findEmployeeByNameIsNull();
		
		@Query("{'name' : {$ne : null}}")
		List findEmployeeByNameIsNotNull();
	 * 
	 * 
	 * 
	 * 
	 * */
	
}
