package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {
	Ocean myOcean;
	Submarine myShip;

	@BeforeEach
	void setUp() throws Exception {
		myOcean = new Ocean();
	}

	@Test
	void testOcean() {
		//fail("Not yet implemented"); // TODO
		assertNotNull(myOcean);
		assertNotNull(myOcean.ships);
		//assertNotNull(myShip);
		//assertArrayEquals(expected, actual);
		//assertArrayEquals(new Ship[20][20], myOcean.ships);
		//assertArrayEquals(new EmptySea[20][20], myOcean.ships);
	}

	@Test
	void testPlaceAllShipsRandomly() {
		//fail("Not yet implemented"); // TODO
		myOcean.placeAllShipsRandomly();
		assertEquals(13, myOcean.shipsPlaced);
	}

	@Test
	void testIsOccupied() {
		//fail("Not yet implemented"); // TODO
		myShip = new Submarine();
		myShip.placeShipAt(3, 4, true, myOcean);
		assertEquals(false, myOcean.isOccupied(0, 0));
		assertEquals(true, myOcean.isOccupied(3, 4));
		assertEquals(true, myOcean.isOccupied(3, 5));
		assertEquals(true, myOcean.isOccupied(3, 6));
	}

	@Test
	void testShootAt() {
		//fail("Not yet implemented"); // TODO
		myShip = new Submarine();
		myShip.placeShipAt(3, 4, true, myOcean);
		assertTrue(myOcean.shootAt(3, 4));
		assertTrue(myOcean.shootAt(3, 5));
		assertTrue(myOcean.shootAt(3, 6));
		assertTrue(myOcean.shootAt(3, 7) == false);
		assertTrue(myOcean.shootAt(3, 6) == false);
		assertTrue(myOcean.shootAt(3, 5) == false);
	}

	@Test
	void testGetShotsFired() {
		//fail("Not yet implemented"); // TODO
		myOcean.shotsFired = 3;
		myOcean.shipsSunk = 8;
		myOcean.hitCount = 5;
		assertEquals(3, myOcean.getShotsFired());
	}

	@Test
	void testGetHitCount() {
		//fail("Not yet implemented"); // TODO
		myOcean.shotsFired = 3;
		myOcean.shipsSunk = 8;
		myOcean.hitCount = 5;
		assertEquals(5, myOcean.getHitCount());
	}

	@Test
	void testGetShipsSunk() {
		//fail("Not yet implemented"); // TODO
		myOcean.shotsFired = 3;
		myOcean.shipsSunk = 8;
		myOcean.hitCount = 5;
		assertEquals(8, myOcean.getShipsSunk());
	}

	@Test
	void testIsGameOver() {
		//fail("Not yet implemented"); // TODO
		myOcean.shotsFired = 3;
		myOcean.shipsSunk = 8;
		myOcean.hitCount = 5;
		assertTrue(myOcean.isGameOver() == false);
	}

	@Test
	void testGetShipArray() {
		//fail("Not yet implemented"); // TODO
		assertNotNull(myOcean.getShipArray());
		assertEquals(myOcean.ships, myOcean.getShipArray(), "message: method getShipArray do not return ships array.");
		
	}

	@Test
	void testPrint() {
		//fail("Not yet implemented"); // TODO
		//myOcean.placeAllShipsRandomly();
		myShip = new Submarine();
		myShip.placeShipAt(3, 4, true, myOcean);
		assertTrue(myOcean.shootAt(3, 4));
		//assertTrue(myOcean.shootAt(3, 5));
		assertTrue(myOcean.shootAt(3, 6));
		assertTrue(myOcean.shootAt(3, 8) == false);
		
		myShip = new Submarine();
		myShip.placeShipAt(10, 4, false, myOcean);
		assertTrue(myOcean.shootAt(10, 4));
		assertTrue(myOcean.shootAt(11, 4));
		assertTrue(myOcean.shootAt(12, 4));
		assertTrue(myOcean.shootAt(17, 4) == false);
		
		myOcean.print();
	}
	
	@Test
	void testIsHited() {
		//fail("Not yet implemented"); // TODO
		myShip = new Submarine();
		myShip.placeShipAt(3, 4, true, myOcean);
		assertTrue(myOcean.shootAt(3, 4) == myOcean.isHited(3,4));
		assertTrue(myOcean.isHited(3,4));
		//assertTrue(myOcean.shootAt(3, 5));
		assertTrue(myOcean.shootAt(3, 8) == false);
		assertTrue(myOcean.isHited(3,8));
		
		
	}

}
