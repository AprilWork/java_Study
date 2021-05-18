package inventoryTimeDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.EnumMap;

public class USArbor implements CelebrateDate {
	EnumMap<StatesUS, ArborDate> states;
	

	
	public USArbor() {
		// TODO Auto-generated constructor stub
		states = new EnumMap<StatesUS, ArborDate> (StatesUS.class);
	
		//fill();
	}
	
/*	
	public static ArborDate parseFromFile() {
		ArborDate a;
		return a;
	}
*/	
	
/*	
	private final void fill() {
		ArborDate a;
		
		a = new ArborDate(Month.JANUARY, DayOfWeek.FRIDAY, CountWeek.THIRD, 0, false);
		states.put(StatesUS.Florida, a);
		
		a = new ArborDate(Month.JANUARY, DayOfWeek.FRIDAY, CountWeek.THIRD, 0, false);
		states.put(StatesUS.Louisiana, a);
		
		a = new ArborDate(Month.FEBRUARY, DayOfWeek.FRIDAY, CountWeek.THIRD, 0, false);
		states.put(StatesUS.Georgia, a);
		
		a = new ArborDate(Month.FEBRUARY, DayOfWeek.FRIDAY, CountWeek.SECOND, 0, false);
		states.put(StatesUS.Mississippi, a);
		
		a = new ArborDate(Month.MARCH, DayOfWeek.MONDAY, CountWeek.THIRD, 0, false);
		states.put(StatesUS.Arkansas, a);
		
		a = new ArborDate(Month.MARCH, DayOfWeek.FRIDAY, CountWeek.SECOND, 0, false);
		states.put(StatesUS.New_Mexico, a);
		
		a = new ArborDate(Month.MARCH, DayOfWeek.FRIDAY, CountWeek.ANY, 15, false);
		states.put(StatesUS.North_Carolina, a);
		
		a = new ArborDate(Month.MARCH, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Tennessee, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Arizona, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.THIRD, 0, false);
		states.put(StatesUS.Colorado, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Connecticut, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Delaware, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.District_of_Columbia, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Idaho, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Illinois, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Indiana, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Iowa, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Kansas, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Kentucky, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.WEDNESDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Maryland, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Massachusetts, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Michigan, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Minnesota, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Missouri, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Montana, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Nebraska, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Nevada, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.New_Hampshire, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.New_Jersey, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.New_York, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Ohio, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Pennsylvania, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Rhode_Island, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.District_of_Columbia, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.South_Dakota, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Texas, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Utah, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.SECOND, 0, false);
		states.put(StatesUS.Virginia, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.WEDNESDAY, CountWeek.SECOND, 0, false);
		states.put(StatesUS.Washington, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.SECOND, 0, false);
		states.put(StatesUS.West_Virginia, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Wisconsin, a);
		
		a = new ArborDate(Month.APRIL, DayOfWeek.MONDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Wyoming, a);
		
		a = new ArborDate(Month.MAY, DayOfWeek.MONDAY, CountWeek.THIRD, 0, false);
		states.put(StatesUS.Alaska, a);
		
		a = new ArborDate(Month.MAY, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.North_Dakota, a);
		
		a = new ArborDate(Month.MAY, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Vermont, a);
		
		a = new ArborDate(Month.SEPTEMBER, DayOfWeek.FRIDAY, CountWeek.LAST, 0, false);
		states.put(StatesUS.Virgin_Islands, a);
		
		a = new ArborDate(Month.NOVEMBER, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Guam, a);
		
		a = new ArborDate(Month.NOVEMBER, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.Hawaii, a);
		
		a = new ArborDate(Month.DECEMBER, DayOfWeek.FRIDAY, CountWeek.FIRST, 0, false);
		states.put(StatesUS.South_Carolina, a);

	}
*/
	
	public static void main(String[] args) {
		USArbor u = new USArbor();
		//System.out.println(u.states.toString());
		//System.out.println(StatesUS.South_Carolina + " " + u.states.get(StatesUS.South_Carolina));
		/*
		System.out.println(StatesUS.South_Carolina + " = " 
				+ u.states.get(StatesUS.South_Carolina)
				+ " " + u.findDay(2021, u.states.get(StatesUS.South_Carolina)));
		for (StatesUS state: StatesUS.values()) {
			System.out.println("state " + state + " " + state.abbrev());
		}
		*/
	}



}
