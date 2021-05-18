package InterfacesStudy;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(20,30,40);
		
		Vector<Point> v1 = new Vector<>(3);
		v1.add(new Point(40,60));
		v1.add(new Point(40,30));
		v1.add(new Point(30,60));
		Triangle t = new Triangle(v1);
		
		Vector<Point> vector = new Vector<>(4);
		vector.add(new Point(40,60));
		vector.add(new Point(40,30));
		vector.add(new Point(30,60));
		vector.add(new Point(40,20));
		Rect r1 = new Rect(vector);
		
		List<Shape> shapes = new LinkedList<>();
		
		shapes.add(c);
		shapes.add(t);
		shapes.add(r1);
		
		for (Shape shape : shapes) {
			shape.draw();
		}
		
		for (Shape shape : shapes) {
			shape.moveTo(10, 10);
		}
		
		for (Shape shape : shapes) {
			shape.draw();
		}
	}

}
