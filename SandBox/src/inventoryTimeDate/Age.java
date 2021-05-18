package inventoryTimeDate;

import java.time.LocalDate;

public class Age implements ageing {

	private LocalDate datePlanting;
	private LocalDate currentDate;
	private long age = 0;
	
	public Age() {
		// TODO Auto-generated constructor stub
		currentDate = LocalDate.now();
		this.datePlanting = this.currentDate.minusYears(age);
	}
	
	public Age(long age) {
		this.age = age;
		this.currentDate = LocalDate.now();
		this.datePlanting = this.currentDate.minusYears(age);
	}
	
	public Age(LocalDate datePlanting, LocalDate currentDate) {
		this.currentDate = currentDate;
		this.datePlanting = datePlanting;
		this.age = ( this.datePlanting.until(this.currentDate)).getYears();
	}
	
	/**
	 * @return the datePlanting
	 */
	@Override
	public LocalDate getDatePlanting() {
		return datePlanting;
	}

	/**
	 * @param datePlanting the datePlanting to set
	 */
	@Override
	public void setDatePlanting(LocalDate datePlanting) {
		this.datePlanting = datePlanting;
		this.age = ( this.datePlanting.until(this.currentDate)).getYears();
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
		this.age = ( this.datePlanting.until(this.currentDate)).getYears();
	}

	/**
	 * @return the age
	 */
	@Override
	public long getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	@Override
	public void setAge(long age) {
		this.age = age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ageing age = new Age(27);
		System.out.println(age.getDatePlanting() + " " + age.getAge() ); 
		age.setDatePlanting(LocalDate.of(1990, 6, 27));
		System.out.println(age.getDatePlanting() + " " + age.getAge() ); 
		
		ageing age1 = new Age(LocalDate.of(1994, 5, 6),LocalDate.now());
		System.out.println(age1.getDatePlanting() + " " + age1.getAge() ); 
	}

}
