package battleship;

public class Submarine extends Ship {

	public Submarine() {
		// TODO Auto-generated constructor stub
		setLength(3);
		boolean[] hit = new boolean[3];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "submarine";
	}

}
