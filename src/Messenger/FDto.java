package Messenger;

public class FDto {

	String plzfr;
	String yesfr;
	Boolean fr;
	public FDto(String plzfr, String yesfr, Boolean fr) {
		super();
		this.plzfr = plzfr;
		this.yesfr = yesfr;
		this.fr = fr;
	}
	public String getPlzfr() {
		return plzfr;
	}
	public void setPlzfr(String plzfr) {
		this.plzfr = plzfr;
	}
	public String getYesfr() {
		return yesfr;
	}
	public void setYesfr(String yesfr) {
		this.yesfr = yesfr;
	}
	public Boolean getFr() {
		return fr;
	}
	public void setFr(Boolean fr) {
		this.fr = fr;
	}
	@Override
	public String toString() {
		return "FDto [plzfr=" + plzfr + ", yesfr=" + yesfr + ", fr=" + fr + "]";
	}
	
	
	
	
	
}
