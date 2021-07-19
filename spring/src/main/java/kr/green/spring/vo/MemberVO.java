package kr.green.spring.vo;


import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String gender;
	private String email;
	private String name;
	private String authority;
	
	
}
