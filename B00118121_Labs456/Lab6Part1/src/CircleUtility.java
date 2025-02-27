/**
 * Utility class to calculate the circumference of a circle.
 */
public class CircleUtility {
    // Defines a constant for PI
    public static final double PI = 3.14159;

    /**
     * Calculate the circumference of a circle based on the given radius.
     * @param radius The radius of the circle
     * @return The circumference of the circle
     */
    public static double calculateCircumference(double radius) {
        return 2 * PI * radius;
    }
}
