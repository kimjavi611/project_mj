package day11;

public class Board {
	/* 게시글에 필요한 멤버변수를 선언하세요 
	 * 제목, 작성자, 작성시간, 작성내용, 조회수, 좋아요 수, 게시글 번호, 게시글 타입   */
	private int num;
	private String title = " ";// 스트링은 참조변수 => new객체를 이용해서 생성해야함 => 스트링은 문자열이기때문에 빈문자열을 사용해서 생성할 수 있음
	private String contents = new String();
	private String writer = " ";
	private String registerDate = " ";
	private int views;
	private int like;
	private String type = " "; //private 멤버변수는 getter, setter만들기
	
	//생성자를 만들어 보세요//직접값을 입력해줘야하기 때문에 기본생성자가 필요없다
	public Board(int num, String title, String contents, String writer, String registerDate, String type) {
		super();
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = registerDate;
		this.type = type;
	}
	
	/* 기능 : 게시글 정보 출력하는 메소드
	 * 매개변수 : 없음 
	 * 리턴타입 : 없음
	 * 메소드명 : print
	 * */
	public void print() {
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + views);
		System.out.println("좋아요 : "+ like);
		System.out.println("작성일 : " + registerDate);
		System.out.println("내용 : " + contents);
		
	}
		
	
	
	
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWrighter() {
		return writer;
	}
	public void setWrighter(String wrighter) {
		this.writer = wrighter;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
