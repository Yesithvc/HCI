package Frames.Suppliers;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class furnitureinfo extends JFrame {

    private JTextField suppliercodeField;
    private JTextField suppliernameField;
    private JTextField numField;
    private JTextField proField;
    private JTextField catField;
    private JTextField PayField;
    private JTextField ListField;

    public furnitureinfo() {
        Sidebar sidebar = new Sidebar();
        this.add(sidebar, BorderLayout.WEST);

        JPanel buttonpanel = new JPanel(new BorderLayout()); // Use BorderLayout for buttonpanel
        buttonpanel.setPreferredSize(new Dimension(9000, 1000)); // Setting preferred size of the button panel
        buttonpanel.setBackground(Color.WHITE);

        // Create a panel for holding the "hi" label
        JPanel hiPanel = new JPanel(new FlowLayout(FlowLayout.LEADING)); // Use FlowLayout.LEADING for hiPanel
        hiPanel.setBackground(Color.WHITE);

        // Add the "hi" label to the hiPanel
        JLabel upLabel = new JLabel("Add Supplier");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));
        hiPanel.add(upLabel);

        // Add the hiPanel to the NORTH position of buttonpanel
        buttonpanel.add(hiPanel, BorderLayout.NORTH);

        // Create a panel for holding the buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Use FlowLayout for buttonsPanel
        buttonsPanel.setBackground(Color.WHITE);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 70)));

        // Adding buttons to buttonsPanel
        ImageIcon editIcon = new ImageIcon("src/Resources/images/updateicon.png");
        Image editImg = editIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JButton addbtn = new JButton(new ImageIcon(editImg));
        addbtn.setPreferredSize(new Dimension(700, 200)); // Setting preferred size of Add button
        addbtn.setOpaque(false);
        addbtn.setContentAreaFilled(false);
        addbtn.setBorderPainted(false);
        buttonsPanel.add(addbtn);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 90)));

        JButton savebtn = new JButton("Save");
        savebtn.setPreferredSize(new Dimension(250, 60)); // Setting preferred size of Save button
        savebtn.setBackground(Color.BLUE);
        savebtn.setForeground(Color.WHITE);// Change the color to red
        savebtn.setFont(savebtn.getFont().deriveFont(19f));
        buttonsPanel.add(savebtn);

        JButton cancelbtn = new JButton("Cancel");
        cancelbtn.setPreferredSize(new Dimension(250, 60)); // Setting preferred size of Cancel button
        cancelbtn.setBackground(Color.RED);
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.setFont(savebtn.getFont().deriveFont(19f));
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear data from text fields by accessing instance variables
                suppliercodeField.setText("");
                suppliernameField.setText("");
                numField.setText("");
                proField.setText("");
                catField.setText("");
                PayField.setText("");
                ListField.setText("");
            }
        });
        buttonsPanel.add(cancelbtn);

        // Add the buttonsPanel to the CENTER position of buttonpanel
        buttonpanel.add(buttonsPanel, BorderLayout.CENTER);

        suppliercodeField = new JTextField(20);
        suppliernameField = new JTextField(20);
        numField = new JTextField(20);
        proField = new JTextField(20);
        catField = new JTextField(20);
        PayField = new JTextField(20);
        ListField = new JTextField(20);

        // Add buttonpanel to the JFrame
        getContentPane().add(buttonpanel, BorderLayout.CENTER);

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(40, 10, 0, 10);
        detailsPanel.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        detailsPanel.add(new JLabel("Supply Code:"), gbc);

        gbc.gridx = 1;
        suppliercodeField.setPreferredSize(new Dimension(100, 30)); // Customizing preferred size
        detailsPanel.add(suppliercodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        detailsPanel.add(new JLabel("Supplier Name:"), gbc);

        gbc.gridx = 1;
        suppliernameField.setPreferredSize(new Dimension(100, 30)); // Customizing preferred size
        detailsPanel.add(suppliernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        detailsPanel.add(new JLabel("Contact Number :"), gbc);

        gbc.gridx = 1;
        numField.setPreferredSize(new Dimension(100, 30)); // Customizing preferred size
        detailsPanel.add(numField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        detailsPanel.add(new JLabel("Product Catalog:"), gbc);

        gbc.gridx = 1;
        proField.setPreferredSize(new Dimension(100, 30)); // Customizing preferred size
        detailsPanel.add(proField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        detailsPanel.add(new JLabel("Item Category :"), gbc);

        gbc.gridx = 1;
        catField.setPreferredSize(new Dimension(300, 30)); // Customizing preferred size
        detailsPanel.add(catField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        detailsPanel.add(new JLabel("Payment Terms :"), gbc);

        gbc.gridx = 1;
        PayField.setPreferredSize(new Dimension(300, 30)); // Customizing preferred size
        detailsPanel.add(PayField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        detailsPanel.add(new JLabel("Item List :"), gbc);

        gbc.gridx = 1;
        ListField.setPreferredSize(new Dimension(300, 30)); // Customizing preferred size
        detailsPanel.add(ListField, gbc);

        gbc.weightx = 0; // Set weightx to 1.0 for all columns to make them equally wide
        gbc.gridx = 0; // Reset gridx to 0 for the last component
        gbc.gridwidth = 2; // Set gridwidth to 2 to make the component span across two columns
        gbc.gridy++; // Increment gridy to move to the next row
        detailsPanel.add(new JLabel(), gbc); // Add an empty component to fill the last row

        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        saveData();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                });
            }
        });

        detailsPanel.setPreferredSize(new Dimension(800, 600));

        getContentPane().add(detailsPanel, BorderLayout.EAST);
    }

    private void saveData() throws FileNotFoundException {
        Properties properties = new Properties();
        try {
            String filePath = "C:/Users/Manul Perera/IdeaProjects/Phoenix_Furnitures/Saved_Items/suppliers.properties";
            File file = new File(filePath);

            if (file.exists()) {
                FileInputStream fileInput = new FileInputStream(file);
                properties.load(fileInput);
                fileInput.close();
            }

            properties.setProperty("Supply Code", suppliercodeField.getText());
            properties.setProperty("Supplier Name", suppliernameField.getText());
            properties.setProperty("Contact Number", numField.getText());
            properties.setProperty("Product Catalog", proField.getText());
            properties.setProperty("Item Catalog", catField.getText());
            properties.setProperty("Payment Terms", PayField.getText());
            properties.setProperty("Item List", ListField.getText());

            FileOutputStream fileOut = new FileOutputStream(filePath);
            properties.store(fileOut, "Furniture Details");
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            furnitureinfo frame = new furnitureinfo();
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
