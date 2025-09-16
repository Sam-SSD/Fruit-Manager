package service;

import  constants.UIConstants;
import  interfaces.IUserInterface;

import javax.swing.*;

/**
 * Handles all user interface interactions using JOptionPane dialogs
 */
public class UserInterface implements IUserInterface {

    /**
     * Shows the welcome message to the user
     */
    public void showWelcome() {
        JOptionPane.showMessageDialog(null, UIConstants.WELCOME_MESSAGE, 
                                    UIConstants.WELCOME_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays the main menu and returns the selected option
     * @return Selected menu option (1-7) or 0 for exit, -1 for cancel
     */
    public int showMainMenu() {
        // Create a simple JList for vertical display
        JList<String> list = new JList<>(UIConstants.MAIN_MENU_OPTIONS);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        int result = JOptionPane.showConfirmDialog(
            null,
            new Object[]{UIConstants.MAIN_MENU_MESSAGE, new JScrollPane(list)},
            UIConstants.MAIN_MENU_TITLE,
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return -1;
        }

        int selection = list.getSelectedIndex();
        return selection == 7 ? 0 : selection + 1;
    }

    /**
     * Shows an attribute selection menu for updating fruits
     */
    public int showAttributeSelectionMenu() {
        // Create a simple JList for vertical display
        JList<String> list = new JList<>(UIConstants.UPDATE_MENU_OPTIONS);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        int result = JOptionPane.showConfirmDialog(
            null,
            new Object[]{UIConstants.UPDATE_MENU_MESSAGE, new JScrollPane(list)},
            UIConstants.UPDATE_MENU_TITLE,
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return -1;
        }

        return list.getSelectedIndex();
    }

    /**
     * Shows selection dialog for choosing items from a list
     */
    public int showSelectionDialog(String[] items, String title, String message) {
        return JOptionPane.showOptionDialog(
            null, message, title,
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, items, items[0]
        );
    }

    /**
     * Requests a positive number from the user
     */
    public int requestPositiveNumber(String message, String title) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
                if (input == null) throw new RuntimeException(UIConstants.OPERATION_CANCELLED);
                int number = Integer.parseInt(input);
                if (number <= 0) {
                    showErrorMessage(UIConstants.INVALID_NUMBER_MESSAGE, UIConstants.ERROR_TITLE);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                showErrorMessage(UIConstants.INVALID_FORMAT_MESSAGE, UIConstants.ERROR_TITLE);
            }
        }
    }

    /**
     * Requests text input from the user
     */
    public String requestText(String message, String title) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
            if (input == null) return null;
            if (input.trim().isEmpty()) {
                showErrorMessage(UIConstants.REQUIRED_FIELD_MESSAGE, UIConstants.ERROR_TITLE);
                continue;
            }
            return input.trim();
        }
    }

    /**
     * Requests a yes/no response from the user
     */
    public boolean requestBoolean(String message, String title) {
        int response = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }

    /**
     * Shows an information message to the user
     */
    public void showInfoMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows an error message to the user
     */
    public void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows a confirmation dialog
     */
    public boolean showConfirmation(String message, String title) {
        int response = JOptionPane.showConfirmDialog(null, message, title,
                                                   JOptionPane.YES_NO_OPTION,
                                                   JOptionPane.WARNING_MESSAGE);
        return response == JOptionPane.YES_OPTION;
    }
}



