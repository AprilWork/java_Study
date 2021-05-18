package InterfacesStudy;

class Point implements movable<Point>, drawable {
	
	private int x;
	private int y;
	private  boolean moved = false;
	

	/**
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.moved = false;
	}


	public Point() {
		this.x = 0;
		this.y = 0;
		this.moved = false;
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
		
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean isMoved() {
		// TODO Auto-generated method stub
		return moved;
	}

	@Override
	public Point moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		this.moved = true;
		return this;
	}


	@Override
	public void draw() {
		// TODO Auto-generated method stub
		this.moved = false;
	}

}
