package Frames.Staff;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class update extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField contactField;
    private JTextField positionFeild;
    private JTextField dobField;
    private JTextField genderField;
    private JTextField statusField;
    private JTextField infoField;

    public update() {

        super("Update");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        Sidebar sidebar = new Sidebar();
        this.add(sidebar, BorderLayout.WEST);

        JPanel buttonpanel = new JPanel(new BorderLayout());
        buttonpanel.setPreferredSize(new Dimension(9000, 1000));
        buttonpanel.setBackground(Color.WHITE);

        // Creating top panel
        JPanel updatePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        updatePanel.setBackground(Color.WHITE);

        JLabel upLabel = new JLabel("Update Details");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));

        buttonpanel.add(updatePanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setBackground(Color.WHITE);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 70)));

        ImageIcon editIcon = new ImageIcon("src/Resources/images/updateicon.png");
        Image editImg = editIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JButton addbtn = new JButton(new ImageIcon(editImg));
        addbtn.setPreferredSize(new Dimension(700, 200));
        addbtn.setOpaque(false);
        addbtn.setContentAreaFilled(false);
        addbtn.setBorderPainted(false);
        buttonsPanel.add(addbtn);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 90)));

        buttonpanel.add(buttonsPanel, BorderLayout.CENTER);

        getContentPane().add(buttonpanel, BorderLayout.CENTER);

        JPanel updetailsPanel = new JPanel(new BorderLayout());
        updetailsPanel.setPreferredSize(new Dimension(800, updetailsPanel.getPreferredSize().height));
        updetailsPanel.setBackground(Color.LIGHT_GRAY);

        JPanel buttonsTopPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 10));
        buttonsTopPanel.setBackground(Color.WHITE);

        // Add update button
        JButton saveButton = new JButton("Update");
        saveButton.setPreferredSize(new Dimension(100, 30));
        saveButton.setBackground(Color.blue);
        saveButton.setForeground(Color.white);
        buttonsTopPanel.add(saveButton);

        // Add cancel button
        JButton deleteButton = new JButton("Cancel");
        deleteButton.setPreferredSize(new Dimension(100, 30));
        deleteButton.setBackground(Color.red);
        deleteButton.setForeground(Color.white);
        buttonsTopPanel.add(deleteButton);

        updetailsPanel.add(buttonsTopPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 60, 10, 50);
        inputPanel.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(100, 30));
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(100, 30));
        inputPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Contact Number:"), gbc);

        gbc.gridx = 1;
        contactField = new JTextField(20);
        contactField.setPreferredSize(new Dimension(100, 30));
        inputPanel.add(contactField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Position:"), gbc);

        gbc.gridx = 1;
        positionFeild = new JTextField(20);
        positionFeild.setPreferredSize(new Dimension(100, 30));
        inputPanel.add(positionFeild, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("Date of Birth:"), gbc);

        gbc.gridx = 1;
        dobField = new JTextField(20);
        dobField.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(dobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(new JLabel("Gender:"), gbc);

        gbc.gridx = 1;
        genderField = new JTextField(20);
        genderField.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(genderField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        statusField = new JTextField(20);
        statusField.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(statusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        inputPanel.add(new JLabel("Additional Information:"), gbc);

        gbc.gridx = 1;
        infoField = new JTextField(20);
        infoField.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(infoField, gbc);

        updetailsPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().add(updetailsPanel, BorderLayout.EAST);

        // Read existing data from staff.properties file and set to the fields
        try {
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateData();
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    private void readData() throws IOException {
        Properties properties = new Properties();
        String filePath = "C:/Users/Manul Perera/IdeaProjects/Phoenix_Furnitures/Saved_Items/staff.properties";
        File file = new File(filePath);

        if (file.exists()) {
            FileInputStream fileInput = new FileInputStream(file);
            try {
                properties.load(fileInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileInput.close();
        }

        nameField.setText(properties.getProperty("Name", ""));
        emailField.setText(properties.getProperty("Email", ""));
        contactField.setText(properties.getProperty("Contact Number", ""));
        positionFeild.setText(properties.getProperty("Position", ""));
        dobField.setText(properties.getProperty("Date of Birth", ""));
        genderField.setText(properties.getProperty("Gender", ""));
        statusField.setText(properties.getProperty("Address", ""));
        infoField.setText(properties.getProperty("Additional Information", ""));
    }

    private void updateData() throws IOException {
        Properties properties = new Properties();
        String filePath = "C:/Users/Manul Perera/IdeaProjects/Phoenix_Furnitures/Saved_Items/staff.properties";
        File file = new File(filePath);

        if (file.exists()) {
            FileInputStream fileInput = new FileInputStream(file);
            try {
                properties.load(fileInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileInput.close();
        }

        properties.setProperty("Name", nameField.getText());
        properties.setProperty("Email", emailField.getText());
        properties.setProperty("Contact Number", contactField.getText());
        properties.setProperty("Position", positionFeild.getText());
        properties.setProperty("Date of Birth", dobField.getText());
        properties.setProperty("Gender", genderField.getText());
        properties.setProperty("Address", statusField.getText());
        properties.setProperty("Additional Information", infoField.getText());

        try {
            properties.store(new java.io.FileOutputStream(filePath), "Staff Details");
            JOptionPane.showMessageDialog(null, "Data updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            update frame = new update();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Welcome");

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int screenWidth = toolkit.getScreenSize().width;
            int screenHeight = toolkit.getScreenSize().height;
            frame.setSize(screenWidth, screenHeight);
            frame.setVisible(true);
        });
    }
}
