package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.LibraryService;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;
import com.kh.model.vo.RentalLog;
import com.kh.view.LibraryMenu;

public class LibraryController {
	
	// 요청한 기능에 대해서 처리하는 담당.
	// 전달된 데이터 가공 처리 후(객체로 만들어서 전달) 서비스객체에 전달

	public int memberLogin(String id, String pwd) {
		int result = new LibraryService().memberLogin(id, pwd);
		if(result > 0) {
			new LibraryMenu().displaySuccess("로그인 성공");
		} else {
			new LibraryMenu().displayFail("로그인 실패");
		}
		return result;
	}
	
	public int adminLogin(String id, String pwd) {
		int result = new LibraryService().adminLogin(id, pwd);
		if(result > 0) {
			new LibraryMenu().displaySuccess("로그인 성공");
		} else {
			new LibraryMenu().displayFail("로그인 실패");
		}
		return result;
	}
		
	
	public int selectCategory() {
		int ct = 0;
		ArrayList<Category> ctList = new LibraryService().selectCategory();
		if (ctList.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			ct = new LibraryMenu().displayctList(ctList);
		}	
		return ct;
	}
	
	public int selectBookList(int ct) {
		ArrayList<Book> bookList = new LibraryService().selectBookList(ct);
		int bNo = 0;
		if (bookList.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			bNo = new LibraryMenu().displayBookList(bookList);
		}
		return bNo;
	}
	
	
	public void rentalBook(int mNo, int bNo) {
		int result = new LibraryService().rentalBook(mNo, bNo);
		
		if(result > 0) {
			new LibraryMenu().displaySuccess("대여 완료");
		} else {
			new LibraryMenu().displayFail("대여 실패");
		}
	}
	
	
	
}
