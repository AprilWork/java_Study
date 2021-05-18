/**
 * 
 */
package inventoryTimeDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author Irene Mitin
 *
 */
public interface arboring extends CelebrateDate{

	LocalDate getArborDate(StatesUS state);
	boolean isArborDay(LocalDate date);
}
