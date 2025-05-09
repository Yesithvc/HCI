package Components;

import Frames.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sidebar extends JPanel {

    private static JLabel createIconLabel(ImageIcon icon) {
        JLabel label = new JLabel(icon);
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return label;
    }

    private static JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(235, 153, 118));
        button.setPreferredSize(new Dimension(width, height));
        button.setBorderPainted(false);
        return button;
    }

    JButton home, interior, history, account, logout;
    JPanel subPanel1, brandName, navPanel;
    JLabel nameLabel;
    JLabel imageLabel1;
    JLabel nameLabel2;

    public Sidebar() {
        setLayout(new BorderLayout());
        setBackground(new Color(235, 153, 118)); // Changed the sidebar background color
        setPreferredSize(new Dimension(200, 650));

        // Brand-name panel
        brandName = new JPanel(new GridLayout(1, 2));
        brandName.setBackground(new Color(235, 153, 118)); // Changed the sidebar background color

        ImageIcon image1 = new ImageIcon("src/Resources/images/logo11.png");
        Image scaledImage = image1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        nameLabel = new JLabel("LuxeLiving");
        nameLabel.setForeground(Color.WHITE);
        nameLabel2 = new JLabel("Furniture");
        nameLabel2.setForeground(Color.WHITE);

        JPanel labelsPanel = new JPanel(new GridLayout(2, 1));
        labelsPanel.setBackground(new Color(235, 153, 118)); // Changed the sidebar background color
        labelsPanel.add(nameLabel);
        labelsPanel.add(nameLabel2);
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        imageLabel1 = new JLabel(scaledIcon);

        brandName.add(imageLabel1, BorderLayout.WEST);
        brandName.add(labelsPanel, BorderLayout.CENTER);

        // Nav panel
        navPanel = new JPanel(new BorderLayout());
        navPanel.setBackground(new Color(235, 153, 118)); // Changed the sidebar background color

        // Create buttons
        home = createButton("Home", 80, 30);
        interior = createButton("Rooms", 80, 30);
        history = createButton("History", 80, 30);
        account = createButton("Account", 80, 30);
        logout = createButton("Logout", 80, 30);

        // Button panel - now includes account and logout
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.setBackground(new Color(235, 153, 118)); // Changed the sidebar background color
        buttonPanel.add(home);
        buttonPanel.add(interior);
        buttonPanel.add(history);
        buttonPanel.add(account);
        buttonPanel.add(logout);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, -44, 20, 0));

        // Icons
        ImageIcon homeIcon = new ImageIcon("src/Resources/images/Home.png");
        ImageIcon roomIcon = new ImageIcon("src/Resources/images/Interior.png");
        ImageIcon historyIcon = new ImageIcon("src/Resources/images/history.png");
        ImageIcon accountIcon = new ImageIcon("src/Resources/images/Account.png");
        ImageIcon logoutIcon = new ImageIcon("src/Resources/images/Logout.png");

        int iconWidth = 20;
        int iconHeight = 20;

        homeIcon = new ImageIcon(homeIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_DEFAULT));
        roomIcon = new ImageIcon(roomIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_DEFAULT));
        historyIcon = new ImageIcon(historyIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_DEFAULT));
        accountIcon = new ImageIcon(accountIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_DEFAULT));
        logoutIcon = new ImageIcon(logoutIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_DEFAULT));

        // Icon panel
        JPanel iconPanel = new JPanel(new GridLayout(5, 1));
        iconPanel.setBackground(new Color(235, 153, 118)); // Changed the sidebar background color
        iconPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        iconPanel.add(createIconLabel(homeIcon));
        iconPanel.add(createIconLabel(roomIcon));
        iconPanel.add(createIconLabel(historyIcon));
        iconPanel.add(createIconLabel(accountIcon));
        iconPanel.add(createIconLabel(logoutIcon));

        // Combine icons and buttons
        JPanel navcontent = new JPanel(new GridLayout(1, 2));
        navcontent.setBackground(new Color(235, 153, 118)); // Changed the sidebar background color
        navcontent.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        navcontent.add(iconPanel);
        navcontent.add(buttonPanel);

        navPanel.add(navcontent);

        // Add everything to the sidebar
        add(brandName, BorderLayout.NORTH);
        add(navPanel, BorderLayout.CENTER);

        // Action listeners
        home.addActionListener(e -> {
            HomeFrame homeFrame = new HomeFrame();
            homeFrame.setVisible(true);
        });

        interior.addActionListener(e -> {
            RoomDesigner roomDesigner = new RoomDesigner();
            roomDesigner.setVisible(true);
        });

        history.addActionListener(e -> {
            HistoryFrame historyFrame = new HistoryFrame();
            historyFrame.setVisible(true);
        });

        account.addActionListener(e -> {
            // Add your account frame action here
            JOptionPane.showMessageDialog(null, "Account clicked!");
        });

        logout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Or redirect to login page
            }
        });
    }
}
