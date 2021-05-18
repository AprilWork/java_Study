/**
 * 
 */
package InterfacesStudy;

/**
 * @author Irene Mitin
 *
 */
interface sizable extends increasable<Shape> {
	
	public default void print() {
		System.out.println("sizeble draw method");
	}
	
	public static void margin() {
		System.out.println("margin");
	}
}
