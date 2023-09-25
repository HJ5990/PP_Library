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
import com.kh.model.vo.RentalLog;

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
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book(rset.getInt("B_NO"),
									rset.getString("C_NAME"),
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
	
	public int rentalBook(Connection conn, int mNo, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("rentalBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNo);
			pstmt.setInt(2, bNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<RentalLog> selectReturnBook(Connection conn, int mNo) {
		ArrayList<RentalLog> rentalList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReturnBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				RentalLog rl = new RentalLog(rset.getInt("R_NO"),
									rset.getDate("REN_DATE"),
									rset.getString("B_NAME")
									);
				rentalList.add(rl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return rentalList;	
	}
	
	
	public int returnBook(Connection conn, int rNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("returnBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	public ArrayList<Book> bestSeller(Connection conn) {
		ArrayList<Book> bestSeller = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("bestSeller");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book(rset.getInt("B_NO"),
									rset.getString("C_NAME"),
									rset.getString("B_NAME"),
									rset.getString("AUTHOR"),
									rset.getDate("PUBLISHDATE")
									);
				bestSeller.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bestSeller;
	}
	
	
	public ArrayList<Book> newBook(Connection conn) {
		ArrayList<Book> newBook = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("newBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book(rset.getInt("B_NO"),
									rset.getString("C_NAME"),
									rset.getString("B_NAME"),
									rset.getString("AUTHOR"),
									rset.getDate("PUBLISHDATE")
									);
				newBook.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return newBook;
	}
	
	
	
	
}
