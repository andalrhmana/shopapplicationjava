package org.tsofen.Shopapplcation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tsofen.Shopapplcation.Bean.User;

public interface UserDAO extends JpaRepository<User, Integer>{

	List<User> getByEmail(String email);

}
