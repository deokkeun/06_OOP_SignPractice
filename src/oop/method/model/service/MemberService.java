package oop.method.model.service;

import java.util.Scanner;

import oop.method.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in);
	
	private Member memberInfo = null;
	private Member loginMember = null;
	
	
	public MemberService() {}
	
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println(" - 회원정보 관리 프로그램 - ");
			
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			
			System.out.print("Number : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			
			switch(menuNum) {
			case 1: System.out.println( signUp() );break;
			case 2: System.out.println( login() );break;
			case 3: break;
			case 4: break;
			case 0: System.out.println("프로그램 종료"); break;
			default : System.out.println("번호를 잘못 입력하셨습니다");
			}
			
		} while(menuNum != 0);
		
		System.out.println("프로그램을 종료 합니다.");
	}
	
	
	
	public String signUp() {
		
		System.out.println(" - 회원가입 - ");
		
		System.out.print("ID : ");
		String memberId = sc.next();
		
		System.out.print("Password : ");
		String memberPw = sc.next();
		
		System.out.print("Password(확인) : ");
		String memberPw2 = sc.next();
		
		System.out.print("Name : ");
		String memberName = sc.next();
		
		System.out.print("Age : ");
		int memberAge = sc.nextInt();
		
		
		if(memberPw.equals(memberPw2)) {
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			return "회원가입이 완료 되었습니다.";
		} else {
			return "비밀번호가 일치하지 않습니다.";
		}
	}
	
	
	public String login() {
		
		if(memberInfo == null) {
			return "회원가입을 먼저 진행해주세요!";
		}
		
		System.out.print("ID : ");
		String memberId = sc.next();

		System.out.print("Password : ");
		String memberPw = sc.next();
		
		
		
		if(memberId.equals(memberInfo.getMemberId()) &&
				memberPw.equals(memberInfo.getMemberPw())) {
			
			loginMember = memberInfo;
			return loginMember.getMemberName() + "님 로그인을 환영합니다.";
		} else {
			return "ID와 Password를 다시 확인해주세요!";
		}
		
		
	}
	
	
	

}
