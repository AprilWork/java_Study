package core;

public final class Counter {
	
	//private static int a;
	
	private Counter() {
		//Now, because the constructor is private, the class can’t be instantiated. 
	}
	
	public static int randInt(int low, int high) {
		double c = Math.random();
		return (int) (c * (high - low + 1) + 1);
	}
	
	public static void main(String[] args) {
		
		for (int i =1; i < 20; i++) {
			System.out.println("random " + randInt(1,20));
		}

		
	}

}
