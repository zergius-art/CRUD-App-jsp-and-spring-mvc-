package ua.test.wicket.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.test.wicket.model.Users;

public class UsersDaoImpl implements UsersDao {

	private JdbcTemplate jdbcTemplate;

	public UsersDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public int create(Users user) {
		String sql = "insert into users (u_name, u_pass) values(?,?)";
		try {
			int counter = jdbcTemplate.update(sql, new Object[] {user.getName(), user.getPass()});
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int update(Users user) {
		String sql = "update users set u_name=?, u_pass=? where id=?";
		try {
			int counter = jdbcTemplate.update(sql, new Object[] {user.getName(), user.getPass(), user.getId()});
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int userId) {
		String sql = "delete from users where id=?";
		try {
			int counter = jdbcTemplate.update(sql, new Object[] {userId});
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Users> read() {
		List<Users> userList = jdbcTemplate.query("select * from users", new RowMapper<Users>() {
			
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("u_name"));
				user.setPass(rs.getString("u_pass"));
				
				return user;
			}
		});
		return userList;
	}

	@Override
	public List<Users> findUserById(int userId) {
		List<Users> user = jdbcTemplate.query("select * from users where id=?",
				new Object[] {userId}, new RowMapper<Users>() {
			
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("u_name"));
				user.setPass(rs.getString("u_pass"));
				
				return user;
			}
		});
		
			return user;
	}

	@Override
	public String login(Users user) {
		String sql = "select u_name from users where u_name=? and u_pass=?";
		try {
			String name = jdbcTemplate.queryForObject(sql, new Object[] {user.getName(), user.getPass()}, String.class);
			return name;
		} catch (Exception e) {
			return null;
		}
	}

}
