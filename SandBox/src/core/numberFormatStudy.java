package core;
import java.text.NumberFormat;

public class numberFormatStudy {
	
	private static double a;
	private static NumberFormat cf = NumberFormat.getCurrencyInstance();
	private static NumberFormat nf = NumberFormat.getNumberInstance();
	private static NumberFormat pf = NumberFormat.getPercentInstance();
	
	public static void printMyAllovance(double a) {
		System.out.println(cf.format(a));
	}
	
	public static void printMyAnnual(double a) {
		//nf.setMinimumFractionDigits(3);
		//nf.setMaximumFractionDigits(3);
		System.out.println(cf.format(a));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		a = 43.769;
		printMyAllovance(a);
		
		a = 36785556.5487;
		printMyAnnual(a);
	
		a = .74;
		System.out.println(pf.format(a));
		
	}

}
