package battleship;

public class LightCruiser extends Ship {

	public LightCruiser() {
		// TODO Auto-generated constructor stub
		setLength(5);
		boolean[] hit = new boolean[5];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "light cruiser";
	}

}
