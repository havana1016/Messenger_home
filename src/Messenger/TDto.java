package Messenger;

public class TDto {
	static Integer tnum=0; 
	String sendid;
	String takeid;
	String title;
	String text;
	Boolean tt;
	public TDto(String sendid, String takeid, String title, String text) {
		super();
		this.tnum=tnum++;
		this.sendid = sendid;
		this.takeid = takeid;
		this.title = title;
		this.text = text;
		this.tt=null;
	}
	public static Integer getTnum() {
		return tnum;
	}
	public static void setTnum(Integer tnum) {
		TDto.tnum = tnum;
	}
	public String getSendid() {
		return sendid;
	}
	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	public String getTakeid() {
		return takeid;
	}
	public void setTakeid(String takeid) {
		this.takeid = takeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Boolean getTt() {
		return tt;
	}
	public void setTt(Boolean tt) {
		this.tt = tt;
	}
	@Override
	public String toString() {
		return "TDto [sendid=" + sendid + ", takeid=" + takeid + ", title=" + title + ", text=" + text + "]";
	}
	
	
	
	
	
}
