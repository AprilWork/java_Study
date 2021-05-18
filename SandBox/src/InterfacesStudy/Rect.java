package InterfacesStudy;

import java.util.Vector;

class Rect extends Polygon {
	
	public Rect() {
		super(4);
		super.shape = ShapeType.RECTANGLE;
		System.out.println("constructor " + this.shape.name());
	}

	public Rect(Vector<Point> points) {
		super(points);
		super.shape = ShapeType.RECTANGLE;
		System.out.println("constructor " + this.shape.name());
	}

	@Override
	public void draw() {
		System.out.println("rect draw method");
		super.draw();
		/*
		for (Point point : points) {
			System.out.println("point " + point.getX() + "," + point.getY());
		}
		setIncreased(false);
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sizable.margin();
		Rect r = new Rect();
		System.out.println("Sides : " + r.countPoints);
		System.out.println("shape  name: " + r.name());
		r.draw();
		r.increased(2);
		System.out.println("increased " + r.hasIncreased());
		r.draw();
		System.out.println("increased " + r.hasIncreased());
		r.moveTo(10, 10);
		System.out.println("moved " + r.isMoved());
		r.draw();
		System.out.println("moved " + r.isMoved());
		
		
		Vector<Point> vector = new Vector<>(4);
		vector.add(new Point(40,60));
		vector.add(new Point(40,30));
		vector.add(new Point(30,60));
		vector.add(new Point(40,20));
		Rect r1 = new Rect(vector);
		
		sizable.margin();
		
		//r1.draw();
		System.out.println("Sides : " + r1.countPoints);
		System.out.println("shape  name: " + r1.name());
		
		Shape s = r1;
		s.draw();
	}



}
