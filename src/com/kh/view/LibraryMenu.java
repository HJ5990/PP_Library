package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.LibraryController;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;
import com.kh.model.vo.Member;

public class LibraryMenu {
	
	private Scanner sc = new Scanner(System.in);
	private LibraryController lc = new LibraryController();
	
	
	/**초기 메뉴*/
	public void mainMenu() {
		while(true) {
			System.out.println("\n=======[메뉴]=======");
			System.out.println("1. 회원 메뉴");
			System.out.println("2. 관리자 메뉴");
			System.out.println("9. 프로그램 종료");
			System.out.println("===================");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1: // 로그인 > 메뉴
					int mNO = memberLogin();
					if (mNO > 0) {
						memberMenu(mNO);
					}
					break;
				case 2: // 로그인 > 메뉴
					if (adminLogin() > 0) {
						adminMenu();
					}
					break;
				case 9:
					System.out.println("\n프로그램을 종료합니다.");
					return;
				default:
					System.out.println("\n잘못 입력하셨습니다.");
			}	
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------
	// 로그인

	/** 회원 로그인*/
	public int memberLogin() {
		System.out.println("\n=======[로그인]=======");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		int result = lc.memberLogin(id, pwd);
		return result;
	}
		
	/** 관리자 로그인*/
	public int adminLogin() {
		System.out.println("\n=======[관리자 로그인]=======");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		int result = lc.adminLogin(id, pwd);
		return result;
	}
	
	

	
	
	//--------------------------------------------------------------------------------------------------
	
	
	/**기본 메뉴*/
	public void memberMenu(int mNo) {
		while(true) {
			System.out.println("\n=======[회원메뉴]=======");
			System.out.println("1. 대여");
			System.out.println("2. 반납");
			System.out.println("3. 도서 목록 조회");
			System.out.println("4. 베스트샐러");
			System.out.println("5. 신간");
			System.out.println("6. 도서 찾기");
			System.out.println("9. 뒤로");
			System.out.println("===================");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1: 
					rentalBook();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 9:
					return;
				default:
					System.out.println("\n잘못 입력하셨습니다.");
			}	
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------
	// 1.대여
	
	/** 카테고리 보여주고, 카테고리에 맞는 책 보여준 뒤, 책번호 반환하는 메서드 */
	public void rentalBook() {
		int ct = lc.selectCategory();
		// 선택한 카테고리에 데이터가 없으면 메서드 종료
		if(ct < 1) {
			return;
		}
		
		ArrayList<Book> bookList = lc.showBookList(ct);
		// 해당 책배열에 데이터가 없으면 메서드 종료
		if (bookList.isEmpty()) {
			return;
		}
		selectBook();
		

	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	/**관리자 메뉴*/
	public void adminMenu() {
		while(true) {
			System.out.println("\n=======[기본메뉴]=======");
			System.out.println("1. 책 등록");
			System.out.println("2. 책 삭제");
			System.out.println("3. 회원 등록");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 대여 현황 조회");
			System.out.println("7. 장기 미반납자 조회");
			System.out.println("9. 뒤로");
			System.out.println("===================");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 9:
					return;
				default:
					System.out.println("\n잘못 입력하셨습니다.");
			}	
		}
	}
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	

	
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	// 응답 화면
	
	
	public void displaySuccess(String message) {
		System.out.println("\n성공 : " + message);
	}
	
	public void displayFail(String message) {
		System.out.println("\n실패 : " + message);
	}
	
	public int displayctList(ArrayList<Category> ctList) {
		System.out.println("\n=======[카테고리]=======");
		for (Category c : ctList) {
			System.out.println(c);
		}
		System.out.println("===================");
		System.out.print("번호 입력 : ");
		int ct = sc.nextInt();
		sc.nextLine();
		return ct;
	}
	

	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	

}
