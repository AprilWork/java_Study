package InterfacesStudy;

class Circle extends Shape implements movable<Shape> {

	public int diameter;
	public Point center;
	
	public Circle() {
		super(ShapeType.CIRCLE);
		this.diameter = 5;
		this.center = new Point(60,40);
		System.out.println("constructor " + this.shape.name());
	}

	public Circle(ShapeType shape) {
		super(shape);
		this.diameter = 5;
		this.center = new Point(60,40);
		System.out.println("constructor " + this.shape.name());
	}
	
	public Circle(int x, int y, int diameter) {
		super(ShapeType.CIRCLE);
		this.diameter = 5;
		this.center = new Point(x,y);
		System.out.println("constructor " + this.shape.name());
	}

	@Override
	public void draw() {
		System.out.println("circle overrided draw method");
		System.out.println("center " + this.center.getX() + "," + this.center.getY());
		System.out.println("diameter " + this.diameter);
		setIncreased(false);
		setMoved(false);
	}
	
	@Override
	public void print() {
		System.out.println("circle overrided default print method");
		super.print();
		System.out.println("shape  name: " + this.name());
		System.out.println("center: " + this.center.toString());
		System.out.println("diameter: " + this.diameter);
		System.out.println("circle overrided method ended");
	}
	
	public static void main(String[] args) {
		Circle s = new Circle(ShapeType.CIRCLE);
		s.draw();
		//s.print();
		s.increased(3);
		s.draw();
		//s.print();
		s.moveTo(100, 100);
		s.draw();
	}

	@Override
	public Shape increased(int i) {
		// TODO Auto-generated method stub
		this.diameter = this.diameter * i;
		setIncreased(true);
		return this;
	}

	@Override
	public Shape moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.center.setX(this.center.getX() + x);
		this.center.setY(this.center.getY() + y);
		setMoved(true);
		return this;
	}

	@Override
	public boolean isMoved() {
		// TODO Auto-generated method stub
		return getMoved();
	}

}
