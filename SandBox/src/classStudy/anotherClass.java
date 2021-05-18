package classStudy;

import classStudy.OuterClass.NestedClass;

public class anotherClass {

	static int doors = 10;
	int windows = 15;
	final int SQFT = 1000;
	static final int ROOF = 1;
	
	
	public anotherClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("outer counter " + OuterClass.counter);
		System.out.println("outer nested counter " + (OuterClass.StaticNestedClass.counter));
		OuterClass.changeGardens(8);
		
		OuterClass outer = new OuterClass();
		outer.changeDoors();

		System.out.println(outer.name);
		System.out.println("outer counter " + OuterClass.counter);
		OuterClass.StaticNestedClass.count();
		System.out.println("static nested counter " + OuterClass.StaticNestedClass.counter);
		
		outer.name = "hohoho";
		OuterClass.counter = 88;
		System.out.println(outer.name);
		System.out.println("outer counter " + OuterClass.counter);
		OuterClass.StaticNestedClass.count();
		System.out.println("static nested counter " + OuterClass.StaticNestedClass.counter);
		
		OuterClass outer1 = new OuterClass();
		System.out.println("outer counter " + OuterClass.counter);
		OuterClass.StaticNestedClass.count();
		OuterClass.StaticNestedClass.ceiling = OuterClass.StaticNestedClass.numberGardens();
		System.out.println("static nested counter " + OuterClass.StaticNestedClass.counter);
		
		OuterClass outer2 = new OuterClass();
		System.out.println("outer counter " + OuterClass.counter);
		OuterClass.StaticNestedClass.count();
		System.out.println("static nested counter " + OuterClass.StaticNestedClass.counter);
		System.out.println("non-static nested class gardens " + OuterClass.StaticNestedClass.numberGardens());
		
		OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
		System.out.println("static nested is " + nested.isNested());
		nested.color = 5;
		
		OuterClass.NestedClass nested1 = outer2.new NestedClass();
		System.out.println("non-static nested is " + nested1.isNested());
		System.out.println("non-static nested number doors " + outer2.getDoors());
		System.out.println("non-static nested number windows " + outer2.getWindows());
		nested1.nextChair();
		System.out.println("non-static nested Chair " + nested1.Chair);
		
		
	}

}
