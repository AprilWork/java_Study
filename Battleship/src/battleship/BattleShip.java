package battleship;

public class BattleShip  extends Ship{

	public BattleShip() {
		// TODO Auto-generated constructor stub
		setLength(8);
		boolean[] hit = new boolean[8];
		for (int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		setHit(hit);
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "battleship";
	}

}
