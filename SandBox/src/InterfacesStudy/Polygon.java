package InterfacesStudy;

import java.util.Vector;

class Polygon extends Shape implements movable<Shape> {

	public int sides;
	public int countPoints; 
	public Vector<Point> points;
	
	public Polygon() {
		// TODO Auto-generated constructor stub
		super(ShapeType.POLYGON);
		this.countPoints = 4;
		this.sides = 4;
		points = new Vector<>(this.countPoints);
		for (int i = 0 ; i < this.countPoints; i++) {
			Point p =  new Point(30 + i*3,80 + i*2);
			points.add(p);
		}
	}
	
	public Polygon(int countPoints) {
		super(ShapeType.POLYGON);
		this.sides = 4;
		this.countPoints = countPoints;
		points = new Vector<>(this.countPoints);
		for (int i = 0 ; i < this.countPoints; i++) {
			Point p =  new Point(30 + i*3,80 + i*2);
			points.add(p);
		}
	}
	
	public Polygon(Vector<Point> points) {
		super(ShapeType.POLYGON);
		this.sides = 4;
		this.countPoints = points.size();
		this.points = points;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("polygon draw method");
		for (Point point : points) {
			System.out.println("point " + point.getX() + "," + point.getY());
		}
		setIncreased(false);
		setMoved(false);
	}

	@Override
	public Shape increased(int i) {
		// TODO Auto-generated method stub
		this.sides = this.sides * i;
		setIncreased(true);
		return this;
	}

	@Override
	public Shape moveTo(int x, int y) {
		// TODO Auto-generated method stub
		for (Point point : points) {
			point.setX(point.getX() + x);
			point.setY(point.getY() + y);
		}
		setMoved(true);
		return this;
	}


	@Override
	public boolean isMoved() {
		// TODO Auto-generated method stub
		return getMoved();
	}

}
