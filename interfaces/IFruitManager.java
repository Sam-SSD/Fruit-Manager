package interfaces;

import model.Fruit;
import service.FruitManager;

import java.util.List;

/**
 * Interface for fruit management operations
 * Provides abstraction for different implementations of fruit storage and management
 */
public interface IFruitManager {
    
    /**
     * Adds a fruit to the collection
     * @param fruit Fruit to add
     */
    void addFruit(Fruit fruit);
    
    /**
     * Checks if a fruit with the given name already exists
     * @param name Name to search for
     * @return true if fruit exists, false otherwise
     */
    boolean fruitExists(String name);
    
    /**
     * Gets all fruits in the collection
     * @return List of all fruits
     */
    List<Fruit> getAllFruits();
    
    /**
     * Checks if the collection is empty
     * @return true if empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Gets the total number of fruits
     * @return Number of fruits in collection
     */
    int getSize();
    
    /**
     * Searches for a fruit by name (case-insensitive partial match)
     * @param name Name to search for
     * @return First matching fruit or null if not found
     */
    Fruit searchFruitByName(String name);
    
    /**
     * Searches for a fruit by exact name match
     * @param name Exact name to search for
     * @return Matching fruit or null if not found
     */
    Fruit searchFruitByExactName(String name);
    
    /**
     * Gets array of all fruit names
     * @return Array of fruit names
     */
    String[] getFruitNames();
    
    /**
     * Removes a fruit by name
     * @param name Name of fruit to remove
     * @return true if fruit was removed, false if not found
     */
    boolean removeFruitByName(String name);
    
    /**
     * Calculates statistics about the fruit collection
     * @return FruitStatistics object containing calculated stats
     */
    FruitManager.FruitStatistics calculateStatistics();
    
    /**
     * Updates a fruit's attributes
     * @param oldName Original name of the fruit to update
     * @param newName New name (can be same as old)
     * @param newWeight New weight
     * @param newColor New color
     * @param newIsEdible New edible status
     * @param newCaloriesPer100g New calories per 100g
     * @return true if fruit was updated successfully, false if not found
     */
    boolean updateFruit(String oldName, String newName, int newWeight,
                       String newColor, boolean newIsEdible, int newCaloriesPer100g);
    
    /**
     * Updates only specific attributes of a fruit
     * @param fruitName Name of the fruit to update
     * @param attribute Attribute to update ("name", "weight", "color", "edible", "calories")
     * @param newValue New value for the attribute
     * @return true if updated successfully, false otherwise
     */
    boolean updateFruitAttribute(String fruitName, String attribute, Object newValue);
}
