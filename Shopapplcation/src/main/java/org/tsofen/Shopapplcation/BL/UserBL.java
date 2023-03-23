package org.tsofen.Shopapplcation.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsofen.Shopapplcation.Bean.User;
import org.tsofen.Shopapplcation.DAO.UserDAO;
import org.tsofen.Shopapplcation.Exptions.EmailIsAlreadyExistExciption;

@Service
public class UserBL {
	
	@Autowired
	UserDAO userDAO;
	
	public User addnewUser(User newUser) throws EmailIsAlreadyExistExciption {
		if(!(userDAO.getByEmail(newUser.getEmail()).isEmpty())) {
			throw new EmailIsAlreadyExistExciption();
		}
		userDAO.save(newUser);
		return newUser;
	}
	
	public void deleteUser(User User) {
		userDAO.delete(User);;
	}
	
	public List<User> getallusers(){
		return userDAO.findAll();
	}
}
