




import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.regex.Pattern;
    public class ExhibitionRegistrationApp extends JFrame {
        // Database connection details
        private static final String  CONNECTION_STRING  = "jdbc:sqlite:exhibition.db";
        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        //  the GUI components
        private JTextField txtRegId, txtName, txtFaculty, txtProjectTitle, txtContact, txtEmail;
    

        public ExhibitionRegistrationApp() {
            initializeDatabase();
            initializeUI();
        }
       // Creating the table
        private void initializeDatabase() {
            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
                String sql = "CREATE TABLE IF NOT EXISTS Participants (" +
                        "RegistrationID TEXT PRIMARY KEY," +
                        "StudentName TEXT NOT NULL," +
                        "Faculty TEXT NOT NULL," +
                        "ProjectTitle TEXT NOT NULL," +
                        "ContactNumber TEXT NOT NULL," +
                        "EmailAddress TEXT NOT NULL" +
                        ")";
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database initialization error: " + e.getMessage());
            }
        }

        private void initializeUI() {
            setTitle("Victoria University Exhibition Registration");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(700, 450);
            setLocationRelativeTo(null);
            setFocusable(false);
            setResizable(false);
            
            //crerating the main panebl for the GUI compponents, adding them to the panel and adding the panel to the main frame:
            JPanel mainPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;
         
            // Registration ID
            gbc.gridx = 0; gbc.gridy = 0;
            mainPanel.add(new JLabel("Registration ID:"), gbc);
            gbc.gridx = 1;
            txtRegId = new JTextField(20);
            mainPanel.add(txtRegId, gbc);

            // Student Name
            gbc.gridx = 0; gbc.gridy = 1;
            mainPanel.add(new JLabel("Student Name:"), gbc);
            gbc.gridx = 1;
            txtName = new JTextField(20);
            mainPanel.add(txtName, gbc);

            // Faculty
            gbc.gridx = 0; gbc.gridy = 2;
            mainPanel.add(new JLabel("Faculty:"), gbc);
            gbc.gridx = 1;
            txtFaculty = new JTextField(20);
            mainPanel.add(txtFaculty, gbc);

            // Project Title
            gbc.gridx = 0; gbc.gridy = 3;
            mainPanel.add(new JLabel("Project Title:"), gbc);
            gbc.gridx = 1;
            txtProjectTitle = new JTextField(20);
            mainPanel.add(txtProjectTitle, gbc);

            // Contact Number
            gbc.gridx = 0; gbc.gridy = 4;
            mainPanel.add(new JLabel("Contact Number:"), gbc);
            gbc.gridx = 1;
            txtContact = new JTextField(20);
            mainPanel.add(txtContact, gbc);

            // Email Address
            gbc.gridx = 0; gbc.gridy = 5;
            mainPanel.add(new JLabel("Email Address:"), gbc);
            gbc.gridx = 1;
            txtEmail = new JTextField(20);
            mainPanel.add(txtEmail, gbc);

            // Buttons panel
            gbc.gridx = 0; gbc.gridy = 7;
            gbc.gridwidth = 2;
            JPanel buttonPanel = new JPanel();
            JButton btnRegister = new JButton("Register");
            JButton btnClear = new JButton("Clear");
            JButton btnExit = new JButton("Exit");

            buttonPanel.add(btnRegister);
            buttonPanel.add(btnClear);
            buttonPanel.add(btnExit);
            mainPanel.add(buttonPanel, gbc);

            // Addition of the action listeners
            btnRegister.addActionListener(e -> registerParticipant());

            btnClear.addActionListener(e -> clearForm());
            btnExit.addActionListener(e -> System.exit(0));
            add(mainPanel);
        }

        private boolean validateInput() {
            if (txtRegId.getText().trim().isEmpty() ||
                    txtName.getText().trim().isEmpty() ||
                    txtFaculty.getText().trim().isEmpty() ||
                    txtProjectTitle.getText().trim().isEmpty() ||
                    txtContact.getText().trim().isEmpty() ||
                    txtEmail.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
                return true;
            }

            if (!EMAIL_PATTERN.matcher(txtEmail.getText().trim()).matches()) {
                JOptionPane.showMessageDialog(this, "Invalid email format!");
                return true;
            }

            return false;
        }

        private void registerParticipant() {
            if (validateInput()) return;

            String sql = "INSERT INTO Participants (RegistrationID, StudentName, Faculty, ProjectTitle, ContactNumber, EmailAddress, ) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, txtRegId.getText().trim());
                pstmt.setString(2, txtName.getText().trim());
                pstmt.setString(3, txtFaculty.getText().trim());
                pstmt.setString(4, txtProjectTitle.getText().trim());
                pstmt.setString(5, txtContact.getText().trim());
                pstmt.setString(6, txtEmail.getText().trim());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Registration successful!");
                clearForm();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Registration error: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new ExhibitionRegistrationApp().setVisible(true);
            });
        }

    private void clearForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }






