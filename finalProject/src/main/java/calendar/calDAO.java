package calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class calDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public calDAO() {
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
	
	public ArrayList<String> calDate(String date) throws SQLException {
		String sql = "select * from calendar where calStartDate = ?";
		ArrayList<String> str = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				str.add(rs.getString("calId"));
				str.add(rs.getString("calStartDate"));
				str.add(rs.getString("calEndDate"));
				str.add(rs.getString("calText"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			conn.close();
		}
		return str;
	}
	
}
