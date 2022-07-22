package com.cognizant.fse1project.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fse1project.models.Reply;
import com.cognizant.fse1project.models.Tweet;
import com.cognizant.fse1project.models.User;
import com.cognizant.fse1project.models.UserTweets;
import com.cognizant.fse1project.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
//	@Autowired
//	private MongoTemplate mongoTemplate;

	public User register(User user) {
		user.setId(Math.random()+"");
		return userRepo.save(user);
	}

	public User login(User user) {
		User u =  userRepo.findByEmail(user.getEmail());
		//System.out.println(u);
		if(u!=null) {
			if(u.getPassword().equals(user.getPassword())) {
				return u;
			}
		}
		return null;
	}

	public List<User> getAll() {
		
		List<User> l = userRepo.findAll();
		if(l!=null) {
			return l;
		}
		return null;
	}

	public List<Tweet> getAllTweets() {
		
		List<UserTweets> t = userRepo.findAllTweets();
		List<Tweet> uTweets = new ArrayList<>();
		if(t!=null) {
			for(UserTweets o: t) {
				List<Tweet> temp = o.getTweets();
				if(temp!=null) {					
					for(Tweet t1: temp) {
						uTweets.add(t1);
					}
				}
			}
			return uTweets;
		}
		return null;
	}

	public User searchByUsername(String username) {
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			return u;
		}
		return null;
	}

	public Set<Tweet> getAllTweetsForUser(String username) {
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			Set<Tweet> t = u.getTweets();
			return t;
		}
		return null;
	}

	public User addNewTweet(String username, Tweet t) {
		
		t.setTid(Math.random()+"");
		t.setCreated(LocalDateTime.now());
		t.setLike(false);
		System.out.println(t);
		
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			Set<Tweet> tweets = u.getTweets();
			if(tweets==null) {
				Set<Tweet> tset = new HashSet<>();
				tset.add(t);
				u.setTweets(tset);
			}
			else {
				tweets.add(t);
				u.setTweets(tweets);
			}
			return userRepo.save(u);
			
		} 
		return null;
	}

	public User updateTweet(String username, String id, Tweet t) {
		
		t.setCreated(LocalDateTime.now());
		t.setTid(id);
		t.setLike(false);
		
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			Set<Tweet> tweets = u.getTweets();
			if(tweets==null) {
				Set<Tweet> tset = new HashSet<>();
				tset.add(t);
				u.setTweets(tset);
			}
			else {
				Tweet found = null;
				for(Tweet t1: tweets) {
					if(t1.getTid().equals(id)) {
						found = t1;
						break;
					}
				}
				tweets.remove(found);
				tweets.add(t);
				u.setTweets(tweets);
			}
			
			return userRepo.save(u);
			
		} 
		return null;
	}

	public User deleteTweet(String username, String id) {
		
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			Set<Tweet> tweets = u.getTweets();
			Tweet found = null;
			if(tweets!=null) {				
				for(Tweet t1: tweets) {
					if(t1.getTid().equals(id)) {
						found = t1;
						break;
					}
				}
			}
			tweets.remove(found);
			u.setTweets(tweets);
			
			return userRepo.save(u);	
		}
		return null;
	}

	public User likeTweet(String username, String id) {
		
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			Set<Tweet> tweets = u.getTweets();
			Tweet found = null;
			if(tweets!=null) {				
				for(Tweet t1: tweets) {
					if(t1.getTid().equals(id)) {
						found = t1;
						break;
					}
				}
			}
			Tweet newT = new Tweet();
			newT.setCreated(LocalDateTime.now());
			newT.setLike(!found.isLike());
			newT.setTid(id);
			newT.setTweet(found.getTweet());
			newT.setReplies(found.getReplies());
			
			tweets.remove(found);
			tweets.add(newT);
			u.setTweets(tweets);
			
			return userRepo.save(u);	
		}
			
		return null;
	}

	public User addNewReply(String username, String id, Reply reply) {
		
		User u = userRepo.findByEmail(username);
		if(u!=null) {
			Set<Tweet> tweets = u.getTweets();
			Tweet found = null;
			if(tweets!=null) {				
				for(Tweet t1: tweets) {
					if(t1.getTid().equals(id)) {
						found = t1;
						break;
					}
				}
			}
//			Tweet newT = new Tweet();
//			newT.setCreated(LocalDateTime.now());
//			newT.setLike(!found.isLike());
//			newT.setTid(id);
//			newT.setTweet(found.getTweet());
			
			Set<Reply> reps = found.getReplies();
			if(reps!=null) {
				reps.add(reply);
			}
			else {
				Set<Reply> s = new HashSet<>();
				s.add(reply);
				found.setReplies(s);
			}
			
//			tweets.remove(found);
//			tweets.add(newT);
			u.setTweets(tweets);
			
			return userRepo.save(u);	
		}
		return null;
	}
	
}
