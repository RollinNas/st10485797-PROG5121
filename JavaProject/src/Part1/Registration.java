
package Part1;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class Registration {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String phoneNumber; 
    

    public void startRegistration() {
        // Get first name
        firstName = JOptionPane.showInputDialog("Please enter your first name");
        
        // Get last name
        lastName = JOptionPane.showInputDialog("Please enter your last name");
        
        // Get username with validation
        username = getValidUsername();
        
        // Get password with validation + confirmation
        password = getValidPassword();
        
        // Get phone number with validation (+27 and 9 digits)
        phoneNumber = getValidPhoneNumber();
        
        // Show successful registration message
        JOptionPane.showMessageDialog(null, 
            "✅ Registration Successful!\n" +
            "First Name: " + firstName + "\n" +
            "Last Name: " + lastName + "\n" +
            "Username: " + username + "\n" +
            "Phone: " + phoneNumber);
    }

    //Username
    private String getValidUsername() {
        String username;
        do {
            username = JOptionPane.showInputDialog(
                "Enter username (must be ≤5 characters and contain '_'):");
        } while (!isValidUsername(username));
        return username;
    }

    private boolean isValidUsername(String username) {
        if (username == null || username.length() > 5 || !username.contains("_")) {
            JOptionPane.showMessageDialog(null,
                " Invalid username!\nUsername must be ≤5 characters and contain '_'");
            return false;
        }
        return true;
    }

    //Password (Hidden Input + Confirmation)
    private String getValidPassword() {
        String password;
        String confirmPassword;
        do {
            password = askHiddenPassword("Enter password (≥8 chars, must contain uppercase, number, special char):");
            if (!isValidPassword(password)) continue;
            
            confirmPassword = askHiddenPassword("Confirm your password:");
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, " Passwords do not match! Please try again.");
                password = null; // reset to trigger retry
            }
        } while (password == null || !isValidPassword(password));
        return password;
    }

    private String askHiddenPassword(String message) {
        JPasswordField pf = new JPasswordField();
        pf.setEchoChar('*');
        int okCxl = JOptionPane.showConfirmDialog(null, pf, 
                 message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (okCxl == JOptionPane.OK_OPTION) {
            return new String(pf.getPassword());
        } else {
            return "";
        }
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            JOptionPane.showMessageDialog(null,
                " Password must be at least 8 characters long.");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(null,
                " Password must contain at least one uppercase letter.");
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            JOptionPane.showMessageDialog(null,
                " Password must contain at least one number.");
            return false;
        }
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            JOptionPane.showMessageDialog(null,
                " Password must contain at least one special character.");
            return false;
        }
        return true;
    }

    // ------------------ Phone Number (+27xxxxxxxxx) ------------------
    private String getValidPhoneNumber() {
        String phone;
        do {
            phone = JOptionPane.showInputDialog(
                "Enter phone number (must start with +27 and be followed by 9 digits):");
        } while (!isValidPhoneNumber(phone));
        return phone;
    }

    private boolean isValidPhoneNumber(String phone) {
        if (phone == null || !phone.matches("\\+27\\d{9}")) {
            JOptionPane.showMessageDialog(null,
                " Invalid phone number!\nIt must start with +27 and be followed by 9 digits (e.g., +27831234567).");
            return false;
        }
        return true;
    }
}
