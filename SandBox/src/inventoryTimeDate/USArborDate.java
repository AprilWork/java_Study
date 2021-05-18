/**
 * 
 */
package inventoryTimeDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.EnumMap;

/**
 * @author Irene Mitin
 * @param <V>
 * @param <K>
 *
 */
public class USArborDate implements CelebrateDate {
	LocalDate currentDate = LocalDate.now();
	EnumMap<StatesUS, LocalDate> states;
	
	public USArborDate() {
		states = new EnumMap<StatesUS, LocalDate> (StatesUS.class);
		
		states.put(StatesUS.Alabama, findDay(2021, Month.APRIL, DayOfWeek.FRIDAY, CountWeek.FIRST, 0));
		states.put(StatesUS.Alabama, findDay(2021, Month.APRIL, DayOfWeek.FRIDAY, CountWeek.SECOND, 0));
	}
			
	public static void main(String[] args) {
		USArborDate s = new USArborDate();
	
		System.out.println(" " + s.findDay(2021, Month.MAY, DayOfWeek.MONDAY, CountWeek.THIRD, 0));
		LocalDate l = LocalDate.now();
		System.out.println(s.states.size());
		System.out.println(s.startFullWeek(2021, Month.MAY, CountWeek.SECOND));

	}
}