package inventoryTimeDate;

import java.time.LocalDate;

public class AgeCurrent implements ageingCurrent {

	private LocalDate datePlanting;
	private LocalDate currentDate;
	private long age = 0;
	
	public AgeCurrent() {
		// TODO Auto-generated constructor stub
		this.currentDate = LocalDate.now();
		setDatePlanting(LocalDate.of(2000, 4, 15));
		setAge(age);
	}
	
	public AgeCurrent(long age) {
		this.currentDate = LocalDate.now();
		this.age = age;
		this.datePlanting = currentDate.minusYears(age);
	}
	
	public AgeCurrent(LocalDate datePlanting) {
		this.currentDate = LocalDate.now();
		this.datePlanting = datePlanting;
		this.age = ( this.datePlanting.until(currentDate)).getYears();
	}

	/**
	 * @return the currentDate
	 */
	public LocalDate getCurrentDate() {
		LocalDate b = this.currentDate;
		return b;
	}	
	
	@Override
	public LocalDate getDatePlanting() {
		// TODO Auto-generated method stub
		return datePlanting;
	}

	@Override
	public void setDatePlanting(LocalDate datePlanting) {
		// TODO Auto-generated method stub
		this.datePlanting = datePlanting;
		this.age = ( this.datePlanting.until(currentDate)).getYears();
	}

	@Override
	public long getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public void setAge(long age) {
		// TODO Auto-generated method stub
		this.age = age;
		this.datePlanting = currentDate.minusYears(age);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 10; i < 20; i++) {
			AgeCurrent age1 = new AgeCurrent(i);
			System.out.println( age1.getCurrentDate() + " " + age1.getDatePlanting() + " " + age1.getAge());
		}
	}

}
