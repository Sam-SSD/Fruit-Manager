package model;

import constants.FruitConstants;

public class Fruit {
    // Constants
    private static final int HEALTHY_CALORIE_THRESHOLD = FruitConstants.HEALTHY_CALORIE_THRESHOLD;

    private String name;
    private String color;
    private int weight;
    private int caloriesPer100g;
    private boolean isEdible;

    public Fruit(String name, int weight, String color, boolean isEdible, int caloriesPer100g) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.isEdible = isEdible;
        this.caloriesPer100g = caloriesPer100g;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public int getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public boolean isEdible() {
        return isEdible;
    }

    // Setters for updating
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCaloriesPer100g(int caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public void setEdible(boolean edible) {
        this.isEdible = edible;
    }

    // Business logic methods
    public String getInfo() {
        return String.format("Name: %s, Color: %s, Weight: %dg, Calories per 100g: %d, Total calories: %.1f, Edible: %s",
                           name, color, weight, caloriesPer100g, getTotalCalories(), isEdible ? "Yes" : "No");
    }

    public double getTotalCalories() {
        return (double) (caloriesPer100g * weight) / FruitConstants.CALORIES_PER_100G_TO_GRAM_RATIO;
    }

    public double getCaloriesPerGram() {
        return (double) caloriesPer100g / FruitConstants.CALORIES_PER_100G_TO_GRAM_RATIO;
    }

    public boolean isHealthy() {
        return caloriesPer100g < HEALTHY_CALORIE_THRESHOLD;
    }

    public boolean isHeavierThan(Fruit other) {
        return this.weight > other.weight;
    }

    public boolean canBeEaten() {
        return isEdible && weight > FruitConstants.MIN_WEIGHT_FOR_CONSUMPTION;
    }
}
