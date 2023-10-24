package week5;

//반드시 테이블에 설계된 컬럼만 선언할 수 있는건 아니다.
//화면과는 상관이 없지만 업무 프로세스를 처리하기 위해서 추가로 필요한 변수도 선언가능 - 보이지 않는 부분

public class BookVO {
	private int b_no = 0;  
	private String b_title = null;
	private String b_author = null;
	private int b_price = 0;
	
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
}
