package data.dto;

public class TalentDto {
	private int talentidx;
	private String tname;
	private int tage;
	private String tphoto;
	private int theight;
	private String thome;
	private String tfan;
	
	
	public TalentDto() {
		super();
	}
	
	public TalentDto(String tname, int tage, String tphoto, int theight, String thome, String tfan) {
		super();
		this.tname = tname;
		this.tage = tage;
		this.tphoto = tphoto;
		this.theight = theight;
		this.thome = thome;
		this.tfan = tfan;
	}
	
	public int getTalentidx() {
		return talentidx;
	}
	public void setTalentidx(int talentidx) {
		this.talentidx = talentidx;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTphoto() {
		return tphoto;
	}
	public void setTphoto(String tphoto) {
		this.tphoto = tphoto;
	}
	public int getTheight() {
		return theight;
	}
	public void setTheight(int theight) {
		this.theight = theight;
	}
	public String getThome() {
		return thome;
	}
	public void setThome(String thome) {
		this.thome = thome;
	}
	public String getTfan() {
		return tfan;
	}
	public void setTfan(String tfan) {
		this.tfan = tfan;
	}
	
	
}
