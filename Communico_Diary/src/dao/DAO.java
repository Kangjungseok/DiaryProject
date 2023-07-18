package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import dto.DTO;

public class DAO {
	private String url = "jdbc:mariadb://localhost:3306/diaryEx";
	private String user = "jskang";
	private String pass = "rkdwjdtjr1";

	private static DAO instance;

	private DAO() {
	}

	public static DAO getinstance() {
		if (instance == null) {
			instance = new DAO();
		}

		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public int insertData(DTO dto) throws SQLException {
		int result = 0;

		Connection conn = getConnection();
		String sql = "INSERT INTO diary VALUES (COALESCE((SELECT MAX(a.num) + 1 FROM diary a), 1), ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, dto.getTask());
		pstmt.setString(2, dto.getManager());
		pstmt.setDate(3, dto.getDday());

		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();

		return result;
	}

	
	/*
	public DTO getLastRow() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO dto = new DTO();
		
		String sql = "Select * from diary where max(num)";
		int result = 0 ; //변경 안 됐을 때의 값
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			dto.setNum(rs.getInt("num"));
			dto.setTask(rs.getString("task"));
			dto.setManager(rs.getString("manager"));
			dto.setDday(rs.getDate("dday"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	*/
	public DTO getLastRow() throws SQLException {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    DTO dto = new DTO();

	    String sql = "SELECT * FROM diary ORDER BY num DESC LIMIT 1";
	    try {
	        conn = getConnection();
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            dto.setNum(rs.getInt("num"));
	            dto.setTask(rs.getString("task"));
	            dto.setManager(rs.getString("manager"));
	            dto.setDday(rs.getDate("dday"));
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	        if (rs != null) rs.close();
	        if (pstmt != null) pstmt.close();
	        if (conn != null) conn.close();
	    }

	    return dto;
	}


	public int deleteData(DTO dto) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from diary where num = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pstmt.close();
		conn.close();

		return result;
	}

	public Vector<DTO> getAllData() {
		Connection conn = getConnection();
		String sql = "select * from diary";
		ResultSet rs = null;
		Statement stmt = null;
		DTO dto = null;
		Vector<DTO> tasks = new Vector<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				dto = new DTO();
				dto.setNum(rs.getInt("num"));
				dto.setTask(rs.getString("task"));
				dto.setManager(rs.getString("manager"));
				dto.setDday(rs.getDate("dday"));

				tasks.add(dto);
			}
			rs.close();
			stmt.close();
			closeConnection(conn);

			return tasks;
		} catch (SQLException e) {
			e.printStackTrace();
			return (Vector<DTO>) Collections.EMPTY_LIST;
		}
	}
	
	public int updateData(DTO dto) throws SQLException {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int result = 0;
	    
	    try {
	        conn = getConnection();
	        String sql = "UPDATE diary SET task = ?, manager = ?, dday = ? WHERE num = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, dto.getTask());
	        pstmt.setString(2, dto.getManager());
	        pstmt.setDate(3, dto.getDday());
	        pstmt.setInt(4, dto.getNum());
	        
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) pstmt.close();
	        if (conn != null) conn.close();
	    }
	    
	    return result;
	}




}
