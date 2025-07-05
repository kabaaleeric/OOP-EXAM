
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Simple Registration Form with password validation
 * This class creates a user-friendly registration form using Java Swing
 */
public class SimpleRegistrationForm extends JFrame {
    // Declare all the form components as class variables
    private JTextField nameField;                    // Text field for entering name
    private JComboBox<String> genderComboBox;       // Dropdown for gender selection
    private JComboBox<String> nationalityComboBox;  // Dropdown for nationality selection
    private JPasswordField passwordField;           // Password field (hides the text)
    private JPasswordField confirmPasswordField;    // Confirm password field
    private JButton submitButton;                   // Submit button
    private JButton exitButton;                     // Exit button

    /**
     * Constructor - sets up the entire form
     */
    public SimpleRegistrationForm() {
        // Set the window properties
        setTitle("User Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);  // Center the window on screen
        
        // Create the main panel using BorderLayout (simpler than GridBagLayout)
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Add some padding around the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Create and add the title at the top
        JLabel titleLabel = new JLabel("User Registration", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 100, 150));  // Blue color
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Create the form panel in the center
        JPanel formPanel = createFormPanel();
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        // Create the button panel at the bottom
        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add the main panel to the frame
        add(mainPanel);
    }
    
    /**
     * Creates the form panel with all input fields
     * Uses GridLayout for simple, organized arrangement
     */
    private JPanel createFormPanel() {
        // Create panel with 6 rows and 2 columns (6 fields, each with label and input)
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // 1. Name Field
        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(nameLabel);
        panel.add(nameField);
        
        // 2. Gender ComboBox
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 14));
        String[] genders = {"Select Gender", "Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(genderLabel);
        panel.add(genderComboBox);
        
        // 3. Nationality ComboBox
        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        String[] nationalities = {
            "Select Nationality", "American", "British", "Canadian", "Australian", 
            "German", "French", "Spanish", "Italian", "Chinese", "Japanese", 
            "Indian", "Brazilian", "Mexican", "Russian", "South African", "Other"
        };
        nationalityComboBox = new JComboBox<>(nationalities);
        nationalityComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(nationalityLabel);
        panel.add(nationalityComboBox);
        
        // 4. Password Field
        JLabel passwordLabel = new JLabel("Enter Your Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(passwordLabel);
        panel.add(passwordField);
        
        // 5. Confirm Password Field
        JLabel confirmPasswordLabel = new JLabel("Re-enter Password:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        
        return panel;
    }
    
    /**
     * Creates the button panel with Submit and Exit buttons
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        // Create Submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setPreferredSize(new Dimension(120, 40));
        submitButton.setBackground(new Color(70, 130, 180));  // Steel blue
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);  // Remove focus border
        
        // Create Exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setPreferredSize(new Dimension(120, 40));
        exitButton.setBackground(new Color(220, 20, 60));  // Crimson red
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        
        // Add action listeners (what happens when buttons are clicked)
        submitButton.addActionListener(e -> handleSubmit());
        exitButton.addActionListener(e -> System.exit(0));
        
        // Add buttons to panel
        panel.add(submitButton);
        panel.add(exitButton);
        
        return panel;
    }
    
    /**
     * Handles the submit button click
     * Validates all fields and checks if passwords match
     */
    private void handleSubmit() {
        // Get values from all fields
        String name = nameField.getText().trim();
        String gender = (String) genderComboBox.getSelectedItem();
        String nationality = (String) nationalityComboBox.getSelectedItem();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        // Validate that all fields are filled
        if (name.isEmpty()) {
            showError("Please enter your name!");
            nameField.requestFocus();  // Put cursor in name field
            return;
        }
        
        if ("Select Gender".equals(gender)) {
            showError("Please select your gender!");
            genderComboBox.requestFocus();
            return;
        }
        
        if ("Select Nationality".equals(nationality)) {
            showError("Please select your nationality!");
            nationalityComboBox.requestFocus();
            return;
        }
        
        if (password.isEmpty()) {
            showError("Please enter your password!");
            passwordField.requestFocus();
            return;
        }
        
        if (confirmPassword.isEmpty()) {
            showError("Please re-enter your password!");
            confirmPasswordField.requestFocus();
            return;
        }
        
        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match! Please try again.");
            passwordField.setText("");      // Clear password fields
            confirmPasswordField.setText("");
            passwordField.requestFocus();   // Put cursor in first password field
            return;
        }
        
        // If all validation passes, show success message
        showSuccess(name, gender, nationality);
        
        // Clear the form for next registration
        clearForm();
    }
    
    /**
     * Shows an error message dialog
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(
            this,                    // Parent window
            message,                 // Message to display
            "Error",                 // Dialog title
            JOptionPane.ERROR_MESSAGE // Type of dialog (shows red X icon)
        );
    }
    
    /**
     * Shows a success message with registration details
     */
    private void showSuccess(String name, String gender, String nationality) {
        String message = "Registration Successful!\n\n" +
                        "Name: " + name + "\n" +
                        "Gender: " + gender + "\n" +
                        "Nationality: " + nationality + "\n\n" +
                        "Your account has been created successfully!";
        
        JOptionPane.showMessageDialog(
            this,
            message,
            "Success",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Clears all form fields
     */
    private void clearForm() {
        nameField.setText("");
        genderComboBox.setSelectedIndex(0);
        nationalityComboBox.setSelectedIndex(0);
        passwordField.setText("");
        confirmPasswordField.setText("");
        nameField.requestFocus();  // Put cursor back in name field
    }
    
    /**
     * Main method - starts the application
     * SwingUtilities.invokeLater ensures the GUI runs on the correct thread
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleRegistrationForm form = new SimpleRegistrationForm();
            form.setVisible(true);
        });
    }
} 

