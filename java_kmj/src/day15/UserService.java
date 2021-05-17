package day15;
//회원과 관련된 처리를 하는 기능들을 모아놓은 인터페이스
public interface UserService {
	/* 기능 	: 회원의 아이디와 비밀번호가 주어졌을 때 로그인 가능 여부를 알려주는 메소드 
	 * 매개변수 : 회원의 아이디와 비밀번호 => String id , String pw
	 * 리턴타입 : 가능 불가능 => 참 거짓 => boolean
	 * 메소드명 : login
	 * */
	boolean login(String id, String pw);
	/* 기능 : 회원의 아이디, 비밀번호, 이메일, 전화번호가 주어지면 해당 정보로 회원가입하여 가입 여부를 알려준 메소드
	 * 메개변수 : 아이디, 비밀번호, 이메일, 전화번호
	 *  => 회원정보 =>User user 
	 *  (=> String id, String pw, Stirng email, int pnum)
	 * 리턴타입 : 가입 성공 여부=> boolean
	 * 메소드명 : singup
	 */
	boolean singup(User user);
	
	/* 기능 : 회원의 이메일, 전화번호를 수정하는 메소드
	 * 매개변수 : 회원의 이메일, 전화번호 
	 * 			  => User user (String email, int pnum)
	 * 리턴타입 : 없음
	 * 메소드명 : modifyUser
	 * */
	void modifyUser(User user);
}
class User{
	String id;
	String pw;
	String email;
	String num;
}
