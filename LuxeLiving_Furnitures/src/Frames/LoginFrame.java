package Frames;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginFrame() {
        setTitle("LuxeLiving Furniture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Warm terracotta background
        Color warmBackground = new Color(235, 153, 118); // Mix of orange, brown, and red
        Color buttonColor = new Color(165, 42, 42); // Dark reddish-brown
        getContentPane().setBackground(warmBackground);

        // Left panel for the form
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        leftPanel.setBackground(warmBackground);

        // Header with logo and title
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.setBackground(warmBackground);

        // Logo
        ImageIcon imageIcon = new ImageIcon("src/Resources/images/logo11.png");
        Image image = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title
        JLabel welcomeLabel = new JLabel("LuxeLiving Furniture");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(54, 69, 79)); // Dark slate gray
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(imageLabel);
        headerPanel.add(Box.createVerticalStrut(15));
        headerPanel.add(welcomeLabel);
        headerPanel.add(Box.createVerticalStrut(40));

        leftPanel.add(headerPanel);

        // Form fields
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        leftPanel.add(createStyledLabeledField("Username", usernameField, warmBackground));
        leftPanel.add(Box.createVerticalStrut(20));

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        leftPanel.add(createStyledLabeledField("Password", passwordField, warmBackground));
        leftPanel.add(Box.createVerticalStrut(30));

        // Login button
        loginButton = new JButton("LOGIN");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(buttonColor); // Updated color
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        loginButton.setPreferredSize(new Dimension(300, 40));
        loginButton.setMaximumSize(new Dimension(300, 40));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leftPanel.add(loginButton);

        // Centering the form
        JPanel leftContainer = new JPanel(new GridBagLayout());
        leftContainer.setBackground(warmBackground);
        leftContainer.add(leftPanel);
        add(leftContainer, BorderLayout.CENTER);

        // Right panel with image
        JLabel imageLabelRight = new JLabel();
        ImageIcon imageIconRight = new ImageIcon(new ImageIcon("src/Resources/images/Newdesign.jpg")
                .getImage().getScaledInstance(700, 800, Image.SCALE_SMOOTH));
        imageLabelRight.setIcon(imageIconRight);
        add(imageLabelRight, BorderLayout.EAST);

        loginButton.addActionListener(e -> onLogin());

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createStyledLabeledField(String labelText, JTextField textField, Color backgroundColor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(backgroundColor);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(new Color(105, 105, 105)); // Dim gray
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private void onLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if ("admin".equals(username) && "admin".equals(password)) {
            dispose();
            new HomeFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid username or password",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            LoginFrame frame = new LoginFrame();
            frame.setMinimumSize(new Dimension(1000, 600));
            frame.setVisible(true);
        });
    }
}
