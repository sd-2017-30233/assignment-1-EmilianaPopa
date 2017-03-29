package Business;

public class Account {
	private String idAcc;
	private float sum;
	private String idClient;
	
	public Account(String id, float s, String i)
	{
		this.idAcc=id;
		this.sum=s;
		this.idClient=i;
	}
	
	public String getIdAcc()
	{
		return this.idAcc;
	}
	
	public float getSum()
	{
		return this.sum;
	}
	
	public String getIdClient()
	{
		return this.idClient;
	}
	
	public void setIdAcc(String id)
	{
		this.idAcc=id;
	}
	
	public void setSum(float s)
	{
		this.sum=s;
	}
	
	public void setIdClient(String id)
	{
		this.idClient=id;
	}
}
