package day0325;

public class Shop 
{
	private String Sang;
	private int su;
	private int dan;
	//생성자 4개
	public Shop() 
	{
		this("이름없음",1,1000);
	}
	public Shop(String sang) 
	{
		this(sang,1,1000);
	}
	public Shop(int su, int dan) 
	{
		this("이름없음",su,dan);
	}
	public Shop(String sang,int su,int dan)
	{
		this.Sang=sang;
		this.su=su;
		this.dan=dan;
	}


	public void setSang(String Sang) 
	{
		this.Sang=Sang;
	}
	public void setDan(int dan) 
	{
		this.dan=dan;
	}
	public void setSu(int su) 
	{
		this.su=su;
	}	
	public void setSangpum(String sang,int su,int dan) 
	{
		setSang(sang);
		setSu(su);
		setDan(dan);
	}

	public String getSang()
	{
		return Sang;
	}
	public int getSu() 
	{
		return su;			
	}
	public int getDan() 
	{
		return dan;
	}
}



