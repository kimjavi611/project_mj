package accountbook;
/* 클래스명 : AccountBook
 * -수입 내역, 지출 내역을 관리하기 위한 가계부 클래스
 * */
public class AccountBook2 {
	//수입,지출 내역=> 수입 항목,가격 / 지출 항목, 가격
	private String incomList;
	private String outcomeList;
	private int income;
	private int outcome;
	
	public String getIncomList() {
		return incomList;
	}
	public void setIncomList(String incomList) {
		this.incomList = incomList;
	}
	public String getOutcomeList() {
		return outcomeList;
	}
	public void setOutcomeList(String outcomeList) {
		this.outcomeList = outcomeList;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getOutcome() {
		return outcome;
	}
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}
	
	public AccountBook2(String incomList, String outcomeList, int income, int outcome) {
		super();
		this.incomList = incomList;
		this.outcomeList = outcomeList;
		this.income = income;
		this.outcome = outcome;
	}
	
	
	
}
