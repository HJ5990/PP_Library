package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;

public class LibraryDao {
	// DA에 직접 접근, sql 실행후 결과 반환
	
	private Properties prop = new Properties();
	
	// 기본생성자로 prop sql 저장되어있는 파일 불러오기
	public LibraryDao() { 
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			// Stream close는 prop.loadFromXML여기에서 자동으로 해주기때문에 따로 해줄필요 x
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	
	
	//-------------------------------------------------------
	
	
	public int memberLogin(Connection conn, String id, String pwd) {
		// 결과 : 회원번호(숫자)
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0; 
		String sql = prop.getProperty("memberLogin");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();			
			if(rset.next()) {
				result = rset.getInt(1);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public int adminLogin(Connection conn, String id, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0; 
		String sql = prop.getProperty("adminLogin");		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();			
			if(rset.next()) {
				result = rset.getInt(1);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public ArrayList<Category> selectCategory(Connection conn){
		// 여러행 => ResultSet객체 > ArrayList객체
		ArrayList<Category> ctList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCategory");	
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Category c = new Category(rset.getInt("c_no"), rset.getString("c_name"));
				ctList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}	
		return ctList;
	}
	
	// 카테고리에 맞는 책 + 수량 1개이상인 책 불러옴
	public ArrayList<Book> selectBookList(Connection conn, int ct) {
		ArrayList<Book> bookList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ct);
			
			while(rset.next()) {
				Book b = new Book(rset.getInt("B_NO"),
									rset.getInt("C_NO"),
									rset.getString("B_NAME"),
									rset.getString("AUTHOR"),
									rset.getDate("PUBLISHDATE"),
									rset.getInt("QUANTITY")
									);
				bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bookList;		
	}
	
	
}
