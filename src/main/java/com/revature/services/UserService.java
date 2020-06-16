package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.NotLoggedInException;
import com.revature.models.User;
import com.revature.templates.LoginTemplate;

//The service layer is a layer that is designed to enforce your *business logic*
//These are miscellaneous rules that define how your application will function
//Ex: May not withdraw money over the current balance
//All interaction with the DAO will be through this service layer
//This design is simply furthering the same design structure that we have used up to now
//How you design the details of this layer is up to you
//Due to the nature of the "business logic" being rather arbitrary
//This layer has the MOST creativity involved
//Most other layers are pretty boilerplate, where you pretty much copy/paste 
//most methods
public class UserService {

	IUserDAO dao = new UserDAO();
	//A starting place that I like to use, is to also create CRUD methods in the service
	//layer that will be used to interact with the DAO
	
	//Then additionally, you can have extra methods to enforce whatever features/rules that
	//you want, for example log in/log out methods
	public int insert(User u) {//Create
		return dao.insert(u);
	}
	public List<User> findAll(){ //Read
		return dao.findAll();
	}
	public User findById(int id) {
		return dao.findById(id);
	}
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	public int update(User u) {//Update
		return dao.update(u);
	}
	public int delete(int id) {//Delete
		return dao.delete(id);
	}
	
	public User login(LoginTemplate lt) {
		
		User userFromDB = findByUsername(lt.getUsername());
		
		//username incorrect
		if(userFromDB == null) {
			return null;
		}
		
		//username and password are correct
		if(userFromDB.getPassword().equals(lt.getPassword())) {
			return userFromDB;
		}
		
		// username right, password not
		return null;
	}
	public void logout(HttpSession session) {
		
		if(session == null || session.getAttribute("currentUser") == null) {
			throw new NotLoggedInException();
		}
		session.invalidate();
	}
	
}