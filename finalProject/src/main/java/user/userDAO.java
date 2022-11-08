package user;

import java.sql.*;

public class userDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public userDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/jspProject?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String dbId = "root";
			String dbPassword = "Wkrwjs4602!";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String id, String pw) {
		String sql = "select userPw from user where userId = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1;
				}else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public int join(userDTO user) {
		String sql = "insert into user values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
