package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.LibraryDao;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;
import com.kh.model.vo.Member;
import com.kh.model.vo.RentalLog;

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
	
	public ArrayList<Book> selectBookList(int ct) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> bookList = new LibraryDao().selectBookList(conn, ct);
		JDBCTemplate.close(conn);
		return bookList;
	}
	
	public int rentalBook(int mNo, int bNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().rentalBook(conn, mNo, bNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<RentalLog> selectReturnBook(int mNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RentalLog> rentalList = new LibraryDao().selectReturnBook(conn, mNo);
		JDBCTemplate.close(conn);
		return rentalList;
	}
	
	public int returnBook(int rNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().returnBook(conn, rNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Book> bestSeller() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> bestSeller = new LibraryDao().bestSeller(conn);
		JDBCTemplate.close(conn);
		return bestSeller;
	}
	
	public ArrayList<Book> newBook() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> newBook = new LibraryDao().newBook(conn);
		JDBCTemplate.close(conn);
		return newBook;
	}
	
	public ArrayList<Book> searchBookName(String str1) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> searchBookName = new LibraryDao().searchBookName(conn, str1);
		JDBCTemplate.close(conn);
		return searchBookName;
	}
	
	public ArrayList<Book> searchBookAuthor(String str2) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> searchBookAuthor = new LibraryDao().searchBookAuthor(conn, str2);
		JDBCTemplate.close(conn);
		return searchBookAuthor;
	}
	
	
	//-----------------------------------------------------------------
	// 관리자메뉴
	
	public int addBook(Book b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().addBook(conn,b);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<RentalLog> deleteBookCheckRental(int bNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RentalLog> rentalList = new LibraryDao().deleteBookCheckRental(conn, bNo);
		JDBCTemplate.close(conn);
		return rentalList;
	}
	
	public int deleteBook(int bNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().deleteBook(conn, bNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int addMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().addMember(conn, m);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<RentalLog> deleteMemberCheckRental(String mId, String mPwd) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RentalLog> rentalList = new LibraryDao().deleteMemberCheckRental(conn, mId, mPwd);
		JDBCTemplate.close(conn);
		return rentalList;
	}
	
	public int deleteMember(String mId, String mPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibraryDao().deleteMember(conn, mId, mPwd);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<RentalLog> rentalStatus() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RentalLog> rentalList = new LibraryDao().rentalStatus(conn);
		JDBCTemplate.close(conn);
		return rentalList;
	}
	
	public ArrayList<RentalLog>  longRentalMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RentalLog> rentalList = new LibraryDao().longRentalMember(conn);
		JDBCTemplate.close(conn);
		return rentalList;
	}
	
	
	
	
}
