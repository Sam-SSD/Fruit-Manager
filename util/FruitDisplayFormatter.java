package util;

import model.Fruit;

import java.util.List;

/**
 * Handles formatting of fruit data for display purposes
 */
public class FruitDisplayFormatter {

    /**
     * Formats a single fruit for detailed display
     */
    public static String formatFruitDetails(Fruit fruit) {
        StringBuilder sb = new StringBuilder();
        sb.append(fruit.getInfo()).append("\n\n");
        sb.append("Additional information:\n");
        sb.append("• Calories per gram: ").append(String.format("%.4f", fruit.getCaloriesPerGram())).append("\n");
        sb.append("• Is healthy?: ").append(fruit.isHealthy() ? "Yes" : "No").append("\n");
        sb.append("• Can be consumed?: ").append(fruit.canBeEaten() ? "Yes" : "No").append("\n");
        return sb.toString();
    }

    /**
     * Formats all fruits in a list for display
     */
    public static String formatAllFruits(List<Fruit> fruits) {
        StringBuilder sb = new StringBuilder("COMPLETE FRUIT LIST\n\n");

        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            sb.append("FRUIT ").append(i + 1).append(":\n");
            sb.append(fruit.getInfo()).append("\n");
            sb.append("Calories per gram: ").append(String.format("%.4f", fruit.getCaloriesPerGram())).append("\n");
            sb.append("Is healthy?: ").append(fruit.isHealthy() ? "Yes" : "No").append("\n");
            sb.append("Can be consumed?: ").append(fruit.canBeEaten() ? "Yes" : "No").append("\n");
            sb.append("-----------------------------\n");
        }

        return sb.toString();
    }

    /**
     * Formats comparison between two fruits
     */
    public static String formatFruitComparison(Fruit f1, Fruit f2, String name1, String name2) {
        StringBuilder sb = new StringBuilder("FRUIT COMPARISON\n\n");
        sb.append(name1).append(" vs ").append(name2).append("\n\n");

        // Weight comparison
        sb.append("Weight: ");
        if (f1.isHeavierThan(f2)) {
            sb.append(name1).append(" is heavier");
        } else if (f2.isHeavierThan(f1)) {
            sb.append(name2).append(" is heavier");
        } else {
            sb.append("They have the same weight");
        }
        sb.append("\n");

        // Health comparison
        sb.append("Healthy: ");
        if (f1.isHealthy() && f2.isHealthy()) {
            sb.append("Both are healthy");
        } else if (f1.isHealthy()) {
            sb.append(name1).append(" is healthy");
        } else if (f2.isHealthy()) {
            sb.append(name2).append(" is healthy");
        } else {
            sb.append("Neither is healthy");
        }
        sb.append("\n");

        // Edible comparison
        sb.append("Edible: ");
        if (f1.canBeEaten() && f2.canBeEaten()) {
            sb.append("Both are edible");
        } else if (f1.canBeEaten()) {
            sb.append("Only ").append(name1).append(" is edible");
        } else if (f2.canBeEaten()) {
            sb.append("Only ").append(name2).append(" is edible");
        } else {
            sb.append("Neither is edible");
        }

        return sb.toString();
    }
}


