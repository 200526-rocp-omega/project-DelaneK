package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {

	//All methods are public and abstract even if you don't write it
	public int insert(User u);//Create
		
	public List<User> findAll(); //Read
	public User findById(int id);
	public User findByUsername(String username);
	
	public int update(User u);//Update
	
	public int delete(int id);//Delete
	
	
}
