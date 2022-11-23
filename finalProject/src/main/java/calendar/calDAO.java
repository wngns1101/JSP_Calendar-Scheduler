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
	
	
	public String[][] calMyDate(String id) throws SQLException {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[][] totals = {};
		try {
			pstmt = conn.prepareStatement("select * from ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? where calId = ?");
			pstmt.setString(1, months[0]);
			pstmt.setString(2, months[1]);
			pstmt.setString(3, months[2]);
			pstmt.setString(4, months[3]);
			pstmt.setString(5, months[4]);
			pstmt.setString(6, months[5]);
			pstmt.setString(7, months[6]);
			pstmt.setString(8, months[7]);
			pstmt.setString(9, months[8]);
			pstmt.setString(10, months[9]);
			pstmt.setString(11, months[10]);
			pstmt.setString(12, months[11]);
			pstmt.setString(13, id);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				totals[i][0] = rs.getString("calId");
				totals[i][1] = rs.getString("calName");
				totals[i][2] = rs.getString("calTitle");
				totals[i][3] = rs.getString("calStartDate");
				totals[i][4] = rs.getString("calEndDate");
				totals[i][5] = rs.getString("calText");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
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
