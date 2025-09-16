package service;

import interfaces.IFruitManager;
import model.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of fruits and provides business logic operations
 */
public class FruitManager implements IFruitManager {
    private final ArrayList<Fruit> fruits;

    public FruitManager() {
        this.fruits = new ArrayList<>();
    }

    /**
     * Adds a fruit to the collection
     *
     * @param fruit Fruit to add
     */
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    /**
     * Checks if a fruit with the given name already exists
     *
     * @param name Name to search for
     * @return true if fruit exists, false otherwise
     */
    public boolean fruitExists(String name) {
        return fruits.stream().anyMatch(f -> f.getName().equalsIgnoreCase(name));
    }

    /**
     * Gets all fruits in the collection
     *
     * @return List of all fruits
     */
    public List<Fruit> getAllFruits() {
        return new ArrayList<>(fruits);
    }

    /**
     * Checks if the collection is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return fruits.isEmpty();
    }

    /**
     * Gets the total number of fruits
     *
     * @return Number of fruits in collection
     */
    public int getSize() {
        return fruits.size();
    }

    /**
     * Searches for a fruit by name (case-insensitive partial match)
     *
     * @param name Name to search for
     * @return First matching fruit or null if not found
     */
    public Fruit searchFruitByName(String name) {
        return fruits.stream()
                .filter(f -> f.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Searches for a fruit by exact name match
     *
     * @param name Exact name to search for
     * @return Matching fruit or null if not found
     */
    public Fruit searchFruitByExactName(String name) {
        return fruits.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets array of all fruit names
     *
     * @return Array of fruit names
     */
    public String[] getFruitNames() {
        return fruits.stream()
                .map(Fruit::getName)
                .toArray(String[]::new);
    }

    /**
     * Removes a fruit by name
     *
     * @param name Name of fruit to remove
     * @return true if fruit was removed, false if not found
     */
    public boolean removeFruitByName(String name) {
        return fruits.removeIf(f -> f.getName().equals(name));
    }

    /**
     * Calculates statistics about the fruit collection
     *
     * @return FruitStatistics object containing calculated stats
     */
    public FruitStatistics calculateStatistics() {
        if (fruits.isEmpty()) {
            return new FruitStatistics(0, 0, 0, 0.0, 0.0, 0.0, null);
        }

        int healthy = 0, edible = 0;
        double totalCaloriesPer100g = 0;
        Fruit heaviest = fruits.getFirst();

        for (Fruit fruit : fruits) {
            if (fruit.isHealthy()) healthy++;
            if (fruit.canBeEaten()) edible++;
            totalCaloriesPer100g += fruit.getCaloriesPer100g(); // Suma calorías por 100g para promedio
            if (fruit.isHeavierThan(heaviest)) heaviest = fruit;
        }

        double healthyPercentage = (double) healthy / fruits.size() * 100;
        double ediblePercentage = (double) edible / fruits.size() * 100;
        double averageCaloriesPer100g = totalCaloriesPer100g / fruits.size(); // Promedio de calorías por 100g

        return new FruitStatistics(fruits.size(), healthy, edible,
                healthyPercentage, ediblePercentage,
                averageCaloriesPer100g, heaviest);
    }

    /**
     * Updates a fruit's attributes
     *
     * @param oldName Original name of the fruit to update
     * @param newName New name (can be same as old)
     * @param newWeight New weight
     * @param newColor New color
     * @param newIsEdible New edible status
     * @param newCaloriesPer100g New calories per 100g
     * @return true if fruit was updated successfully, false if not found
     */
    public boolean updateFruit(String oldName, String newName, int newWeight,
                              String newColor, boolean newIsEdible, int newCaloriesPer100g) {
        Fruit fruit = searchFruitByExactName(oldName);
        if (fruit == null) {
            return false;
        }

        // Check if new name conflicts with existing fruit (only if name is changing)
        if (!oldName.equals(newName) && fruitExists(newName)) {
            return false;
        }

        fruit.setName(newName);
        fruit.setWeight(newWeight);
        fruit.setColor(newColor);
        fruit.setEdible(newIsEdible);
        fruit.setCaloriesPer100g(newCaloriesPer100g);

        return true;
    }

    /**
     * Updates only specific attributes of a fruit
     *
     * @param fruitName Name of the fruit to update
     * @param attribute Attribute to update ("name", "weight", "color", "edible", "calories")
     * @param newValue New value for the attribute
     * @return true if updated successfully, false otherwise
     */
    public boolean updateFruitAttribute(String fruitName, String attribute, Object newValue) {
        Fruit fruit = searchFruitByExactName(fruitName);
        if (fruit == null) {
            return false;
        }

        switch (attribute.toLowerCase()) {
            case "name":
                String newName = (String) newValue;
                if (!fruitName.equals(newName) && fruitExists(newName)) {
                    return false; // Name conflict
                }
                fruit.setName(newName);
                break;
            case "weight":
                fruit.setWeight((Integer) newValue);
                break;
            case "color":
                fruit.setColor((String) newValue);
                break;
            case "edible":
                fruit.setEdible((Boolean) newValue);
                break;
            case "calories":
                fruit.setCaloriesPer100g((Integer) newValue);
                break;
            default:
                return false;
        }

        return true;
    }

    /**
     * Inner class to hold fruit statistics
     */
    public static class FruitStatistics {
        private final int totalFruits;
        private final int healthyFruits;
        private final int edibleFruits;
        private final double healthyPercentage;
        private final double ediblePercentage;
        private final double averageCaloriesPer100g;
        private final Fruit heaviestFruit;

        public FruitStatistics(int totalFruits, int healthyFruits, int edibleFruits,
                               double healthyPercentage, double ediblePercentage,
                               double averageCaloriesPer100g, Fruit heaviestFruit) {
            this.totalFruits = totalFruits;
            this.healthyFruits = healthyFruits;
            this.edibleFruits = edibleFruits;
            this.healthyPercentage = healthyPercentage;
            this.ediblePercentage = ediblePercentage;
            this.averageCaloriesPer100g = averageCaloriesPer100g;
            this.heaviestFruit = heaviestFruit;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("GENERAL STATISTICS\n\n");
            sb.append("Total fruits: ").append(totalFruits).append("\n");
            sb.append("Healthy fruits: ").append(healthyFruits)
                    .append(" (").append(String.format("%.1f", healthyPercentage)).append("%)\n");
            sb.append("Edible fruits: ").append(edibleFruits)
                    .append(" (").append(String.format("%.1f", ediblePercentage)).append("%)\n");
            if (heaviestFruit != null) {
                sb.append("Heaviest fruit: ").append(heaviestFruit.getName()).append("\n");
            }
            sb.append("Average calories per 100g: ").append(String.format("%.1f", averageCaloriesPer100g)).append("\n");
            return sb.toString();
        }
    }
}
