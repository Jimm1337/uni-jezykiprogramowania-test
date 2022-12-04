package tb.soft;

import javax.swing.*;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class Main {
    public static void main(String[] args) {
        try {
            App app = new App();
            SwingUtilities.invokeLater(app);
        } catch (Exception e) {
            System.err.println("Unhandled exception in main(): " + e.getMessage());
        }
    }
}
