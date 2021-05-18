package inventoryTimeDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public interface CelebrateDate {

	public default LocalDate startFullWeek(int year, Month month, CountWeek numbers) {
		LocalDate first = LocalDate.of(year, month, 1);
		//DayOfWeek day = DayOfWeek.MONDAY;
		Month m;
		LocalDate d = first;
		int length = first.lengthOfMonth();
		int counter = 0;
		for (int i = 0; i < length; i++) {
			d = first.plusDays(i);
			m = d.getMonth();
			if (m.equals(month) && d.getDayOfWeek().equals(DayOfWeek.MONDAY) && d.plusDays(6).getMonth().equals(month) ){
				counter++;
				//System.out.println(counter + " " +d);
				if (numbers.ordinal() == counter) {
					//System.out.println("get!");
					return d;
				}
			}	
			
		}
		return null;
	}
	

	public default LocalDate findDay(int year, ArborDate date) {
		return findDay(year, date.getMonth(), date.getDayOfWeek(), date.getNumbers(), date.getAfterDay());
	}
	
	public default LocalDate findDay(int year, Month month, DayOfWeek dayOfWeek, CountWeek numbers, int afterDay) {
		LocalDate first = LocalDate.of(year,month,1);
		LocalDate d = first;
		DayOfWeek day;
		Month m;
		int counter = 0;
		LocalDate find = null;
		
		for (int i = 0; i < first.lengthOfMonth(); i++) {
			d = first.plusDays(i);
			day = d.getDayOfWeek();
			m = d.getMonth();
			if ((m == month) && (day == dayOfWeek) ){
				counter++;
				if ((numbers == CountWeek.ANY) && (i >= afterDay)) {
					return d;
				};
				if ((numbers.ordinal() == counter) || (numbers == CountWeek.LAST)) {
					find = d;
				};
			}
		}
		
		return find;
	}

}