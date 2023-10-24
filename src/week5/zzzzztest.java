package week5;

import java.util.regex.Pattern;

public class zzzzztest {
	
	 public boolean isNumeric(String str) {
	    	System.out.println(str);
	        //return Pattern.matches("^[a-zA-Z0-9]+[$@$!%*#?&]+{8,}$", str);
	    	return Pattern.matches("^^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", str);
	    }

	public static void main(String[] args) {
		zzzzztest z = new zzzzztest();
		System.out.println(z.isNumeric("zcxv1111!!"));
	}

}
