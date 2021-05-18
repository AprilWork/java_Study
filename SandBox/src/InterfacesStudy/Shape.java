package InterfacesStudy;

abstract class Shape implements drawable, sizable, movable<Shape> {
	
	/**
		 * @author Irene Mitin
		 *
		 */

	public ShapeType  shape;
	public static Boolean drawed = false;
	private boolean increased = false;
	private boolean moved = false;
	
	public Shape() {
		// TODO Auto-generated constructor stub
		this.shape = ShapeType.RECTANGLE;
		System.out.println(this.shape.toString());
		System.out.println("Shape()  constructor");
		this.increased = false;
	}
	
	public Shape(ShapeType shape) {
		//System.out.println(this.shape.toString());
		this.shape = shape;
		System.out.println("Shape(shape)  constructor " + this.shape.name());
		this.increased = false;
	}
	
	public String name() {
		return shape.name();
	}

	@Override
	public void print() {
		System.out.println("shape print method");
		drawable.super.print();
		sizable.super.print();
		System.out.println("shape print method ended");
	}
		
	@Override
	public boolean hasIncreased() {
		// TODO Auto-generated method stub
		return increased;
	}
	
	public void setIncreased(boolean inc) {
		this.increased = inc;
	}
	
	public void setMoved(boolean b) {
		// TODO Auto-generated method stub
		this.moved = b;
	}
	
	public boolean getMoved() {
		return this.moved;
	}
	

	
}


