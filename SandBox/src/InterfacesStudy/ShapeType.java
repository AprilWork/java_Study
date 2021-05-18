/**
 * 
 */
package InterfacesStudy;

/**
 * @author Irene Mitin
 *
 */
enum ShapeType {
	POLYGON, RECTANGLE, CIRCLE, TRYANGLE;
	
	public static void printList() {
		for(ShapeType shape : ShapeType.values()) {
			System.out.println(shape);
		}
	}
}
