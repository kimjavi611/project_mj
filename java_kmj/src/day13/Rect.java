package day13;

public class Rect extends Figure {
	
	private int w;
	private int h;
	
	public Rect(int left, int up, int right, int down) {
		super(left, up, right, down);//자동생성에서 부모클래스선택 
		w = getRight() - getLeft();//부모클래스에서 숫자 잘못입력했을때 정정하는걸 만들어놨기때문에 그걸 가져와서 사용
		h = getDown() - getUp();
	}
	@Override
	public void print() {
		System.out.println("<<사각형입니다>>");
		super.print();
		System.out.println("가로 : "+  w);
		System.out.println("세로 : " + h);
	}
	
	
	
	
}
