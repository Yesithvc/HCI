package Frames.User;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class updatedetails extends JFrame {

    private JTextField namefield;
    private JTextField possitionfild;
    private JTextField Addressfield;
    private JTextField phonenumber;
    private JTextField dobfield;
    private JTextField descfeild;

    public updatedetails() {

        Sidebar sidebar = new Sidebar();
        JPanel btnpannel = new JPanel(new BorderLayout());
        btnpannel.setPreferredSize(new Dimension(900, 600));
        btnpannel.setBackground(new Color(255, 234, 222)); // New background color

        // Create a panel for holding top details
        JPanel staffPanel = new JPanel(new BorderLayout());
        staffPanel.setBackground(new Color(255, 234, 222)); // New background color

        JLabel upLabel = new JLabel("Update the User");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));

        // Center the title
        upLabel.setHorizontalAlignment(SwingConstants.CENTER);
        staffPanel.add(upLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        centerPanel.setBackground(new Color(255, 234, 222)); // New background color

        ImageIcon pp = new ImageIcon("src/Resources/images/user21.jpg");
        Image ppimage = pp.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
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
        detailsPanel.setBackground(new Color(255, 234, 222)); // New background color

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
        JLabel positionLabel = new JLabel("Position:");
        Font posfont = new Font(positionLabel.getFont().getName(), Font.BOLD, 16);
        positionLabel.setFont(posfont);
        detailsPanel.add(positionLabel, gbc);

        gbc.gridx = 1;
        possitionfild = new JTextField(20);
        possitionfild.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(possitionfild, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel addressLabel = new JLabel("Address :");
        Font addfont = new Font(addressLabel.getFont().getName(), Font.BOLD, 16);
        addressLabel.setFont(addfont);
        detailsPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        Addressfield = new JTextField(20);
        Addressfield.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(Addressfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel numLabel = new JLabel("Phone Number:");
        Font numfont = new Font(numLabel.getFont().getName(), Font.BOLD, 16);
        numLabel.setFont(numfont);
        detailsPanel.add(numLabel, gbc);

        gbc.gridx = 1;
        phonenumber = new JTextField(20);
        phonenumber.setPreferredSize(new Dimension(100, 30));
        detailsPanel.add(phonenumber, gbc);

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
        saveButton.setBackground(new Color(139, 69, 19)); // New button color

        detailsPanel.add(saveButton, gbc);

        saveButton.addActionListener(new ActionListener() {
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

        detailsPanel.setPreferredSize(new Dimension(800, 100));

        getContentPane().add(detailsPanel, BorderLayout.EAST);
        getContentPane().add(sidebar, BorderLayout.WEST);
    }

    private void saveData() throws FileNotFoundException {
        Properties properties = new Properties();
        try {
            String filePath = "C:/Users/Manul Perera/IdeaProjects/Phoenix_Furnitures/Saved_Items/user.properties";
            File file = new File(filePath);

            if (file.exists()) {
                FileInputStream fileInput = new FileInputStream(file);
                properties.load(fileInput);
                fileInput.close();
            }

            properties.setProperty("Name", namefield.getText());
            properties.setProperty("Position", possitionfild.getText());
            properties.setProperty("Address", Addressfield.getText());
            properties.setProperty("Phone Number", phonenumber.getText());
            properties.setProperty("Date of Birth", dobfield.getText());
            properties.setProperty("Description", descfeild.getText());

            FileOutputStream fileOut = new FileOutputStream(filePath);
            properties.store(fileOut, "Furniture Details");
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Data updated successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            updatedetails frame = new updatedetails();
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
