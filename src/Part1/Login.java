package Part1;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Login {

    // Start Login Process for multiple users
    public void startLogin(ArrayList<Registration> users) {
        String username;
        String password;
        Registration currentUser = null;

        // Prompt for username until match found
        while (true) {
            username = JOptionPane.showInputDialog("Enter your username:");
            if (username == null) { // handle cancel
                JOptionPane.showMessageDialog(null, "Login canceled.");
                return;
            }
            // Search for user in the list
            for (Registration user : users) {
                if (username.equals(user.getUsername())) {
                    currentUser = user;
                    break;
                }
            }
            if (currentUser != null) break; // found matching user
            JOptionPane.showMessageDialog(null, "❌ Username is incorrect or does not exist. Please try again.");
        }

        // Prompt for password until match found
        while (true) {
            password = JOptionPane.showInputDialog("Enter your password:");
            if (password == null) { // handle cancel
                JOptionPane.showMessageDialog(null, "Login canceled.");
                return;
            }
            if (password.equals(currentUser.getPassword())) break;
            JOptionPane.showMessageDialog(null, "❌ Password is incorrect. Please try again.");
        }

        // Successful login message
        JOptionPane.showMessageDialog(null,
                "✅ Login Successful!\n Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName());
    }

    // Static Phone Number Validation Logic
    public static boolean checkCellPhoneNumber(String phone) {
        if (phone == null || !phone.matches("\\+27\\d{9}")) {
            return false;
        }
        return true;
    }

    // Static Password Validation Logic
    public static boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8 ||
                !password.matches(".*[!@#$%^&*(),.?\":{}|<>].*") ||
                !password.matches(".*[0-9].*") ||
                !password.matches(".*[A-Z].*")) {
            return false;
        }
        return true;
    }

    // Static Username Validation Logic
    public static boolean checkUserName(String username) {
        if (username == null || username.length() > 5 || !username.contains("_")) {
            return false;
        }
        return true;
    }
}
