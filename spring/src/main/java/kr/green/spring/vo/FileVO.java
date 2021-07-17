package kr.green.spring.vo;

import lombok.Data;

@Data
public class FileVO {
	private int num;
	private int board;
	private String name;
	private String ori_name;
	private String state;
	
	public FileVO() {};
	public FileVO(int board,String name, String ori_name) {
		this.num = board;
		this.name = name;
		this.ori_name = ori_name;
		
	}
	
	
	
}
