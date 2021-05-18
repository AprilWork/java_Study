package inventoryTimeDate;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Objects;

public class ArborDate {
	private final Month month;
	private final DayOfWeek dayOfWeek;
	private final CountWeek numbers;
	private final int afterDay;
	private final boolean fullweek;
	
	public  static class Builder {
		// required parameters
		private final Month month;
		private final DayOfWeek dayOfWeek;
		
		//optional parameters - initialized to default values
		private CountWeek numbers = CountWeek.FIRST;
		private int afterDay = 0;
		private boolean fullweek = false;		
		
		public Builder(Month month, DayOfWeek dayOfWeek) {
			this.month = month;
			this.dayOfWeek = dayOfWeek;
			
		}
		
		public Builder countWeek(CountWeek val) {
			numbers = val;	
			return this;
		}
		
		public Builder afterDay(int val) {
			afterDay = val;
			return this;
		}
		
		public Builder fullWeek(boolean val) {
			fullweek = val;
			return this;
		}
		
	public ArborDate build() {
		return new ArborDate(this);
	}	
	
	}


	private ArborDate(Builder builder) {
		month = builder.month;
		dayOfWeek = builder.dayOfWeek;
		numbers = builder.numbers;
		afterDay = builder.afterDay;
		fullweek = builder.fullweek;
	}

	/**
	 * @return the month
	 */
	public Month getMonth() {
		return month;
	}
	/**
	 * @return the dayOfWeek
	 */
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	/**
	 * @return the numbers
	 */
	public CountWeek getNumbers() {
		return numbers;
	}
	/**
	 * @return the afterDay
	 */
	public int getAfterDay() {
		return afterDay;
	}
	
	/**
	 * @return the fullweek
	 */
	public boolean isFullWeek() {
		return fullweek;
	}

	@Override
	public int hashCode() {
		return Objects.hash(afterDay, dayOfWeek, month, numbers, fullweek);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArborDate other = (ArborDate) obj;
		return afterDay == other.afterDay && dayOfWeek == other.dayOfWeek && month == other.month
				&& numbers == other.numbers && fullweek == other.fullweek;
	}

	@Override
	public String toString() {
		return "ArborDate [month=" + month + ", dayOfWeek=" + dayOfWeek + ", numbers=" + numbers + ", afterDay="
				+ afterDay + ", fullweek=" + fullweek + "]";
	}


	public static void  main(String[] args) {
		ArborDate a = new ArborDate.Builder(Month.APRIL,DayOfWeek.FRIDAY).countWeek(CountWeek.SECOND).build();
		System.out.println(a);
	}	

}
