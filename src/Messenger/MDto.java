package Messenger;

public class MDto {

	static int num=0;
	String id;
	String pw;
	String name;
	public MDto(String id, String pw, String name) {
		super();
		this.num=num++;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		MDto.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MDTO [num="+num+"id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
	
	
	
}
