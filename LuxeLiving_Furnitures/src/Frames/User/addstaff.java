package Frames.User;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class addstaff extends JFrame {

    private JTextField namefield, emailfild, cntctnumfield, posfield, dobfield, genfield, statusfield, descfeild;
    private String enteredName;

    public addstaff(){

        Sidebar sidebar = new Sidebar();
        JPanel btnpannel = new JPanel(new BorderLayout());
        btnpannel.setPreferredSize(new Dimension(900, 600));
        btnpannel.setBackground(Color.WHITE);

        // Create a panel for holding  top details
        JPanel staffPanel = new JPanel(new BorderLayout());
        staffPanel.setBackground(Color.white);

        JLabel upLabel = new JLabel("Add Staff");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));
        staffPanel.add(upLabel,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        centerPanel.setBackground(Color.white);

        ImageIcon pp = new ImageIcon("src/Resources/images/updateicon.png");
        Image ppimage = pp.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JButton addbtn = new JButton(new ImageIcon(ppimage));
        addbtn.setPreferredSize(new Dimension(250, 600)); // Setting preferred size of Add button
        addbtn.setOpaque(false);
        addbtn.setContentAreaFilled(false);
        addbtn.setBorderPainted(false);
        centerPanel.add(addbtn);

        staffPanel.add(centerPanel, BorderLayout.CENTER);

        btnpannel.add(staffPanel, BorderLayout.NORTH);


        getContentPane().add(btnpannel, BorderLayout.CENTER);

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 60, 10, 50);
        detailsPanel.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nameLabel = new JLabel("Name:");
        Font namefont = new Font(nameLabel.getFont().getName(), Font.BOLD, 16);
        nameLabel.setFont(namefont);
        detailsPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        namefield = new JTextField(20);
        namefield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(namefield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel emailLabel = new JLabel("Email:");
        Font emailfont = new Font(emailLabel.getFont().getName(), Font.BOLD, 16);
        emailLabel.setFont(emailfont);
        detailsPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailfild = new JTextField(20);
        emailfild.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(emailfild, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel cntcnumLabel = new JLabel("Contact number:");
        Font  cntfont = new Font(cntcnumLabel.getFont().getName(), Font.BOLD, 16);
        cntcnumLabel.setFont(cntfont);
        detailsPanel.add(cntcnumLabel, gbc);

        gbc.gridx = 1;
        cntctnumfield = new JTextField(20);
        cntctnumfield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(cntctnumfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel positionLabel = new JLabel("Position :");
        Font psofont = new Font(positionLabel.getFont().getName(), Font.BOLD, 16);
        positionLabel.setFont(psofont);
        detailsPanel.add(positionLabel, gbc);

        gbc.gridx = 1;
        posfield = new JTextField(20);
        posfield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(posfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel dobLabel = new JLabel("Date of Birth:");
        Font dobfont = new Font(dobLabel.getFont().getName(), Font.BOLD, 16);
        dobLabel.setFont(dobfont);
        detailsPanel.add(dobLabel, gbc);


        gbc.gridx = 1;
        dobfield = new JTextField(20);
        dobfield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(dobfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel genderabel = new JLabel("Gender:");
        Font genfont = new Font(genderabel.getFont().getName(), Font.BOLD, 16);
        genderabel.setFont(genfont);
        detailsPanel.add(genderabel, gbc);

        gbc.gridx = 1;
        genfield = new JTextField(20);
        genfield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(genfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel statusLabel = new JLabel("Address:");
        Font statusfont = new Font(statusLabel.getFont().getName(), Font.BOLD, 16);
        statusLabel.setFont(statusfont);
        detailsPanel.add(statusLabel, gbc);

        gbc.gridx = 1;
        statusfield = new JTextField(20);
        statusfield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(statusfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel descriptionLabel = new JLabel("Description:");
        Font font = new Font(descriptionLabel.getFont().getName(), Font.BOLD, 16);
        descriptionLabel.setFont(font);
        detailsPanel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        descfeild = new JTextField(20);
        descfeild.setPreferredSize(new Dimension(100, 70));
        detailsPanel.add(descfeild, gbc);

        gbc.weightx = 3;
        gbc.gridx = 4;
        gbc.gridwidth = 5;
        gbc.gridy++;
        detailsPanel.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;

        JButton saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(250, 50));
        saveButton.setForeground(Color.white);
        saveButton.setBackground(Color.blue);

        detailsPanel.add(saveButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        enteredName = namefield.getText();
                        saveData();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                });
            }
        });

        detailsPanel.setPreferredSize(new Dimension(800, 100));

        getContentPane().add(detailsPanel, BorderLayout.EAST);
        getContentPane().add(sidebar,BorderLayout.WEST);
    }

    private void saveData() throws FileNotFoundException {
        Properties properties = new Properties();
        try {
            String filePath = "C:/Users/Manul Perera/IdeaProjects/Phoenix_Furnitures/Saved_Items/staff.properties";
            File file = new File(filePath);

            if (file.exists()) {
                // Load existing data from the properties file
                FileInputStream fileInput = new FileInputStream(file);
                properties.load(fileInput);
                fileInput.close();
            }

            // Create a unique key for each staff entry to prevent overwriting
            String staffKey = "Staff_" + System.currentTimeMillis(); // Unique key based on the current time
            properties.setProperty(staffKey + "_Name", namefield.getText());
            properties.setProperty(staffKey + "_Email", emailfild.getText());
            properties.setProperty(staffKey + "_Contact Number", cntctnumfield.getText());
            properties.setProperty(staffKey + "_Position", posfield.getText());
            properties.setProperty(staffKey + "_Date of Birth", dobfield.getText());
            properties.setProperty(staffKey + "_Gender", genfield.getText());
            properties.setProperty(staffKey + "_Address", statusfield.getText());
            properties.setProperty(staffKey + "_Description", descfeild.getText());

            // Save the updated properties back to the file
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
            addstaff frame = new addstaff();
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
