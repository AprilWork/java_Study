package parking;

public class ParkingGarage {
	private Car[] cars;
	private int spots;
	
	public ParkingGarage(int spot) {
		this.spots = spot;
		cars = new Car[spots];
	}
	
	/**
	 * try and park car.
	 * return false if lot is full
	 * @param carToBeParked
	 * @return
	 */
	public boolean park(Car carToBeParked) {
	
		int i = 0;
		while ((cars[i] != null) && (i < cars.length)) {
			i++;
		}
		if (i == cars.length) return false;
		cars[i] = carToBeParked;
		carToBeParked.setParkingLoc(i);
		return true;
	}
}
