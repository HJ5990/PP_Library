package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.LibraryController;
import com.kh.model.vo.Book;
import com.kh.model.vo.Category;
import com.kh.model.vo.RentalLog;

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
			System.out.println("3. 베스트셀러");
			System.out.println("4. 신간조회");
			System.out.println("5. 도서 목록 열람");
			System.out.println("6. 도서 찾기");
			System.out.println("9. 뒤로");
			System.out.println("===================");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1: 
					rentalBook(mNo);
					break;
				case 2:
					returnBook(mNo);
					break;
				case 3:
					lc.bestSeller();
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
	
	/** 카테고리 보여주고, 카테고리에 맞는 책 보여준 뒤, 책번호 입력받아서, 대여처리 */
	public void rentalBook(int mNo) {
		// 카테고리 선택하기
		int ct = lc.selectCategory();	
		// 선택한 카테고리에 데이터가 없으면 메서드 종료
		if(ct < 1) {
			return;
		}		
		// 책 선택하기
		int bNo = lc.selectBookList(ct);
		// 해당 책배열에 데이터가 없으면 메서드 종료
		if (bNo < 1) {
			return;
		}
		// 회원번호, 선택한 책 이용해서 대여처리 해주고, 재고 -1 처리 하기
		lc.rentalBook(mNo, bNo);
	}
	
	
	// 2. 반납
	/** 가지고 있는 책 보여주고, 선택한 책번호 반납처리*/
	public void returnBook(int mNo) {
		// 반납할 책 보여주고 선택
		int rNo = lc.selectReturnBook(mNo);
		// 반납할 책 이용해서 반납처리 해주고, 재고 +1 처리하기
		lc.returnBook(rNo);
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	/**관리자 메뉴*/
	public void adminMenu() {
		while(true) {
			System.out.println("\n=======[기본메뉴]=======");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 삭제");
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
	
	public int displayBookList(ArrayList<Book> bookList) {
		System.out.println("\n====================================");
		System.out.println("책번호\t카테고리\t도서명\t\t저자\t\t출간일\t수량");
		for (Book b : bookList) {
			System.out.println(b);
		}
		System.out.println("====================================");
		System.out.print("책번호 입력 : ");
		int select = sc.nextInt();
		sc.nextLine();
		// 선택한 번호의 책이 있는지 확인 작업
		int bNo = 0;
		for (Book b : bookList) {
			if (b.getbNo() == select) {
				bNo = select;
				break;
			}
		}
		return bNo;
	}
	
	public int displayRentalList(ArrayList<RentalLog> rentalList) {
		System.out.println("\n====================================");
		System.out.println("대여번호\t대여날짜\t도서명");
		for (RentalLog rl : rentalList) {
			System.out.println(rl.getrNo() + "\t" + rl.getRenDate() + "\t" + rl.getbName());
		}
		System.out.println("====================================");
		System.out.print("대여번호 입력 : ");
		int select = sc.nextInt();
		sc.nextLine();
		// 선택한 번호의 책이 있는지 확인 작업
		int rNo = 0;
		for (RentalLog rl : rentalList) {
			if (rl.getrNo() == select) {
				rNo = select;
				break;
			}
		}
		return rNo;
	}

	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	

}
