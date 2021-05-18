/**
 * 
 */
package InterfacesStudy;

/**
 * @author Irene Mitin
 *
 */
interface drawable {
	public void draw();
	public default void print() {
		System.out.println("drawable print method ");
	}
	default boolean isShape() {
		return (this instanceof Shape);
	}
	public default ShapeType getShape() {
		Shape new_name = null;
		if (this instanceof Shape) {
			new_name = (Shape) this;
			System.out.println("shapetype is " + new_name.shape.name());
		}
		return new_name.shape;
	}
}

