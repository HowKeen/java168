package member;

/*
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 로그인
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 체크
 * 6. 마이페이지
 * **********
 * <관리자기능>
 * 7. 회원목록
 * 8. 아이디검색
 * 9. 이름검색
 * 10. 전체 회원수
 */
import java.util.Scanner;

import race.Player;

public class MemberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = null;
		MemberService memberService = new MemberServiceImpl();
		while (true) {
			System.out.println("메뉴: 0.종료 1.회원가입 2.로그인 " + "5.아이디 존재 7.회원목록");
			switch (scanner.nextInt()) {
			case 0:
				System.out.println("종료");
				return;
			case 1:
				member = new Member();
				System.out.println("회원가입");
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				System.out.println("이름: ");
				member.setName(scanner.next());
				memberService.join(member);
				break;
			case 2:
				System.out.println("로그인");
				member = new Member();
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				String result = memberService.login(member);
				System.out.println(result);
				break;
			case 3:
				System.out.println("목록보기");
				Member[] list = memberService.list();
				for (int i = 0; i < 3; i++) {
					System.out.println(list[i].toString());
				}
				break;
			case 5:
				System.out.println("아이디 체크");
				member = new Member(); // Member 클래스에서 정보를 가져와 member에 담는다
				System.out.println("아이디 입력");
				member.setUserid(scanner.next());
				memberService.idfind(member);
				result = memberService.idfind(member); //위에 이미 스트링 리설트, 같은 의미를 반복해서 여기서는 스트링 안써야됨
				System.out.println(result);
				break;
			default:
				System.out.println("메뉴에 없는 기능입니다.");
				break;
			}
		}
	}
}