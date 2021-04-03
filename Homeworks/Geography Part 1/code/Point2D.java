// A drop-in replacement for javafx.geometry.Point2D
// Remove the import javafx.geometry.Point2D from Model.java

package code;

/**
 * A 2D geometric point that usually represents the x, y coordinates.
 * It can also represent a relative magnitude vector's x, y magnitudes.
 * @since JavaFX 2.0
 * Modified by Alphonce on 10/2/2017 for AutoLab submission.
 */
public class Point2D {

    /**
     * The x coordinate.
     *
     * @defaultValue 0.0
     */
    private double x;

    /**
     * The x coordinate.
     * @return the x coordinate
     */
    public final double getX() {
        return x;
    }

    /**
     * The y coordinate.
     *
     * @defaultValue 0.0
     */
    private double y;

    /**
     * The y coordinate.
     * @return the y coordinate
     */
    public final double getY() {
        return y;
    }

    /**
     * Creates a new instance of {@code Point2D}.
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Computes the distance between this point and the specified {@code point}.
     *
     * @param point the other point
     * @return the distance between this point and the specified {@code point}.
     * @throws NullPointerException if the specified {@code point} is null
     */
    public double distance(Point2D point) {
        double a = getX() - point.getX();
		double b = getY() - point.getY();
		return Math.sqrt(a * a + b * b);
    }

	@Override
	public String toString() {
		return "Point2D( latitude: "+this.x+", longitude: "+this.y+" )";
	}
}
