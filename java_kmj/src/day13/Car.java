package day13;

public class Car {
	//전원, 기어, 차종, 제조사 => 멤버변수로, 단, 접근제한자는 Private
	//전원 on/off
	private boolean power;
	//수동 : 1, 2, 3, 4, 5, R , 자동 : P, D, N, R
	private char gear;
	private String type;
	private String company;
	
	public void turnOn() {power = true;}
	public void turnOff() {power = false;}
	
	public Car(String type, String company) {//전원이랑 기어는 살때 기본값이 정해져있기 때문에 따로 생성자를 생성하지 않음
		this.type = type;
		this.company =company;
		
	}
	
	public void print() {
		System.out.println("제조 : " + company);
		System.out.println("차종 : " + type);
		System.out.println("전원 : " + power);
		System.out.println("기어 : " + gear);
	}
	
	
	
	
 	public boolean isPower() {
		return power;
	}
	
	public char getGear() {
		return gear;
	}
	public void setGear(char gear) {
		this.gear = gear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	
	
}
