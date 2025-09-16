package constants;

/**
 * Contains application-wide constants for fruit management
 */
public final class FruitConstants {
    
    // Nutritional constants used by Fruit class
    public static final int HEALTHY_CALORIE_THRESHOLD = 60;
    public static final int MIN_WEIGHT_FOR_CONSUMPTION = 0;
    public static final double CALORIES_PER_100G_TO_GRAM_RATIO = 100.0;
    
    // Private constructor to prevent instantiation
    private FruitConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
