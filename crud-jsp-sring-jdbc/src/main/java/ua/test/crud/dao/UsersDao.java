package ua.test.crud.dao;

import java.util.List;

import ua.test.crud.model.Users;

public interface UsersDao {
	
	public int create (Users user);
	
	public int update (Users user);
	
	public int delete (int userId);
	
	public List<Users> read();
	
	public List<Users> findUserById(int userId);
	
	public String login (Users user);

}
