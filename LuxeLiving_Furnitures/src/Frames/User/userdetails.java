package Frames.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userdetails extends JFrame {
    public userdetails() {
        // Main frame setup
        setTitle("User Details - Heritage Woods Furniture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 234, 222));
        setLayout(new BorderLayout(20, 20));

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(255, 234, 222));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("USER PROFILE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        //titleLabel.setForeground(new Color(255, 234, 222)); // Brown color for text
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Main Content Panel
        JPanel mainPanel = new JPanel(new BorderLayout(30, 0));
        mainPanel.setBackground(new Color(255, 234, 222));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        // User Image Panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(255, 234, 222));

        ImageIcon pp = new ImageIcon("src/Resources/images/user21.jpg");
        Image ppimage = pp.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(ppimage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        mainPanel.add(imagePanel, BorderLayout.WEST);

        // User Details Panel
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(new Color(255, 234, 222));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 20, 10, 20);

        // Create styled labels
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 16);
        Color labelColor = new Color(139, 69, 19);
        Color valueColor = Color.BLACK;

        // Add user details
        gbc.gridx = 0; gbc.gridy = 0;
        detailsPanel.add(createStyledLabel("Name:", labelFont, labelColor), gbc);
        gbc.gridx = 1;
        detailsPanel.add(createStyledLabel("Gambheera Lakmewan", valueFont, valueColor), gbc);

        gbc.gridx = 0; gbc.gridy++;
        detailsPanel.add(createStyledLabel("Phone number:", labelFont, labelColor), gbc);
        gbc.gridx = 1;
        detailsPanel.add(createStyledLabel("0711920304", valueFont, valueColor), gbc);

        gbc.gridx = 0; gbc.gridy++;
        detailsPanel.add(createStyledLabel("Position:", labelFont, labelColor), gbc);
        gbc.gridx = 1;
        detailsPanel.add(createStyledLabel("Designer Level 1", valueFont, valueColor), gbc);

        gbc.gridx = 0; gbc.gridy++;
        detailsPanel.add(createStyledLabel("Address:", labelFont, labelColor), gbc);
        gbc.gridx = 1;
        detailsPanel.add(createStyledLabel("Dhabulla road, Kurunegala", valueFont, valueColor), gbc);

        gbc.gridx = 0; gbc.gridy++;
        detailsPanel.add(createStyledLabel("Date of birth:", labelFont, labelColor), gbc);
        gbc.gridx = 1;
        detailsPanel.add(createStyledLabel("05-03-1999", valueFont, valueColor), gbc);

        gbc.gridx = 0; gbc.gridy++;
        detailsPanel.add(createStyledLabel("Description:", labelFont, labelColor), gbc);
        gbc.gridx = 1;
        detailsPanel.add(createStyledLabel("Level 1 designer and Admin of this system", valueFont, valueColor), gbc);

        // Edit Button
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(30, 0, 0, 0);

        JButton editButton = new JButton("EDIT PROFILE");
        editButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        editButton.setBackground(new Color(139, 69, 19)); // Brown button
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to edit this profile?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    updatedetails updatedetails = new updatedetails();
                    updatedetails.setVisible(true);
                }
            }
        });
        detailsPanel.add(editButton, gbc);

        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        // Add components to frame
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Frame settings
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    private JLabel createStyledLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            userdetails frame = new userdetails();
            frame.setVisible(true);
        });
    }
}