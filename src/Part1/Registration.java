package Part1;

import javax.swing.JOptionPane;

// Registration class to handle user registration with validations
public class Registration {
    // User details
    private String firstName;
    private String lastName;
    private String password; // stored but not displayed for security reasons
    private String username;
    private String phoneNumber; 

    // Getters and Setters
    public String getFirstName() {
        return firstName; 
    }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() {
        return lastName; 
    }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }
    
    public String getPassword() { 
        return password; 
    }
    public void setPassword(String password) { 
        this.password = password; 
    }

    public String getUsername() { 
        return username; 
    }
    public void setUsername(String username) { 
        this.username = username; 
    }

    public String getPhoneNumber() { 
        return phoneNumber; 
    }
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    }

    // Start Registration process
    public void startRegistration() {
        
        String firstName = JOptionPane.showInputDialog("Please enter your first name");
        if (firstName == null) return; // user cancelled

        String lastName = JOptionPane.showInputDialog("Please enter your last name");
        if (lastName == null) return; // user cancelled

        // Get username with validation
        String username = getValidUsername();
        if (username == null) return; // user cancelled
        JOptionPane.showMessageDialog(null, "Username successfully captured");

        // Get password with validation
        String password = getValidPassword();
        if (password == null) return; // user cancelled
        JOptionPane.showMessageDialog(null, "Password successfully captured");

        // Get phone number with validation
        String phoneNumber = getValidPhoneNumber();
        if (phoneNumber == null) return; // user cancelled
        JOptionPane.showMessageDialog(null, "Cell phone number successfully added");

        // Store details in instance variables
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);

        // Show successful registration message (without password for security)
        JOptionPane.showMessageDialog(null,
                "✅ Registration Successful!\n" +
                        "First Name: " + firstName + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Username: " + username + "\n" +
                        "Phone: " + phoneNumber);
    }

    // Username validation with loop
    private String getValidUsername() {
        String username;
        do {
            username = JOptionPane.showInputDialog(
                    "Enter username (-must contain an underscore \n -must be no more than five characters long):");
            if (username == null) return null; // handle cancel
            if (!Login.checkUserName(username)) {
                JOptionPane.showMessageDialog(null, "❌ Invalid username. Must contain '_' and be ≤ 5 characters.");
                username = null; // force retry
            }
        } while (username == null);
        return username;
    }

    // Password validation with loop
    private String getValidPassword() {
        String password;
        do {
            password = JOptionPane.showInputDialog(
                    "Enter password (≥8 chars, must contain uppercase, number, special char):");
            if (password == null) return null; // handle cancel
            if (!Login.checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "❌ Password not complex enough. Try again.");
                password = null; // force retry
            }
        } while (password == null);
        return password;
    }

    // Phone number validation with loop
    private String getValidPhoneNumber() {
        String phone;
        do {
            phone = JOptionPane.showInputDialog(
                    "Enter phone number (must start with +27 and be followed by 9 digits):");
            if (phone == null) return null; // handle cancel
            if (!Login.checkCellPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(null, "❌ Invalid phone number format. Try again.");
                phone = null; // force retry
            }
        } while (phone == null);
        return phone;
    }
}
