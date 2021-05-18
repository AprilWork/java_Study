package classStudy;

public class OuterClass {

	public String name = "OuterClass";
	
	public static int counter;
	
	private int doors = 1; // field or member variable or instance variable        
	private int windows = 1; // field or member variable or instance variable   
	private final int ROOF = 1; // instance constant
	
	private static final int entryDoors = 2; // static constant or class constant 
	private static int gardens = 1; // static field or class variable 
	private static final int SQFT = 1000; // static constant or class constant
	
	public OuterClass() {
		// TODO Auto-generated constructor stub
		this.doors = entryDoors; // compile-time constant
		this.windows = 20;
		gardens = 1;
		this.name = "outer!!!";
		counter = counter + 1;
	}
	
	public class NestedClass { // non-static nested class
		
		public int counter;
		public Boolean Chair;
		static final int Wood = 8; // static field initialized with constant expression
		// static int Color; cannot be declared static in non-static inner type 
		
		public void count() {
			counter = counter + 1;
			this.counter = counter +1;
		}
		
		public Boolean isNested() {
			windows = 500;
			changeDoors();
			return true;
		}
		
		public void nextChair() {
			Chair = true;
		}
/* static method can only declared in the static or top-level type	
		static void setWood() {
			Wood = 601;
		}
*/		
	}
	
	private class PrivateNestedClass { // non-static nested class
		
		public int counter;
		
		public void count() {
			counter = counter + 1;
			this.counter = counter +1;
		}
		
	}
	
	public static class StaticNestedClass { // non-static nested class
		
		public static int counter;
		public static int ceiling = 1; 
		public int color;
		
		public static void count() {
			//counter = counter + 1;
			counter = counter +1;
		}
		
		public static int numberGardens() {
			//doors = 56;
			gardens = 313;
			return gardens;
		}
		
		public Boolean isNested() {
			//doors = 56;
			gardens = 77;
			return true;
		}
		
		//public int is
		
	}
	
	private static class PrivateStaticNestedClass { // non-static nested class
		
		public static int counter;
		
		public static void count() {
			//counter = counter + 1;
			counter = counter +1;
		}
		
	}
	
	public void changeDoors() { // instance method
		doors = 111;
	}
	
	public int getDoors() {
		return doors;
	}
	
	public int getWindows() {
		return windows;
	}
	
	public void removeInnerDoors() { // instance method
		
		doors = doors - entryDoors;
	}
	
	public static void changeGardens(int num) { // static method or class methods
		gardens = num;
		// this.gardens = 7; cannot use this in static methods as there no instance for this reference.
		// doors = 89; cannot access instance variables or instance methods directly — they must use an object reference.
		//changeDoors(); cannot make a static reference to the non-static method — they must use an object reference.
	}

	public static void main(String[] args) { // static method or class methods
		// TODO Auto-generated method stub
		
		OuterClass.gardens = 3;
		
		System.out.println("class gardens " + OuterClass.gardens);
		System.out.println("class SQFT " + OuterClass.SQFT);
		
		System.out.println();
		System.out.println("Create instance of OuterClass");
		System.out.println();
		
		OuterClass outerObject = new OuterClass();
		
		System.out.println("instance old doors " + outerObject.doors);
		outerObject.doors = 5;
		System.out.println("instance old windows " + outerObject.windows);
		outerObject.windows = 5;
		outerObject.gardens = 2;
		
		System.out.println("class gardens " + outerObject.gardens);
		System.out.println("instance new doors " + outerObject.doors);
		System.out.println("instance new windows " + outerObject.windows);
		System.out.println("instance final ROOF " + outerObject.ROOF);
		System.out.println("class final SQFT " + outerObject.SQFT);

		System.out.println();
		System.out.println();
		System.out.println("anotherClass");
		System.out.println();	
		
		System.out.println("class final ROOF " + anotherClass.ROOF); 
		System.out.println("class doors " + anotherClass.doors); 
		
		anotherClass.doors = 100;
		System.out.println("class doors " + anotherClass.doors);
		
		System.out.println();
		System.out.println();
		System.out.println("Create instance of anotherClass");
		System.out.println();	
		
		anotherClass another = new anotherClass();
		anotherClass another2 = new anotherClass();
		
		System.out.println("class doors " + another.doors);
		another2.doors = 99;
		System.out.println("class doors " + another.doors);
		
		System.out.println("instance windows " + another.windows);
		another.windows = 30;
		System.out.println("instance windows " + another.windows);
		another2.windows = 60;
		System.out.println("instance windows " + another.windows);
		
	}

}
