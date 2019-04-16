package com.reporter.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.reporter.dao.UserDao;
import com.reporter.entity.Users;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertUser(Users user) {
		String sql = "INSERT INTO users " +
				"(userName, password, enabled) VALUES (?, ?, true)" ;
		getJdbcTemplate().update(sql, new Object[]{
				 user.getUserName(),user.getPassword()
		});
	}
	
	@Override
	public void insertUsers(final List<Users> users) {
		String sql = "INSERT INTO users " + "(userName, password, enabled) VALUES (?, ?, true)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Users user = users.get(i);
				
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
			}
			
			public int getBatchSize() {
				return users.size();
			}
		});

	}
	@Override
	public List<Users> getAllUsers(){
		String sql = "SELECT * FROM users";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Users> result = new ArrayList<Users>();
		for(Map<String, Object> row:rows){
			Users user = new Users();
			user.setUserName((String)row.get("userName"));
			user.setPassword((String)row.get("password"));
			result.add(user);
		}
		
		return result;
	}

	@Override
	public Users getUserById(String userId) {
		String sql = "SELECT * FROM users WHERE userId = ?";
		return (Users)getJdbcTemplate().queryForObject(sql, new Object[]{userId}, new RowMapper<Users>(){
			@Override
			public Users mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Users user = new Users();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
	}
}