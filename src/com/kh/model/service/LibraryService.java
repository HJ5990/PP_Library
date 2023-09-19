package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.LibraryDao;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;

public class LibraryService {
	// JDBC Driver 등록
	// Connection 객체 생성
	// Connection 객체 후 처리(커밋, 롤백, 클로즈)
	
	
	public int memberLogin(String id, String pwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().memberLogin(conn, id, pwd);
		JDBCTemplate.close(conn);
		return result;	
	}
	
	public int adminLogin(String id, String pwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().adminLogin(conn, id, pwd);
		JDBCTemplate.close(conn);
		return result;	
	}
	
	public ArrayList<Category> selectCategory() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Category> ctList = new LibraryDao().selectCategory(conn);
		JDBCTemplate.close(conn);
		return ctList;
	}
	
	public ArrayList<Book> showBookList(int ct) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> bookList = new LibraryDao().showBookList(conn, ct);
		JDBCTemplate.close(conn);
		return bookList;
	}
	
	
	
	
}
