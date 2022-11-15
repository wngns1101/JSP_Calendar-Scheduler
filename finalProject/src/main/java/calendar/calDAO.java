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
	
	public ArrayList<String> calDate(int mm, String date) throws SQLException {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String month = months[mm-1];
		String a = "\""+date+"\"";
		//		여기부터 다시
		ArrayList<String> str = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select calTitle from "+month+" where calStartDate <= "+ a + "and calEndDate >="+ a + ";");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				str.add(rs.getString("calTitle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public int calInsert(calDTO cal) throws SQLException {
		String sql = "insert into calendar values(?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, cal.getCalId());
			pstmt.setString(2, cal.getCalName());
			pstmt.setString(3, cal.getCalTitle());
			pstmt.setString(4, cal.getCalStartDate());
			pstmt.setString(5, cal.getCalEndDate());
			pstmt.setString(6, cal.getCalText());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return -1;
	}
	
	public int calDelete(String id, String title) throws SQLException {
		String sql = "delete from calendar where calId = ? and calTitle = ? ";
		pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return -1;
	}
	
	public int calUpdate(calDTO cal) throws SQLException {
		String sql = "update calendar set calName = ?, calStartDate = ?, calEndDate = ?, calText = ? where calId = ? and calTitle = ?";
		pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, cal.getCalName());
			pstmt.setString(2, cal.getCalStartDate());
			pstmt.setString(3, cal.getCalEndDate());
			pstmt.setString(4, cal.getCalText());
			pstmt.setString(5, cal.getCalId());
			pstmt.setString(6, cal.getCalTitle());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return -1;
	}
	
}
