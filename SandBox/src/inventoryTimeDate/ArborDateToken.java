package inventoryTimeDate;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArborDateToken {
	protected final String element;
	protected static boolean openTag = false;
	protected static StatesUS statesUS;
	/**
	 * @return the statesUS
	 */
	protected static StatesUS getStatesUS() {
		return statesUS;
	}

	protected static ArborDate arbor;
	
	public ArborDateToken( String element, boolean isOpenTag, ArborDate arbor) {
		// TODO Auto-generated constructor stub
        this.element = element.toLowerCase();
        openTag = isOpenTag;
        this.arbor = arbor;
	}

	/**
	 * @return the element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * @return the openTag
	 */
	public boolean isOpenTag() {
		return openTag;
	}
	
	protected static Month getMonth(String element) {	
		String monthString = element.toUpperCase();
    	int month = -1;
    	for (Month m : Month.values()) {
    		month = monthString.indexOf(m.toString());
    		if (month > -1) {
    			return m;
    		}
    	}
    	return null;
	}
	
	protected static int getState(String element) {
		String stateString = element;
		int state = -1;
		
		for (StatesUS s : StatesUS.values()) {
			state = stateString.indexOf(s.toString());
			if (state > -1) {
				statesUS = StatesUS.of(state);
				setTag(true);
				return state;
			}
		}
		return state;
	}
	
	protected static CountWeek getCountWeek(String element) {
		int count = -1;
		String countWeekString = element.toUpperCase();
		for (CountWeek c : CountWeek.values()) {
			count = countWeekString.indexOf(c.toString().toUpperCase());
			if (count > -1) {
				return c;
			}
		}
		return null;
	}
	
	protected static DayOfWeek getDayOfWeek(String element) {
		int count = -1;
		String countDayOfWeekString = element.toUpperCase();
		for (DayOfWeek c : DayOfWeek.values()) {
			count = countDayOfWeekString.indexOf(c.toString().toUpperCase());
			if (count > -1) {
				return c;
			}
		}
		return null;
	}
	
	protected static boolean getFullWeek(String element) {
		//TODO find  digits
		String fullstr = element;	
		if (fullstr.contains("full week") || fullstr.contains("-")) {
			return true;
		}		
		return false;
	}
	
	protected static int getStartDay(String element) {
		String fullstr = element;
		String REGEX;
		if (getFullWeek(element)) {
			REGEX = "[0-9]-";
		} else {
			REGEX = "[0-9]";
		}
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(fullstr);
		int number = 0;
		StringBuilder bd = new StringBuilder("");
		
		while (matcher.find()) {
			bd.append(fullstr.charAt(matcher.start()));
			number = Integer.parseInt(bd.toString());
		}
		
		
		return number;
	}
	
	protected static boolean setTag(boolean  val) {
		return openTag = val;
	}
	
	protected static boolean isArborString(String element) {
		int state = getState(element);
		Month month = getMonth(element);
		DayOfWeek day = getDayOfWeek(element);
		CountWeek week = getCountWeek(element);
		boolean fullweek = getFullWeek(element);
		int number = getStartDay(element);
		if (state > -1) {
			setTag(false);
			arbor = new ArborDate.Builder(month, day).countWeek(week).afterDay(number).fullWeek(fullweek).build();
			return true;
		}
		return false;
	}
	
	protected static ArborDate getArborDate() {
		return arbor;
	}
	
    protected static ArborDate nextState(String element) {


        return arbor;
    }    
	
}
