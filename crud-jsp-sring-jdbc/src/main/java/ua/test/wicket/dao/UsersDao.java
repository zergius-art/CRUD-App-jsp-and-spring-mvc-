package ua.test.wicket.dao;

import java.util.List;
import ua.test.wicket.model.Users;

public interface UsersDao {
	
	public int create (Users user);
	
	public int update (Users user);
	
	public int delete (int userId);
	
	public List<Users> read();
	
	public List<Users> findUserById(int userId);
	
	public String login (Users user);

}
