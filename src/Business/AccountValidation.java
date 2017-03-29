package Business;

public class AccountValidation {
	public static boolean validate(float sum)
	{
		if(sum<0)
			return false;
		return true;
	}
}
