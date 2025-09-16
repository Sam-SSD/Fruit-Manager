package factory;


import model.Fruit;

/**
 * Factory class for creating pre-configured example fruits
 */
public class FruitFactory {
    
    /**
     * Creates pre-configured example fruits for testing and demos
     * @return Array of example fruits
     */
    public static Fruit[] createExampleFruits() {
        return new Fruit[] {
            new Fruit("Apple", 150, "Red", true, 52),
            new Fruit("Avocado", 200, "Green", true, 160),
            new Fruit("Strawberry", 15, "Red", true, 32),
            new Fruit("Watermelon", 4000, "Green", true, 30),
            new Fruit("Kiwi", 70, "Brown", true, 61)
        };
    }
}
