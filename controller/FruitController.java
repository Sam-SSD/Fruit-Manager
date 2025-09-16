package controller;

import factory.FruitFactory;
import interfaces.IFruitManager;
import interfaces.IUserInterface;
import model.Fruit;
import service.FruitManager;
import service.UserInterface;
import util.FruitDisplayFormatter;

public class FruitController {
    private final IFruitManager fruitManager;
    private final IUserInterface ui;

    public FruitController() {
        this.fruitManager = new FruitManager();
        this.ui = new UserInterface();
        initializeExampleFruits();
    }

    /**
     * Initializes the application with some example fruits
     */
    private void initializeExampleFruits() {
        // Use factory to create example fruits
        Fruit[] exampleFruits = FruitFactory.createExampleFruits();
        
        // Add example fruits to the manager
        for (Fruit fruit : exampleFruits) {
            fruitManager.addFruit(fruit);
        }
    }

    /**
     * Starts the fruit management application
     */
    public void run() {
        ui.showWelcome();

        boolean continueProgram = true;
        while (continueProgram) {
            int option = ui.showMainMenu();

            switch (option) {
                case 1 -> addFruits();
                case 2 -> showAllFruits();
                case 3 -> searchFruitByName();
                case 4 -> compareFruits();
                case 5 -> showStatistics();
                case 6 -> updateFruit();
                case 7 -> deleteFruit();
                case 0 -> {
                    continueProgram = false;
                    ui.showInfoMessage("Thank you for using the fruit system!", "Goodbye");
                }
                default -> continueProgram = false;
            }
        }
    }

    /**
     * Handles adding new fruits to the collection
     */
    private void addFruits() {
        try {
            int quantity = ui.requestPositiveNumber("How many fruits do you want to add?", "Number of fruits");

            for (int i = 0; i < quantity; i++) {
                ui.showInfoMessage("Entering data for fruit " + (i + 1) + " of " + quantity, "Progress");

                Fruit newFruit = createFruitFromUserInput();
                if (newFruit == null) return;

                fruitManager.addFruit(newFruit);
                ui.showInfoMessage("Fruit '" + newFruit.getName() + "' added successfully!", "Success");
            }
        } catch (Exception e) {
            ui.showErrorMessage("Error adding fruits: " + e.getMessage(), "Error");
        }
    }

    /**
     * Creates a new Fruit object from user input
     */
    private Fruit createFruitFromUserInput() {
        String name = ui.requestText("Fruit name:", "Fruit name");
        if (name == null) return null;

        if (fruitManager.fruitExists(name)) {
            boolean addAnyway = ui.requestBoolean(
                    "A fruit with the name '" + name + "' already exists. Do you want to add it anyway?",
                    "Duplicate fruit"
            );
            if (!addAnyway) return null;
        }

        int weight = ui.requestPositiveNumber("Total weight in grams of '" + name + "':", "Total weight");
        String color = ui.requestText("Color of '" + name + "':", "Color");
        if (color == null) return null;

        boolean isEdible = ui.requestBoolean("Is the fruit '" + name + "' edible?", "Edible");
        int caloriesPer100g = ui.requestPositiveNumber("Calories per 100 grams of '" + name + "':", "Calories per 100g");

        return new Fruit(name, weight, color, isEdible, caloriesPer100g);
    }

    /**
     * Shows all fruits in the collection with improved display options
     */
    private void showAllFruits() {
        if (fruitManager.isEmpty()) {
            ui.showInfoMessage("No fruits registered. Add some first!", "No fruits");
            return;
        }

        String formattedList = FruitDisplayFormatter.formatAllFruits(fruitManager.getAllFruits());
        ui.showInfoMessage(formattedList, "All Fruits");
    }

