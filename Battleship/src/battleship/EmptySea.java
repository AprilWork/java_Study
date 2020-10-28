package battleship;

public class EmptySea extends Ship {

	public EmptySea() {
		// TODO Auto-generated constructor stub
		// This constructor sets the inherited length variable to 1.
		this.setLength(1);
		boolean[] hit = new boolean[1];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	
	@Override
	boolean shootAt(int row, int column) {
	//TODO	
	/*
	 * This method overrides shootAt(int row, int column) that is inherited from Ship, 
	 * and always returns false to indicate that nothing was hit.
	 */
		this.getHit()[0] = true;
		return false;
	}
	
	@Override 
	boolean isSunk() {
	//TODO	
	/*
	 * This method overrides isSunk() that is inherited from Ship, 
	 * and always returns false to indicate that you didn’t sink anything.
	 */
		return false;
	}
	
	@Override
	public String toString() {
	//TODO	
	/*
	 * Returns a single-character String to use in the Ocean’s print method.
	 *Since this is the emptysea, you could choose to have an unoccupied sea in many ways
	 */
		if (this.getHit()[0]) {
			return "-";
		} 
		return ".";
	}	
	
	@Override
	String getShipType() {
	//TODO
	// This method just returns the string ”empty”
		return "empty";
	}	
	
}	
