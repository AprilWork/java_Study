package battleship;

public class BattleCruiser extends Ship{

	public BattleCruiser() {
		// TODO Auto-generated constructor stub
		setLength(7);
		boolean[] hit = new boolean[7];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "battlecruiser";
	}

}