    /**
     * Searches for a fruit by name
     */
    private void searchFruitByName() {
        if (fruitManager.isEmpty()) {
            ui.showInfoMessage("No fruits registered.", "No fruits");
            return;
        }

        String name = ui.requestText("Enter the name of the fruit to search:", "Search fruit");
        if (name == null) return;

        Fruit fruit = fruitManager.searchFruitByName(name);
        if (fruit != null) {
            String formattedFruit = "FRUIT FOUND\n\n" + FruitDisplayFormatter.formatFruitDetails(fruit);
            ui.showInfoMessage(formattedFruit, "Search result");
        } else {
            ui.showInfoMessage("No fruit found with the name '" + name + "'.", "No results");
        }
    }

    /**
     * Compares two fruits
     */
    private void compareFruits() {
        if (fruitManager.getSize() < 2) {
            ui.showInfoMessage("You need at least 2 fruits to make comparisons.", "Insufficient fruits");
            return;
        }

        String[] names = fruitManager.getFruitNames();

        int selection1 = ui.showSelectionDialog(names, "Select First Fruit",
                "FRUIT COMPARISON\n\nSelect the FIRST fruit to compare:");
        if (selection1 == -1) return;

        int selection2 = ui.showSelectionDialog(names, "Select Second Fruit",
                "FRUIT COMPARISON\n\nSelect the SECOND fruit to compare:");
        if (selection2 == -1) return;

        String fruit1Name = names[selection1];
        String fruit2Name = names[selection2];

        if (fruit1Name.equals(fruit2Name)) {
            boolean selectDifferent = ui.requestBoolean(
                    "You have selected the same fruit twice.\nDo you want to select different fruits?",
                    "Same fruit selected"
            );
            if (selectDifferent) {
                compareFruits();
            }
            return;
        }

        Fruit f1 = fruitManager.searchFruitByExactName(fruit1Name);
        Fruit f2 = fruitManager.searchFruitByExactName(fruit2Name);

        if (f1 != null && f2 != null) {
            String comparison = FruitDisplayFormatter.formatFruitComparison(f1, f2, fruit1Name, fruit2Name);
            ui.showInfoMessage(comparison, "Comparison result");
        }
    }

    /**
     * Shows statistics about the fruit collection
     */
    private void showStatistics() {
        if (fruitManager.isEmpty()) {
            ui.showInfoMessage("No fruits registered.", "No fruits");
            return;
        }

        FruitManager.FruitStatistics stats = fruitManager.calculateStatistics();
        ui.showInfoMessage(stats.toString(), "Statistics");
    }

    /**
     * Updates an existing fruit's information
     */
    private void updateFruit() {
        if (fruitManager.isEmpty()) {
            ui.showInfoMessage("No fruits to update.", "No fruits");
            return;
        }

        String[] names = fruitManager.getFruitNames();

        int selection = ui.showSelectionDialog(names, "Update Fruit",
                "UPDATE FRUIT\n\nSelect the fruit you want to update:");
        if (selection == -1) return;

        String fruitToUpdate = names[selection];
        Fruit existingFruit = fruitManager.searchFruitByExactName(fruitToUpdate);

        if (existingFruit == null) {
            ui.showErrorMessage("Fruit not found.", "Error");
            return;
        }

        // Show current fruit information
        String currentInfo = "CURRENT FRUIT INFORMATION:\n\n" +
                FruitDisplayFormatter.formatFruitDetails(existingFruit);
        ui.showInfoMessage(currentInfo, "Current information");

        // Ask what to update
        int updateOption = ui.showAttributeSelectionMenu();
        if (updateOption == -1) return;

        try {
            boolean updateSuccess = switch (updateOption) {
                case 0 -> // Update all attributes
                        updateAllAttributes(fruitToUpdate, existingFruit);
                case 1 -> // Update name only
                        updateSingleAttribute(fruitToUpdate, "name", existingFruit);
                case 2 -> // Update weight only
                        updateSingleAttribute(fruitToUpdate, "weight", existingFruit);
                case 3 -> // Update color only
                        updateSingleAttribute(fruitToUpdate, "color", existingFruit);
                case 4 -> // Update edible status only
                        updateSingleAttribute(fruitToUpdate, "edible", existingFruit);
                case 5 -> // Update calories only
                        updateSingleAttribute(fruitToUpdate, "calories", existingFruit);
                default -> false;
            };

            if (updateSuccess) {
                String updatedInfo = "UPDATED FRUIT INFORMATION:\n\n" +
                        FruitDisplayFormatter.formatFruitDetails(existingFruit);
                ui.showInfoMessage("Fruit updated successfully!\n\n" + updatedInfo, "Update successful");
            } else {
                ui.showErrorMessage("Failed to update fruit. The new name might already exist.", "Update failed");
            }

        } catch (Exception e) {
            ui.showErrorMessage("Error updating fruit: " + e.getMessage(), "Error");
        }
    }

