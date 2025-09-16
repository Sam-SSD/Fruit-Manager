import controller.FruitController;

/**
 * The main entry point for the Fruit Management System
 * Directly launches the controller without unnecessary intermediate layers
 */
public class Main {

    public static void main(String[] args) {
        // Direct instantiation and execution - no need for intermediate launcher
        FruitController controller = new FruitController();
        controller.run();
    }
}
