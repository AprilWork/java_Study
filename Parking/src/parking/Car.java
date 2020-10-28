package parking;
/**
 * add new comment to head
 * @author Irene Mitin
 *
 */
public class Car {
	private String ownerName;
	private int ownerLicenceNum;
	private int registrationNum;
	
	private int parkingLoc;
	
	public Car(String name, int licence, int registration) {
		this.ownerName = name;
		this.ownerLicenceNum = licence;
		this.registrationNum = registration;
	}
	
	public int getParkingLoc() {
		return parkingLoc;
	}
	
	public void setParkingLoc(int loc) {
		parkingLoc = loc;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getOwnerLicenceNum() {
		return ownerLicenceNum;
	}
	public int getRegistrationNum() {
		return registrationNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ownerName + " owns car " + registrationNum; 
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Car carObj = (Car) obj;
		return this.registrationNum == carObj.registrationNum;
	}
	
	public static void main(String[] args) {
		Car car1 = new Car("abc",345,890);
		System.out.println(car1);
		Car car2 = new Car("def",345,890);
		System.out.println(car1);
		System.out.println(car1 == car2);
		System.out.println(car1.equals(car2));
		String s1 = "aba";
		String s2 = "ab";
		s2 = s2 + "a";
		System.out.println(s1.equals(s2));
	}
	
}
