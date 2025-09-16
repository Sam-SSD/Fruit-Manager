package interfaces;

/**
 * Interface for user interface operations
 * Provides abstraction for different UI implementations (Swing, Console, Web, etc.)
 */
public interface IUserInterface {
    
    /**
     * Shows the welcome message to the user
     */
    void showWelcome();
    
    /**
     * Displays the main menu and returns the selected option
     * @return Selected menu option (1-7) or 0 for exit, -1 for cancel
     */
    int showMainMenu();
    
    /**
     * Shows an attribute selection menu for updating fruits
     * @return Selected attribute index or -1 for cancel
     */
    int showAttributeSelectionMenu();
    
    /**
     * Shows selection dialog for choosing items from a list
     * @param items Array of items to choose from
     * @param title Dialog title
     * @param message Dialog message
     * @return Selected index or -1 for cancel
     */
    int showSelectionDialog(String[] items, String title, String message);
    
    /**
     * Requests a positive number from the user
     * @param message Message to display
     * @param title Dialog title
     * @return Positive number entered by user
     * @throws RuntimeException if operation is cancelled
     */
    int requestPositiveNumber(String message, String title);
    
    /**
     * Requests text input from the user
     * @param message Message to display
     * @param title Dialog title
     * @return Text entered by user or null if cancelled
     */
    String requestText(String message, String title);
    
    /**
     * Requests a yes/no response from the user
     * @param message Message to display
     * @param title Dialog title
     * @return true for yes, false for no
     */
    boolean requestBoolean(String message, String title);
    
    /**
     * Shows an information message to the user
     * @param message Message to display
     * @param title Dialog title
     */
    void showInfoMessage(String message, String title);
    
    /**
     * Shows an error message to the user
     * @param message Error message to display
     * @param title Dialog title
     */
    void showErrorMessage(String message, String title);
    
    /**
     * Shows a confirmation dialog
     * @param message Message to display
     * @param title Dialog title
     * @return true if confirmed, false otherwise
     */
    boolean showConfirmation(String message, String title);
}
