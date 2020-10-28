package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleShipTest {
	Ocean myOcean;
	BattleShip myShip;

	@BeforeEach
	void setUp() throws Exception {
		myOcean = new Ocean();
		myShip = new BattleShip();
		myShip.placeShipAt(3, 4, true, myOcean);
	}

	@Test
	void testGetShipType() {
		assertEquals("battleship", myShip.getShipType());
	}

	@Test
	void testBattleShip() {
		assertNotNull(myShip);
		assertEquals(8, myShip.getLength());
	}

	@Test
	void testOkToPlaceShipAt() {
		// TODO
		assertEquals(true, myShip.okToPlaceShipAt(5, 8, true, myOcean));
		assertEquals(false, myShip.okToPlaceShipAt(5, 17, true, myOcean));
		assertEquals(false, myShip.okToPlaceShipAt(16, 8, false, myOcean));
		assertEquals(false, myShip.okToPlaceShipAt(2, 8, true, myOcean));
		assertEquals(true, myShip.okToPlaceShipAt(5, 8, false, myOcean));
		assertEquals(false, myShip.okToPlaceShipAt(0, 5, false, myOcean));
	}

	@Test
	void testPlaceShipAt() {
		
		BattleShip newShipH = new BattleShip();
		newShipH.placeShipAt(15, 5, true, myOcean);
		assertEquals(15, newShipH.getBowRow());
		assertEquals(5, newShipH.getBowColumn());
		assertEquals(true, newShipH.isHorizontal());
		for (int i = 0; i < newShipH.getLength(); i++) {
			assertTrue(myOcean.ships[15][5 + i].getShipType() == "battleship");
			assertTrue(myOcean.ships[15][5 + i] == newShipH);
		}
		
		BattleShip newShipV = new BattleShip();
		newShipV.placeShipAt(5, 2, false, myOcean);
		assertEquals(5, newShipV.getBowRow());
		assertEquals(2, newShipV.getBowColumn());
		assertEquals(false, newShipV.isHorizontal());
		for (int i = 0; i < newShipV.getLength(); i++) {
			assertTrue(myOcean.ships[5 + i][2].getShipType() == "battleship");
			assertTrue(myOcean.ships[5 + i][2] == newShipV);
		}
	}

	@Test
	void testShootAt() {

		assertEquals(true, myShip.shootAt(3, 6));
		assertEquals(true, myShip.shootAt(3, 6));
		assertEquals(true, myShip.shootAt(3, 8));
		assertEquals(false, myShip.shootAt(3, 18));
		assertEquals(false, myShip.shootAt(4, 6));
		
		BattleShip newShipV = new BattleShip();
		newShipV.placeShipAt(5, 2, false, myOcean);
		assertEquals(true, newShipV.shootAt(5,2));
		assertEquals(true, newShipV.shootAt(5,2));
		assertEquals(true, newShipV.shootAt(6,2));
		assertEquals(true, newShipV.shootAt(7,2));
	}

	@Test
	void testIsSunk() {

		myShip.shootAt(3,4);
		myShip.shootAt(3,5);
		myShip.shootAt(3,6);
		myShip.shootAt(3,7);
		myShip.shootAt(3,8);
		assertEquals(false, myShip.isSunk());
		myShip.shootAt(3,9);
		myShip.shootAt(3,10);
		myShip.shootAt(3,11);
		myShip.shootAt(3,12);
		assertEquals(true, myShip.isSunk());
	}

	@Test
	void testToString() {

		assertTrue(((myShip.toString() == "S") && (myShip.isSunk() == false)) || 
				((myShip.toString() == "x") && (myShip.isSunk() == true)) );
	}

	@Test
	void testGetBowRow() {

		assertEquals(3, myShip.getBowRow());
	}

	@Test
	void testSetBowRow() {

		myShip.setBowRow(6);
		assertEquals(6, myShip.getBowRow());
		myShip.setBowRow(3);
		assertEquals(3, myShip.getBowRow());
	}

	@Test
	void testGetBowColumn() {

		assertEquals(4, myShip.getBowColumn());
	}

	@Test
	void testSetBowColumn() {

		myShip.setBowColumn(14);
		assertEquals(14, myShip.getBowColumn());
		myShip.setBowColumn(4);
		assertEquals(4, myShip.getBowColumn());
	}

	@Test
	void testGetLength() {

		assertEquals(8, myShip.getLength());
	}

	@Test
	void testSetLength() {

		myShip.setLength(5);
		assertEquals(5, myShip.getLength());
		myShip.setLength(8);
		assertEquals(8, myShip.getLength());
	}

	@Test
	void testIsHorizontal() {

		assertEquals(true, myShip.isHorizontal());
	}

	@Test
	void testSetHorizontal() {

		myShip.setHorizontal(false);
		assertEquals(false, myShip.isHorizontal());
		myShip.setHorizontal(true);
		assertEquals(true, myShip.isHorizontal());
	}

	@Test
	void testGetHit() {

		boolean myHit[];
		myHit = myShip.getHit();
		myHit[6] = true;
		assertEquals(true, myShip.getHit()[6]);
		myHit[6] = false;
		assertEquals(false, myShip.getHit()[6]);
	}

	@Test
	void testSetHit() {

		boolean myHit[];
		myHit = new boolean[8];
		for (int i = 0; i < myHit.length; i++ ) {
			myHit[i] = false; 
		}
		myHit[6] = true;
		myShip.setHit(myHit);
		assertEquals(true, myShip.getHit()[6]);
		myHit[6] = false;
		myShip.setHit(myHit);
		assertEquals(false, myShip.getHit()[6]);
	}
	
	@Test
	void testOutOfArray() {
		//fail("Not yet implemented"); // TODO
		assertEquals(true, myShip.outOfArray(23, 18, false, myOcean));
	}
	
	@Test
	void testPointInArray() {
		//fail("Not yet implemented"); // TODO
		assertTrue(myShip.pointInArray(0, -1, myOcean) == false);	
	}
	
	@Test
	void testShipAroundPoint() {
		//fail("Not yet implemented"); // TODO
		assertTrue(myShip.shipAroundPoint(2,3, myOcean) == true);
		
		for (int i = 2; i < 5; i++) {
			for(int j = 3; j < 13; j++) {
				assertTrue(myShip.shipAroundPoint(i, j, myOcean) == true);
			}
		}
		
		for (int i = 2; i < 10; i++) {
			assertTrue(myShip.shipAroundPoint(5, i, myOcean) == false);
		}
		
		//assertTrue(myShip.shipAroundPoint(4, 4, myOcean) == true);
		//assertTrue(myShip.shipAroundPoint(3, 4, myOcean) == true);
		//assertTrue(myShip.shipAroundPoint(4, 4, myOcean) == true);
	}
	
	@Test
	void testTouchOrOverlapAnotherShip() {
		//fail("Not yet implemented"); // TODO
		assertTrue(myShip.touchOrOverlapAnotherShip(0,1,true,myOcean) == false); 
		assertTrue(myShip.touchOrOverlapAnotherShip(3,1,true,myOcean) == true); 
		assertTrue(myShip.touchOrOverlapAnotherShip(4,2,true,myOcean) == true); 
		assertTrue(myShip.touchOrOverlapAnotherShip(4,12,true,myOcean) == true);
		
		assertTrue(myShip.touchOrOverlapAnotherShip(0,1,false,myOcean) == false); 
		assertTrue(myShip.touchOrOverlapAnotherShip(0,3,false,myOcean) == true); 
		assertTrue(myShip.touchOrOverlapAnotherShip(0,5,false,myOcean) == true); 
		assertTrue(myShip.touchOrOverlapAnotherShip(0,11,false,myOcean) == true); 
		assertTrue(myShip.touchOrOverlapAnotherShip(0,12,false,myOcean) == true); 
		assertTrue(myShip.touchOrOverlapAnotherShip(0,13,false,myOcean) == false); 
	}
	
}
