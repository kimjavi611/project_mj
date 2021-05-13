package day13;

public class StickCar extends Car {
	
	public StickCar(String type, String company) {
		super(type, company);//부모클래스의 생성자를 불러오지 않도록 생성자를 만듦
		super.setGear('1');
	}
	
	@Override
	public void  setGear(char gear) {
		//수동은 1,2,3,4,5단과 후진r만 가능하기 때문에
		//기어값이 D가 올수 없다. 기어값이 D나 N등 다른 값이 오면 1단으로 설정
		switch(gear){
			case '1','2','3','4','5', 'r':
				super.setGear(gear);//private이라 바로 접근할수 없기때문에 부모클래스의 setGear를 이용
				break;
			default:
				super.setGear('1');
		}
	}
}
