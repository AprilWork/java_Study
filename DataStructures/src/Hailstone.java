
public class Hailstone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n = 1;
	    while (n != 1) {
	        if (n % 2 == 0) {
	            n = n / 2;
	        } else {
	            n = 3 * n + 1;
	        }
	    }
	}

}
