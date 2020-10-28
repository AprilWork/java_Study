package battleship;

public class Destroyer extends Ship {

	public Destroyer() {
		// TODO Auto-generated constructor stub
		setLength(4);
		boolean[] hit = new boolean[4];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "destroyer";
	}

}
