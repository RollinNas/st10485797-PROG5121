package Part1;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) {
        // using an ArrayList to store multiple registered users
        ArrayList<Registration> users = new ArrayList<>();
        Login login = new Login();

        // Menu loop to allow multiple operations until user exits
        while (true) {
            String[] mainOptions = { "Register", "Login", "Exit" };

            // Show main menu dialog
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome! Please choose an option:",
                    "Authentication",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    mainOptions,
                    mainOptions[0]);

            // Handle user choice
            if (choice == 0) { // Register
                JOptionPane.showMessageDialog(null, "You chose to Register!");
                Registration newUser = new Registration();
                newUser.startUserRegistration();
                if (newUser.getUsername() != null) {
                    users.add(newUser); // Add the new user to the list
                }
            } else if (choice == 1) { // begin Login
                JOptionPane.showMessageDialog(null, "You chose to Login!");
                if (users.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No users registered yet. Please register first.");
                } else {
                    login.startLogin(users); // Pass the list of users
                }
            } else { // Exit or dialog closed
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }
        }
    }
}
