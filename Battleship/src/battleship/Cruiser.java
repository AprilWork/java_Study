package battleship;

public class Cruiser extends Ship {

	public Cruiser() {
		// TODO Auto-generated constructor stub
		setLength(6);
		boolean[] hit = new boolean[6];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "cruiser";
	}

}
