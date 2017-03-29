package Business;

public class Clients {
	private String CNP_CUI;
	private String name;
	private String address;
	
	public Clients(String cnp, String name, String address)
	{
		this.CNP_CUI=cnp;
		this.name=name;
		this.address=address;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getCNP()
	{
		return this.CNP_CUI;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	
	public void getCNP(String cnp)
	{
		this.CNP_CUI=cnp;
	}
	
	public void getAddress(String a)
	{
		this.address=a;
	}
	
}
