package battleship;

import java.util.Random;

public class Ocean {
	Ship[][] ships = new Ship[20][20]; // Used to quickly determine which ship is in any given location.
	int shotsFired; // The total number of shots fired by the user.
	int hitCount; // The number of times a shot hit a ship. 
				  // If the user shoots the same part of a ship more than once, every hit is counted, 
				  // even though the additional ”hits” don’t do the user any good.
	int shipsSunk; // The number of ships sunk. Remember that you have a total of 13 ships.  
	final int TOTAL_SHIPS = 13;
	
	int shipsPlaced;
	
	
	public Ocean() {
	//TODO
	/*
	 * The constructor. Creates an ”empty” ocean 
	 * (fills the ships array with a bunch of EmptySea instances).
	 * Also initializes any game variables, such as how many shots have been fired.	
	 */
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships.length; j++) {
				ships[i][j] = new EmptySea();
			}
		}
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		this.shipsPlaced = 0;
	}
	
	void placeAllShipsRandomly() {
	//TODO
	/*
	 * Place all randomly on the (initially empty) ocean. 
	 * Place larger ships before smaller ones, 
	 * or you may end up with no legal place to put a large ship. 
	 * You will want to use the Random class in the java.util package, 
	 * so look that up in the Java API. 
	 */
		
		Random randX = new Random();
		//Random randY = new Random();
		//Random randHV = new Random();
		
		BattleShip battleShip = new BattleShip();
		placeShip(battleShip,randX);
		
		BattleCruiser battleCruiser = new BattleCruiser();
		placeShip(battleCruiser,randX);
		
		Cruiser cruiser = new Cruiser();
		placeShip(cruiser,randX);
		cruiser = new Cruiser();
		placeShip(cruiser,randX);
		
		LightCruiser lightCruiser = new LightCruiser();
		placeShip(lightCruiser,randX);
		lightCruiser = new LightCruiser();
		placeShip(lightCruiser,randX);
		
		Destroyer destroyer = new Destroyer();
		placeShip(destroyer,randX);
		destroyer = new Destroyer();
		placeShip(destroyer,randX);
		destroyer = new Destroyer();
		placeShip(destroyer,randX);
		
		Submarine submarine = new Submarine();
		placeShip(submarine,randX);
		submarine = new Submarine();
		placeShip(submarine,randX);
		submarine = new Submarine();
		placeShip(submarine,randX);
		submarine = new Submarine();
		placeShip(submarine,randX);
		
	}
	
	void placeShip(Ship ship, Random randX) {
		
		
		int row;
		int column;
		boolean horizontal;
		
		do {
			row = randX.nextInt(20);
			column = randX.nextInt(20);
			horizontal = randX.nextBoolean();
		} while (!ship.okToPlaceShipAt(row, column, horizontal, this));
		
		//System.out.println(row + " " + column + " " + horizontal);
		ship.placeShipAt(row, column, horizontal, this);
		this.shipsPlaced++;
		
	}
	
	boolean isOccupied(int row, int column) {
	//TODO
	// Returns true if the given location contains a ship, false if it does not.
		return (this.ships[row][column].getShipType() != "empty");
	}
	
	boolean shootAt(int row, int column) {
	//TODO	
	/*
	 * Returns true if the given location contains a ”real” ship, still afloat, 
	 * (not an EmptySea), false if it does not. 
	 * In addition, this method updates the number of shots that have been fired, 
	 * and the number of hits. 
	 * Note: If a location contains a ”real” ship, 
	 * shootAt should return true every time the user shoots at that same location. 
	 * Once a ship has been ”sunk”, additional shots at its location should return false.
	 */
		shotsFired++;
		if (this.ships[row][column].shootAt(row, column)) { // hit counter increment
			hitCount++;
			if (this.ships[row][column].isSunk()) { this.shipsSunk++; }
			return true;
		}
		return (this.ships[row][column].getShipType() != "empty") && 
				(this.ships[row][column].isSunk() == false);
	}	
	
	int getShotsFired() {
	//TODO
	// Returns the number of shots fired (in this game).
		return this.shotsFired;
	}	
	
	int getHitCount() {
	//TODO
	/*
	 *  Returns the number of hits recorded (in this game). 
	 *  All hits are counted, not just the first time a given square is hit.
	 */
		return this.hitCount;
	}
	
	int getShipsSunk() {
	//TODO
	//Returns the number of ships sunk (in this game).
		return this.shipsSunk;
	}
	
	boolean isGameOver() {
	//TODO
	//Returns true if all ships have been sunk, otherwise false.
		return (getShipsSunk() == TOTAL_SHIPS);
	}	
	
	Ship[][] getShipArray() {
	//TODO	
	/* 
	 * Returns the 20x20 array of ships. 
	 * The methods in the Ship class that take an Ocean parameter 
	 * really need to be able to look at the contents of this array; 
	 * the placeShipAt method even needs to modify it. 
	 * While it is undesirable to allow methods in one class 
	 * to directly access instance variables in another class, 
	 * sometimes there is just no good alternative.
	 */
		return this.ships;
	}
	
	void print() {
	//TODO
	/*
	 * Prints the ocean. 
	 * To aid the user, row numbers should be displayed along the left edge of the array, 
	 * and column numbers should be displayed along the top. 
	 * Numbers should be 00 to 19, not 1 to 20.
	 */
		
	/*
	 * The top left corner square should be 0, 0.
	 * Use ’S’ to indicate a location that you have fired upon and hit a (real) ship, 
	 * ’-’ to indicate a location that you have fired upon and found nothing there, 
	 * ’x’ to indicate a location containing a sunken ship,
	 * and ’.’ (a period) to indicate a location that you have never fired upon.
	 * This is the only method in the Ocean class that does any input/output, 
	 * and it is never called from within the Ocean class 
	 * (except possibly during debugging), only from the BattleshipGame class.	
	 */
		boolean isXAxes = false;
		boolean isYAxes = false;
		String str = "";
		
		for (int i = 0; i <= ships.length; i++) {
			for (int j = 0; j <= ships.length; j++) {
				isXAxes = (i == 0);
				isYAxes = (j == 0);
				if (isXAxes) {
					if (isYAxes) { 
						str = "  ";
					} else {
						str = String.format("%02d ", j-1);
					}
					System.out.printf(str);
				} else {
					if (isYAxes) {
						str = String.format("%02d ", i-1);
						System.out.printf(str);
					} else {
						//TODO
						// check if fired upon and found nothing there
						
						if (isHited(i-1,j-1)) {
							str = ships[i-1][j-1].toString();
						} else {
							
							str = ".";
						}
						

						System.out.print(str + "  ");
					}
				}
			}
			System.out.println();
		}
	}
	
	protected boolean isHited(int row, int column) {
		//TODO
		Ship ship = ships[row][column];
		if (ship.isSunk()) {
			return true;
		}
		if (ship.getLength() == 1) {
			if (ship.getHit()[0]) {
				return true;
			} else {
				return false;
			}

		}
		int hitIndex;
		
		if (ship.isHorizontal()) {
			hitIndex = column - ship.getBowColumn();
			if (ship.getHit()[hitIndex]) {
				return true;
			}
		} else  {
			hitIndex = row - ship.getBowRow();
			if (ship.getHit()[hitIndex]) {
				return true;
			}
		}
		
		return false;
	}
	
}
