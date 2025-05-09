package Frames.Staff;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class member extends JFrame {

    // Simulating local storage using a Map for staff details.
    private Map<String, Staff> staffStorage = new HashMap<>();

    public member() {
        super("Member");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,600);
        Sidebar sidebar = new Sidebar();
        this.add(sidebar,BorderLayout.WEST);

        JPanel btnpannel = new JPanel(new BorderLayout());
        btnpannel.setPreferredSize(new Dimension(900, 600));
        btnpannel.setBackground(Color.WHITE);

        // Create a panel for holding top details
        JPanel staffPanel = new JPanel(new BorderLayout());
        staffPanel.setBackground(Color.white);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        centerPanel.setBackground(Color.white);

        JLabel upLabel = new JLabel("Staff");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));
        staffPanel.add(upLabel, BorderLayout.NORTH);

        // Image for placeholder profile
        ImageIcon pp = new ImageIcon("src/Resources/images/Male.png");
        Image ppimage = pp.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JButton addbtn = new JButton(new ImageIcon(ppimage));
        addbtn.setPreferredSize(new Dimension(250, 600));
        addbtn.setOpaque(false);
        addbtn.setContentAreaFilled(false);
        addbtn.setBorderPainted(false);
        centerPanel.add(addbtn);

        staffPanel.add(centerPanel, BorderLayout.CENTER);

        btnpannel.add(staffPanel, BorderLayout.NORTH);

        getContentPane().add(btnpannel, BorderLayout.CENTER);

        // Initialize staffStorage with some sample staff details
        staffStorage.put("1", new Staff("Jhone Perera", "0717542873", "Manager", "Kohuwala Nugegoda", "05-03-1999", "Level 2 designer and Co-owner of this project"));
        staffStorage.put("2", new Staff("Alex Fernando", "0712345678", "Assistant Manager", "Colombo", "12-08-1992", "Support team member"));

        // Create and display the details panel for selected staff
        String staffId = "1";  // Simulating selection of staff with ID 1
        displayStaffDetails(staffId);

    }

    private void displayStaffDetails(String staffId) {
        Staff staff = staffStorage.get(staffId);  // Fetch staff details from local storage

        if (staff != null) {
            JPanel detailsPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(60, 60, 0, 50);
            detailsPanel.setBackground(Color.LIGHT_GRAY);

            gbc.gridx = 0;
            gbc.gridy = 0;
            detailsPanel.add(new JLabel("Name:"), gbc);
            gbc.gridx = 1;
            detailsPanel.add(new JLabel(staff.getName()), gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            detailsPanel.add(new JLabel("Phone number:"), gbc);
            gbc.gridx = 1;
            detailsPanel.add(new JLabel(staff.getPhoneNumber()), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            detailsPanel.add(new JLabel("Position:"), gbc);
            gbc.gridx = 1;
            detailsPanel.add(new JLabel(staff.getPosition()), gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            detailsPanel.add(new JLabel("Address:"), gbc);
            gbc.gridx = 1;
            detailsPanel.add(new JLabel(staff.getAddress()), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            detailsPanel.add(new JLabel("Date of birth:"), gbc);
            gbc.gridx = 1;
            detailsPanel.add(new JLabel(staff.getDateOfBirth()), gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            detailsPanel.add(new JLabel("Description:"), gbc);
            gbc.gridx = 1;
            detailsPanel.add(new JLabel(staff.getDescription()), gbc);

            gbc.weightx = 0;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            gbc.gridy++;
            detailsPanel.add(new JLabel(), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 1;
            ImageIcon edtIcon = new ImageIcon("src/images/Edit.png");
            Image edtImg = edtIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JButton editButton = new JButton(new ImageIcon(edtImg));
            editButton.setPreferredSize(new Dimension(100, 50));
            editButton.setOpaque(false);
            editButton.setContentAreaFilled(false);
            editButton.setBorderPainted(false);
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle edit action
                }
            });

            detailsPanel.add(editButton, gbc);

            gbc.gridx = 1;
            ImageIcon deleteIcon = new ImageIcon("src/images/Delete.png");
            Image deleteImg = deleteIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JButton deleteButton = new JButton(new ImageIcon(deleteImg));
            deleteButton.setPreferredSize(new Dimension(100, 350));
            deleteButton.setOpaque(false);
            deleteButton.setContentAreaFilled(false);
            deleteButton.setBorderPainted(false);
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        staffStorage.remove(staffId);  // Simulating removal from local storage
                        JOptionPane.showMessageDialog(null, "Item Deleted");
                    }
                }
            });
            detailsPanel.add(deleteButton, gbc);

            detailsPanel.setPreferredSize(new Dimension(800, 600));
            getContentPane().add(detailsPanel, BorderLayout.EAST);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            member frame = new member();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Welcome");

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int screenWidth = toolkit.getScreenSize().width;
            int screenHeight = toolkit.getScreenSize().height;
            frame.setSize(screenWidth, screenHeight);
            frame.setVisible(true);
        });
    }

    // Simulating a staff class to hold details
    public class Staff {
        private String name;
        private String phoneNumber;
        private String position;
        private String address;
        private String dateOfBirth;
        private String description;

        public Staff(String name, String phoneNumber, String position, String address, String dateOfBirth, String description) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.position = position;
            this.address = address;
            this.dateOfBirth = dateOfBirth;
            this.description = description;
        }

        public String getName() { return name; }
        public String getPhoneNumber() { return phoneNumber; }
        public String getPosition() { return position; }
        public String getAddress() { return address; }
        public String getDateOfBirth() { return dateOfBirth; }
        public String getDescription() { return description; }
    }
}
