package InterfacesStudy;

import java.util.Vector;

class Triangle extends Polygon {

	public Triangle() {
		// TODO Auto-generated constructor stub
		super(3);
		super.shape = ShapeType.TRYANGLE;
		System.out.println("constructor " + this.shape.name());
	}


	public Triangle(Vector<Point> points) {
		super(points);
		super.shape = ShapeType.TRYANGLE;
		System.out.println("constructor " + this.shape.name());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		System.out.println("triangle draw method");
		super.draw();
	}
	

}
