package classStudy;

public class CountTestApp {

	private static void printCount() {
		System.out.println("There are now " 
				+ CountTest.getInstanceCount()
				+ " instance of the CountTest class");
	}
	public static class CountTest {
		private static int instanceCount = 0;
		
		public CountTest() {
			instanceCount++;
		}
		
		public static int getInstanceCount() {
			return instanceCount;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCount();
		for (int i = 0; i < 10; i++) {
			CountTest c1 = new CountTest();
			printCount();
		}
	}

}

