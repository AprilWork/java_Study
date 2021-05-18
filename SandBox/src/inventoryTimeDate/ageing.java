package inventoryTimeDate;

import java.time.LocalDate;

public interface ageing {

	/**
	 * @return the datePlanting
	 */
	LocalDate getDatePlanting();

	/**
	 * @param datePlanting the datePlanting to set
	 */
	void setDatePlanting(LocalDate datePlanting);


	/**
	 * @return the age
	 */
	long getAge();

	/**
	 * @param age the age to set
	 */
	void setAge(long age);

}