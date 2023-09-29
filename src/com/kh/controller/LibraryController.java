package com.kh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.kh.model.service.LibraryService;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;
import com.kh.model.vo.RentalLog;
import com.kh.model.vo.Member;
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
			if (ct == 0) {
				new LibraryMenu().displayFail("선택한 번호에 해당하는 카테고리가 없습니다");
			}		
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
			if (bNo == 0) {
				new LibraryMenu().displayFail("선택한 번호에 해당하는 책이 없습니다");
			}
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
	
	public int selectReturnBook(int mNo) {
		ArrayList<RentalLog> rentalList = new LibraryService().selectReturnBook(mNo);
		int rNo = 0;
		if (rentalList.isEmpty()) {
			new LibraryMenu().displayFail("대여 기록이 없습니다");
		} else {
			rNo = new LibraryMenu().displayRentalList(rentalList);
			if (rNo == 0) {
				new LibraryMenu().displayFail("선택한 번호에 해당하는 책이 없습니다");
			}
		}	
		return rNo;
	}
	
	public void returnBook(int rNo) {
		int result = new LibraryService().returnBook(rNo);
		if(result > 0) {
			new LibraryMenu().displaySuccess("반납 완료");
		} else {
			new LibraryMenu().displayFail("반납 실패");
		}
	}
	
	public void bestSeller() {
		ArrayList<Book> bestSeller = new LibraryService().bestSeller();
		if (bestSeller.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			new LibraryMenu().displayList(bestSeller);
		}	
	}
		
	public void newBook() {
		ArrayList<Book> newBook = new LibraryService().newBook();
		if (newBook.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			new LibraryMenu().displayList(newBook);
		}	
	}
	
	public void showMeBookList(int ct) {
		ArrayList<Book> showMeBookList = new LibraryService().selectBookList(ct);
		if (showMeBookList.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			new LibraryMenu().displayList(showMeBookList);
		}	
	}
	
	public void searchBookName(String str1) {
		ArrayList<Book> searchBookName = new LibraryService().searchBookName(str1);
		if (searchBookName.isEmpty()) {
			new LibraryMenu().displayFail("키워드에 해당하는 책이 없습니다");
		} else {
			new LibraryMenu().displayList(searchBookName);
		}	
	}
	
	public void searchBookAuthor(String str2) {
		ArrayList<Book> searchBookAuthor = new LibraryService().searchBookAuthor(str2);
		if (searchBookAuthor.isEmpty()) {
			new LibraryMenu().displayFail("키워드에 해당하는 책이 없습니다");
		} else {
			new LibraryMenu().displayList(searchBookAuthor);
		}	
	}
	
	
	//------------------------------------------------------------------------
	// 관리자

	
	
	
	public void addBook(int ct, String bName, String author, String publishdate, int quantity) {
		// Date형으로 파싱하기
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;	
        try {
			utilDate = dateFormat.parse(publishdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
       		
		Book b = new Book(ct, bName, author, sqlDate, quantity);
		int result = new LibraryService().addBook(b);
		if(result > 0) {
			new LibraryMenu().displaySuccess("도서 등록 완료");
		} else {
			new LibraryMenu().displayFail("도서 등록 실패");
		}	
	}
	
	
	public int deleteBookCheckRental(int bNo) {
		ArrayList<RentalLog> rentalList = new LibraryService().deleteBookCheckRental(bNo);
		int result = 1;
		if (!rentalList.isEmpty()) {
			new LibraryMenu().displayFail("대여중인 책은 삭제할 수 없습니다.");
			result = 0;
		}
		return result;
	}
	
	public void deleteBook(int bNo) {
		int result = new LibraryService().deleteBook(bNo);
		if(result > 0) {
			new LibraryMenu().displaySuccess("도서 삭제 완료");
		} else {
			new LibraryMenu().displayFail("도서 삭제 실패");
		}	
	}
	
	public void addMember(String mId, String mPwd, String mName, String mPhone) {
		Member m = new Member(mId, mPwd, mName, mPhone);
		int result = new LibraryService().addMember(m);
		if(result > 0) {
			new LibraryMenu().displaySuccess("회원 등록 완료");
		} else {
			new LibraryMenu().displayFail("회원 등록 실패");
		}	
	}
	
	
	public int deleteMemberCheckRental(String mId, String mPwd) {
		ArrayList<RentalLog> rentalList = new LibraryService().deleteMemberCheckRental(mId, mPwd);
		int result = 1;
		if (!rentalList.isEmpty()) {
			new LibraryMenu().displayFail("도서를 대여중인 회원은 삭제할 수 없습니다.");
			result = 0;
		}
		return result;
	}
	
	public void deleteMember(String mId, String mPwd) {
		int result = new LibraryService().deleteMember(mId, mPwd);
		if(result > 0) {
			new LibraryMenu().displaySuccess("회원 삭제 완료");
		} else {
			new LibraryMenu().displayFail("회원 삭제 실패");
		}	
	}
	
	public void rentalStatus() {
		ArrayList<RentalLog> rentalList = new LibraryService().rentalStatus();
		if (rentalList.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			new LibraryMenu().displayRentalAllList(rentalList);
		}	
	}
	
	public void longRentalMember() {
		ArrayList<RentalLog> rentalList = new LibraryService().longRentalMember();
		if (rentalList.isEmpty()) {
			new LibraryMenu().displayFail("데이터가 없습니다");
		} else {
			new LibraryMenu().displayLongRentalList(rentalList);
		}	
	}
	
	
	
}
