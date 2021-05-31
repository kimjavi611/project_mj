package etc;
public class StudentTest {
	public static void main(String[] args) {
		/*학생 정보를 관리하는 Student 클래스를 생성하세요. 
		 * 1학년 1반 1번 홍길동 학생의 객체를 생성한 후, 학생 정보를 출력하는 코드를 
		 * main 메소드에 작성하여 테스트하세요.
			- 학생 클래스
 			- 정보 : 학년, 반, 번호, 이름
 			- 기능 : 학생 정보 출력 기능*/ 
		Student st = new Student("홍길동", 1, 1, 1);
		st.print();
	}
}
class Student{
	private int grade, room, number;
	private String name;
	public void print() {
		System.out.println(name + " : " + grade + "학년 " + room + "반 " + number + "번 " );
	}
	
	public Student(String name, int grade, int room, int number) {
		this.grade = grade;
		this.room = room;
		this.number = number;
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}