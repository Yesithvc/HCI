package Frames.Suppliers;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class update extends JFrame {

    private JTextField suppliercodeField;
    private JTextField suppliernameField;
    private JTextField numField;
    private JTextField catField;
    private JTextField icatField;
    private JTextField payField;
    private JTextField listField;

    public update() {

        Sidebar sidebar = new Sidebar();
        this.add(sidebar, BorderLayout.WEST);

        JPanel buttonpanel = new JPanel(new BorderLayout()); // Use BorderLayout for buttonpanel
        buttonpanel.setPreferredSize(new Dimension(9000, 1000)); // Setting preferred size of the button panel
        buttonpanel.setBackground(Color.WHITE);

        // Create a panel for holding the "hi" label
        JPanel hiPanel = new JPanel(new FlowLayout(FlowLayout.LEADING)); // Use FlowLayout.LEADING for hiPanel
        hiPanel.setBackground(Color.WHITE);
        // Add the "hi" label to the hiPanel
        JLabel upLabel = new JLabel("Supplier Edit");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));
        hiPanel.add(upLabel);

        // Add the hiPanel to the NORTH position of buttonpanel
        buttonpanel.add(hiPanel, BorderLayout.NORTH);

        // Create a panel for holding the buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Use FlowLayout for buttonsPanel
        buttonsPanel.setBackground(Color.WHITE);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 70)));

        // Adding buttons to buttonsPanel
        ImageIcon editIcon = new ImageIcon("src/Resources/images/newuserimg.png");
        Image editImg = editIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JButton addbtn = new JButton(new ImageIcon(editImg));
        addbtn.setPreferredSize(new Dimension(700, 200)); // Setting preferred size of Add button
        addbtn.setOpaque(false);
        addbtn.setContentAreaFilled(false);
        addbtn.setBorderPainted(false);
        buttonsPanel.add(addbtn);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 90)));

        JButton savebtn = new JButton("Update");
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
                clearFields();
            }
        });
        buttonsPanel.add(cancelbtn);

        // Add the buttonsPanel to the CENTER position of buttonpanel
        buttonpanel.add(buttonsPanel, BorderLayout.CENTER);

        suppliercodeField = new JTextField(20);
        suppliernameField = new JTextField(20);
        numField = new JTextField(20);
        catField = new JTextField(20);
        icatField = new JTextField(20);
        payField = new JTextField(20);
        listField = new JTextField(20);

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
        catField.setPreferredSize(new Dimension(100, 30)); // Customizing preferred size
        detailsPanel.add(catField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        detailsPanel.add(new JLabel("Item Category :"), gbc);

        gbc.gridx = 1;
        icatField.setPreferredSize(new Dimension(300, 30)); // Customizing preferred size
        detailsPanel.add(icatField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        detailsPanel.add(new JLabel("Payment Terms :"), gbc);

        gbc.gridx = 1;
        payField.setPreferredSize(new Dimension(300, 30)); // Customizing preferred size
        detailsPanel.add(payField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        detailsPanel.add(new JLabel("Item List :"), gbc);

        gbc.gridx = 1;
        listField.setPreferredSize(new Dimension(300, 30)); // Customizing preferred size
        detailsPanel.add(listField, gbc);

        gbc.weightx = 0; // Set weightx to 1.0 for all columns to make them equally wide
        gbc.gridx = 0; // Reset gridx to 0 for the last component
        gbc.gridwidth = 2; // Set gridwidth to 2 to make the component span across two columns
        gbc.gridy++; // Increment gridy to move to the next row
        detailsPanel.add(new JLabel(), gbc); // Add an empty component to fill the last row

        detailsPanel.setPreferredSize(new Dimension(800, 600));

        getContentPane().add(detailsPanel, BorderLayout.EAST);

        // Read existing data from suppliers.properties file and set to the fields
        try {
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        savebtn.addActionListener(new ActionListener() {
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
        String filePath = "C:/Users/Manul Perera/IdeaProjects/Phoenix_Furnitures/Saved_Items/suppliers.properties";
        File file = new File(filePath);

        if (file.exists()) {
            FileInputStream fileInput = new FileInputStream(file);
            properties.load(fileInput);
            fileInput.close();
        }

        suppliercodeField.setText(properties.getProperty("Supply Code", ""));
        suppliernameField.setText(properties.getProperty("Supplier Name", ""));
        numField.setText(properties.getProperty("Contact Number", ""));
        catField.setText(properties.getProperty("Product Catalog", ""));
        icatField.setText(properties.getProperty("Item Catalog", ""));
        payField.setText(properties.getProperty("Payment Terms", ""));
        listField.setText(properties.getProperty("Item List", ""));
    }

    private void updateData() throws IOException {
        Properties properties = new Properties();
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
        properties.setProperty("Product Catalog", catField.getText());
        properties.setProperty("Item Catalog", icatField.getText());
        properties.setProperty("Payment Terms", payField.getText());
        properties.setProperty("Item List", listField.getText());

        FileOutputStream fileOut = new FileOutputStream(filePath);
        properties.store(fileOut, "Furniture Details");
        fileOut.close();

        JOptionPane.showMessageDialog(null, "Data updated successfully!");
    }

    private void clearFields() {
        suppliercodeField.setText("");
        suppliernameField.setText("");
        numField.setText("");
        catField.setText("");
        icatField.setText("");
        payField.setText("");
        listField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            update uframe = new update();
            uframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            uframe.setTitle("Update");

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int screenWidth = toolkit.getScreenSize().width;
            int screenHeight = toolkit.getScreenSize().height;
            uframe.setSize(screenWidth, screenHeight);
            uframe.setVisible(true);
        });
    }
}
