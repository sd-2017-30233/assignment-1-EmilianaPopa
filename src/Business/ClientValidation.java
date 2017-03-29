package Business;

public class ClientValidation {
	public static boolean validate(String CNP)
    {
        if((Float.parseFloat(CNP)>=1000000000000L && Float.parseFloat(CNP)<=9999999999999L) || (Float.parseFloat(CNP)>=10000000L && Float.parseFloat(CNP)<=99999999L))
            return true;
        else return false;
    }
}