    /**
     * Updates all attributes of a fruit
     */
    private boolean updateAllAttributes(String originalName, Fruit fruit) {
        String newName = ui.requestText("New name (current: " + fruit.getName() + "):", "Fruit name");
        if (newName == null) return false;

        int newWeight = ui.requestPositiveNumber("New weight in grams (current: " + fruit.getWeight() + "):", "Weight");

        String newColor = ui.requestText("New color (current: " + fruit.getColor() + "):", "Color");
        if (newColor == null) return false;

        boolean newIsEdible = ui.requestBoolean("Is the fruit edible? (current: " + (fruit.isEdible() ? "Yes" : "No") + ")", "Edible");

        int newCalories = ui.requestPositiveNumber("New calories per 100g (current: " + fruit.getCaloriesPer100g() + "):", "Calories");

        return fruitManager.updateFruit(originalName, newName, newWeight, newColor, newIsEdible, newCalories);
    }

    /**
     * Updates a single attribute of a fruit
     */
    private boolean updateSingleAttribute(String fruitName, String attribute, Fruit fruit) {
        Object newValue = null;

        switch (attribute) {
            case "name":
                newValue = ui.requestText("New name (current: " + fruit.getName() + "):", "Fruit name");
                if (newValue == null) return false;
                break;
            case "weight":
                newValue = ui.requestPositiveNumber("New weight in grams (current: " + fruit.getWeight() + "):", "Weight");
                break;
            case "color":
                newValue = ui.requestText("New color (current: " + fruit.getColor() + "):", "Color");
                if (newValue == null) return false;
                break;
            case "edible":
                newValue = ui.requestBoolean("Is the fruit edible? (current: " + (fruit.isEdible() ? "Yes" : "No") + ")", "Edible");
                break;
            case "calories":
                newValue = ui.requestPositiveNumber("New calories per 100g (current: " + fruit.getCaloriesPer100g() + "):", "Calories");
                break;
        }

        return fruitManager.updateFruitAttribute(fruitName, attribute, newValue);
    }

    /**
     * Deletes a fruit from the collection
     */
    private void deleteFruit() {
        if (fruitManager.isEmpty()) {
            ui.showInfoMessage("No fruits to delete.", "No fruits");
            return;
        }

        String[] names = fruitManager.getFruitNames();

        int selection = ui.showSelectionDialog(names, "Delete Fruit",
                "DELETE FRUIT\n\nSelect the fruit you want to delete:");
        if (selection == -1) return;

        String fruitToDelete = names[selection];

        boolean confirmed = ui.showConfirmation(
                "CONFIRMATION\n\nAre you sure you want to delete '" + fruitToDelete + "'?\n\nThis action cannot be undone.",
                "Confirm deletion"
        );

        if (confirmed) {
            if (fruitManager.removeFruitByName(fruitToDelete)) {
                ui.showInfoMessage("Fruit '" + fruitToDelete + "' deleted successfully!", "Deletion successful");
            } else {
                ui.showErrorMessage("Failed to delete fruit.", "Error");
            }
        }
    }
}
