package com.koitt.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.board.util.DBUtil;
import com.koitt.board.vo.Users;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class UsersDao {

	public List<Users> sellectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();

		String sql = "SELECT * FROM users ORDER BY no DESC";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		List<Users> list = new ArrayList<Users>();
		while (rs.next()) {
			Users users = new Users();

			users.setEmail(rs.getString("email"));
			users.setName(rs.getString("name"));
			users.setPassword(rs.getString("password"));
			users.setNo(rs.getInt("no"));

			list.add(users);
		}

		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);

		return list;
	}
	
	public void insert(Users users) throws ClassNotFoundException, SQLException, MySQLIntegrityConstraintViolationException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO users (email, password, name) ");
		sql.append("VALUES (?, ?, ?) ");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, users.getEmail());
		pstmt.setString(2, users.getPassword());
		pstmt.setString(3, users.getName());
		pstmt.executeUpdate();		
		
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
	}
	
	public Users select(String email) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT * FROM users WHERE email = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		Users users = new Users();
		users.setEmail(rs.getString("email"));
		users.setName(rs.getString("name"));
		users.setNo(rs.getInt("no"));
		//users.setPassword(rs.getString("password"));
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return users;
	}
	
	public boolean matches(String email, String password) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT no FROM users WHERE email = ? AND password = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		boolean isMatches = rs.next();
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return isMatches;
	}
}
