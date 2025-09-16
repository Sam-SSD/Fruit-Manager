package constants;

/**
 * Contains UI-related messages and text constants
 */
public final class UIConstants {
    
    // Welcome messages
    public static final String WELCOME_TITLE = "Welcome";
    public static final String WELCOME_MESSAGE = "WELCOME TO THE FRUIT SYSTEM\n\n" +
            "This program allows you to manage a collection of fruits\n" +
            "and learn about their nutritional properties.\n\n" +
            "Use the buttons to navigate through the menu!";
    
    // Menu titles and messages
    public static final String MAIN_MENU_TITLE = "Main Menu";
    public static final String MAIN_MENU_MESSAGE = "FRUIT MANAGEMENT SYSTEM\n\nSelect an option:";
    public static final String UPDATE_MENU_TITLE = "Update Options";
    public static final String UPDATE_MENU_MESSAGE = "UPDATE FRUIT\n\nSelect what you want to update:";
    
    // Common button labels
    public static final String[] MAIN_MENU_OPTIONS = {
            "Add fruits",
            "Show all fruits", 
            "Search fruit by name",
            "Compare two fruits",
            "Show statistics",
            "Update fruit",
            "Delete fruit",
            "Exit"
    };

    public static final String[] UPDATE_MENU_OPTIONS = {
            "Update all attributes",
            "Update name only",
            "Update weight only", 
            "Update color only",
            "Update edible status only",
            "Update calories per 100g only"
    };

    // Error messages and titles
    public static final String ERROR_TITLE = "Error";
    
    // Common messages
    public static final String OPERATION_CANCELLED = "Operation cancelled";
    public static final String INVALID_NUMBER_MESSAGE = "Please enter a number greater than 0.";
    public static final String INVALID_FORMAT_MESSAGE = "Please enter a valid number.";
    public static final String REQUIRED_FIELD_MESSAGE = "This field cannot be empty.";    // Private constructor to prevent instantiation
    private UIConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
