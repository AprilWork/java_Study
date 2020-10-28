package battleship;

public abstract class Ship {
	/* 
	 * Since we don’t really care which end of a ship is the bow and which the stern, 
	 * we will consider all ships to be facing up or left. 
	 * Other parts of the ship are in higher-numbered rows or columns.
	 */
	private int bowRow; // the row (0 to 19) which contains the bow (front) of the ship.
	private int bowColumn; // the column which contains the bow (front) of the ship.    
	private int length; // the number of squares occupied by the ship. An ”empty sea” location has length 1. 
	private boolean horizontal; // true if the ship occupies a single row, false otherwise. 
								// Ships will either be placed vertically or horizontally in the ocean.
	private boolean[] hit; // this is a boolean array of size 8 that record hits. 
						   // Only battleships use all the locations. The others will use fewer.
	
	abstract String getShipType();
	
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	//TODO
	/*
	 * Returns true if it is okay to put a ship of this length with its bow in this location, 
	 * with the given orientation, and returns false otherwise. 
	 * The ship must not overlap another ship, 
	 * or touch another ship (vertically, horizontally, or diagonally), 
	 * and it must not ”stick out” beyond the array. 
	 * Do not actually change either the ship or the Ocean, just says whether it is legal to do so.
	 */
		
		// check if out of array
		if (outOfArray(row, column, horizontal, ocean)) {
			return false;
		}
		// check touch or overlap another ship
		if (touchOrOverlapAnotherShip(row, column, horizontal, ocean)) {
			return false;
		}
		return true;
	}
	
	/*
	 *  check point and points around
	 */
	protected boolean shipAroundPoint(int row, int column, Ocean ocean) {
		//TODO
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if ( pointInArray(row + i, column + j, ocean) ) { 
					if (ocean.isOccupied(row + i,column + j)) return true;
				}
			}	
		}
		return false;
	}
	
	/*
	 *  check if touch or overlap another ship
	 */
	
	protected boolean touchOrOverlapAnotherShip(int row, int column, boolean horizontal, Ocean ocean) {
		//TODO
		if (horizontal) {
			for (int i = column; i < column + this.length; i++) {
				if (shipAroundPoint(row, i, ocean)) return true;
			}
			
		} else {
			for (int i = row; i < row + this.length; i++) {
				if (shipAroundPoint(i, column, ocean)) return true;
			}
		}
		return false;
	}
	
	
	
	/*
	 * check if point in array of ocean
	 */
	protected boolean pointInArray(int row, int column, Ocean ocean) {
		//TODO
		int length = ocean.ships.length;
		if ( ((row >= 0) && (row < length)) &&
				((column >= 0) && (column < length)) ) {
			return true;
		}
		return false;
	}
	
	/*
	 * Check if ship beyond array
	 */
	protected boolean outOfArray(int row, int column, boolean horizontal, Ocean ocean) {
		//TODO
		boolean inArray = false;
		boolean okHorizontal = false;
		boolean okVertical = false;
		
		inArray = ((row >= 0) && (row < ocean.ships.length)) &&
					 ((column >= 0) && (column < ocean.ships.length));
		if (!inArray) {
			return true;
		}
		if (horizontal) {
			okHorizontal = ((column + this.getLength()-1) < ocean.ships.length);
			if (!okHorizontal) {
				return true;
			}
		} else {
			okVertical = ((row + this.getLength()-1) < ocean.ships.length);
			if (!okVertical) {
				return true;
			}
		}
		
		return false;
	}
	
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	//TODO
	/*
	 * ”Puts” the ship in the ocean. 
	 * This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship, 
	 * and it also involves putting a reference to the ship in each of 1 or more locations (up to 8) 
	 * in the ships array in the Ocean object. 
	 * (Note: This will be as many as eight identical references; 
	 * you can’t refer to a ”part” of a ship, only to the whole ship.)
	 */
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		if (horizontal) {
			for (int i = 0; i < this.getLength(); i++) {
				ocean.ships[row][column + i] = this; 
			}		
		} else {
			for (int i = 0; i < this.getLength(); i++) {
				ocean.ships[row + i][column] = this; 	
			}	
		}
		
	}
	
	 
	boolean shootAt(int row, int column) {
	//TODO
	/*
	 * If a part of the ship occupies the given row and column, 
	 * and the ship hasn’t been sunk, mark that part of the ship as ”hit” 
	 * (in the hit array, 0 indicates the bow) and return true, otherwise return false.
	 */
		if (isSunk()) return false;
		if (isHorizontal()) {
			if ( (row == getBowRow()) && 
					(column >= getBowColumn()) && 
					( column < (getBowColumn() + getLength()) ) ) {
				//occupies 
				getHit()[column  - getBowColumn()] = true; //mark that part of the ship as ”hit” 
				return true;
			}
		} else {
			if ( (column == getBowColumn()) && 
					(row >= getBowRow()) && 
					(row < (getBowRow() + getLength()) ) ) {
				//occupies 
				getHit()[row - getBowRow()] = true; //mark that part of the ship as ”hit” 
				return true;
			}				
		}
		
		return false;
	}	
	
	boolean isSunk() {
	//TODO
	/*
	 * Return true if every part of the ship has been hit, false otherwise.
	 */
		for (int i = 0; i < this.length; i++) {
			if (this.getHit()[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	
	@Override

	public String toString() {
	//TODO
	/*
	 * Returns a single-character String to use in the Ocean’s print method (see below).
	 * This method should return ”x” if the ship has been sunk, ”S” if it has not been sunk. 
	 * This method can be used to print out locations in the ocean that have been shot at; 
	 * it should not be used to print locations that have not been shot at.
	 * Since toString behaves exactly the same for all ship types, it can be moved into the Ship class.
	 *Note that the toString method for the EmptySea class has to override the Ship class's implementation. 
	 *In order to figure out what needs to be done, 
	 *please see the description of the print method in the Ocean class.
	 */
		String myString = "";
		if (this.isSunk()) {
			myString = "x";
		} else {
			myString = "S";
		}
		return myString;
	}
	
	/**
	 * @return the bowRow
	 */
	public int getBowRow() {
		return bowRow;
	}
	/**
	 * @param bowRow the bowRow to set
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	/**
	 * @return the bowColumn
	 */
	public int getBowColumn() {
		return bowColumn;
	}
	/**
	 * @param bowColumn the bowColumn to set
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}
	/**
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	/**
	 * @return the hit
	 */
	public boolean[] getHit() {
		return hit;
	}
	/**
	 * @param hit the hit to set
	 */
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
	
	
}
