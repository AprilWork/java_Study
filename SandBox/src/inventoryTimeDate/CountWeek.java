/**
 * 
 */
package inventoryTimeDate;

/**
 * @author Irene Mitin
 *
 */
public enum CountWeek {
	ANY,
	FIRST,
	SECOND,
	THIRD,
	LAST;
	
	private static final CountWeek[] ENUMS = CountWeek.values();
	
    public static CountWeek of(int count) {
        if (count < 1 || count > 5) {
            //throw new DateTimeException("Invalid value for MonthOfYear: " + month);
        }
        return ENUMS[count - 1];
    }
}
