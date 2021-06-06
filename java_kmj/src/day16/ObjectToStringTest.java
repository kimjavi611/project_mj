package day16;

public class ObjectToStringTest {

	public static void main(String[] args) {
		Student s = new Student("홍길동",1,1,1);
		System.out.println(s);
		System.out.println(s.toString());
	}

}
class Student{
	private String name;
	private int grade;
	private int classNum;
	private int num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassnum() {
		return classNum;
	}
	public void setClassnum(int classnum) {
		this.classNum = classnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Student(String name, int grade, int classnum, int num) {
		super();
		this.name = name;
		this.grade = grade;
		this.classNum = classnum;
		this.num = num;
	}
	@Override
	public String toString() {//클래스의 값을 간단하게 출력할 수 있음 
		return "Student [name=" + name + ", grade=" + grade + ", classnum=" + classNum + ", num=" + num + "]";
	}
	public void print() {
		System.out.println("이름 : " + name + "\n학년 : " + grade 
				+ "\n반 : " + classNum + "\n번호 : " + num);
	}
	
}