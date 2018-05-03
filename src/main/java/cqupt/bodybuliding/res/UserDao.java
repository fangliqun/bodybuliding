package cqupt.bodybuliding.res;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cqupt.bodybuliding.domain.User;

public interface UserDao extends JpaRepository<User,Integer>{
	@Query("from User as u where u.username= ?1")
	public User findUsername(String username);
	
	@Query("from User as u where u.username= ?1 and u.password= ?2")
	public User login(String username,String password);
	
	@Query("from User as u where u.type!='no'" )
	public List<User> typeAll();
	
	@Query("from User as u where u.type=?1" )
	public List<User> type(String type);
}
