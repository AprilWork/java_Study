package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	Ocean myOcean;
	BattleShip myShip;
	
	@BeforeEach
	void setUp() throws Exception {
		myOcean = new Ocean();
		BattleShip myShip = new BattleShip();
		myShip.placeShipAt(3, 4, true, myOcean);
	}

	@Test
	void testOkToPlaceShipAt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testPlaceShipAt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testShootAt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testIsSunk() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetBowRow() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetBowRow() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetBowColumn() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetBowColumn() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetLength() {
		//fail("Not yet implemented"); // TODO
		assertEquals(8,myShip.getLength());
	}

	@Test
	void testSetLength() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testIsHorizontal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetHorizontal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetHit() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetHit() {
		fail("Not yet implemented"); // TODO
	}

}
