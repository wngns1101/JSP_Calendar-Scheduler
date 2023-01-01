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
			String dbPassword = "rootpw";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> dayScheduler(String date, int mm) throws SQLException {
		String month = calInfo.currentMonth(mm);
		String a = "\""+date+"\""; 
		ArrayList<String> str = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from "+month+" where calStartDate <= "+ a + "and calEndDate >="+ a + ";");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				str.add(rs.getString("calId"));
				str.add(rs.getString("calName"));
				str.add(rs.getString("calTitle"));
				str.add(rs.getString("calStartDate"));
				str.add(rs.getString("calEndDate"));
				str.add(rs.getString("calText"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public ArrayList<String> calMyDate(String id) throws SQLException {
		ArrayList<String> str = new ArrayList<>();
		String a = "\""+id+"\"";
		try {
			pstmt = conn.prepareStatement("select * from "+calInfo.currentMonth(1)+" where calId = "+a+" union select * from "+calInfo.currentMonth(2)+" where calId = "+a+" union select * from "+calInfo.currentMonth(3)+" where calId = "+a+""
					+ "union select * from "+calInfo.currentMonth(4)+" where calId = "+a+" union select * from "+calInfo.currentMonth(5)+" where calId = "+a+" union select * from "+calInfo.currentMonth(6)+" where calId = "+a+" "
					+ "union select * from "+calInfo.currentMonth(7)+" where calId = "+a+" union select * from "+calInfo.currentMonth(8)+" where calId = "+a+" union select * from "+calInfo.currentMonth(9)+" where calId = "+a+" "
					+ "union select * from "+calInfo.currentMonth(10)+" where calId = "+a+" union select * from "+calInfo.currentMonth(11)+" where calId = "+a+" union select * from "+calInfo.currentMonth(12)+" where calId = "+a+";");
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				str.add(rs.getString("calId"));
				str.add(rs.getString("calName"));
				str.add(rs.getString("calTitle"));
				str.add(rs.getString("calStartDate"));
				str.add(rs.getString("calEndDate"));
				str.add(rs.getString("calText"));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public ArrayList<String> calNameDate(int mm, String date) throws SQLException {
		String month = calInfo.currentMonth(mm);
		String a = "\""+date+"\"";
		ArrayList<String> str = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select calName from "+month+" where calStartDate <= "+ a + "and calEndDate >="+ a + ";");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				str.add(rs.getString("calName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public ArrayList<String> calTitleDate(int mm, String date) throws SQLException {
		String month = calInfo.currentMonth(mm);
		String a = "\""+date+"\"";
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
	
	public int calInsert(calDTO cal, int mm) throws SQLException {
		String month = calInfo.currentMonth(mm);
		String sql = "insert into " + month + " values(?, ?, ?, ?, ?, ?)";
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
	
	public int calDelete(String id, String title, int mm) throws SQLException {
		String month = calInfo.currentMonth(mm);
		String sql = "delete from " + month + " where calId = ? and calTitle = ? ";
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
	
	public int calUpdate(calDTO cal, int mm) throws SQLException {
		String month = calInfo.currentMonth(mm);
		String sql = "update "+ month + " set calTitle = ?, calStartDate = ?, calEndDate = ?, calText = ? where calId = ? and calTitle = ?";
		pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, cal.getCalTitle());
			pstmt.setString(2, cal.getCalStartDate());
			pstmt.setString(3, cal.getCalEndDate());
			pstmt.setString(4, cal.getCalText());
			pstmt.setString(5, cal.getCalId());
			pstmt.setString(6, cal.getCalOldTitle());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return -1;
	}
	
}
