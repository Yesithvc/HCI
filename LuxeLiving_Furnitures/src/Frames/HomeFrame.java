package Frames;

import Frames.FurniturePage.FunitureDetails;
import Frames.Staff.staffdetail;
import Frames.Suppliers.add;
import Frames.User.userdetails;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class HomeFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JPanel sidebar;

    public HomeFrame() {
        setTitle("LuxeLiving Furniture - Home");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Color.WHITE);

        sidebar = createSidebar();
        initializeContentPanels();

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        cardLayout.show(contentPanel, "Home");
    }

    private void initializeContentPanels() {
        AppliancesFrame appliancesFrame = new AppliancesFrame();
        contentPanel.add(appliancesFrame.getContentPane(), "Home");

        RoomSpecificationUI roomSpecificationUI = new RoomSpecificationUI();
        contentPanel.add(roomSpecificationUI.getContentPane(), "Room Design");

        staffdetail staff = new staffdetail();
        contentPanel.add(staff.getContentPane(), "Staff");

        FunitureDetails funitureDetails = new FunitureDetails();
        contentPanel.add(funitureDetails.getContentPane(), "Furnitures");

        HistoryFrame historyFrame = new HistoryFrame();
        contentPanel.add(historyFrame.getContentPane(), "History");

        add add = new add();
        contentPanel.add(add.getContentPane(), "Suppliers");

        userdetails userDetails = new userdetails();
        contentPanel.add(userDetails.getContentPane(), "Account");

        LoginFrame loginFrame = new LoginFrame();
        contentPanel.add(loginFrame.getContentPane(), "Logout");
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BorderLayout());
        sidebar.setBackground(new Color(235, 153, 118)); // Coral/salmon color
        sidebar.setPreferredSize(new Dimension(250, getHeight()));

        // Top logo section
        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(new Color(235, 153, 118));
        logoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 40, 20));

        ImageIcon logoIcon = scaleImageIcon(new ImageIcon(getClass().getResource("/Resources/images/logo11.png")), 60, 60);
        JLabel logoLabel = new JLabel(logoIcon, SwingConstants.CENTER);

        JLabel nameLabel = new JLabel("<html><center>LuxeLiving<br/>Furniture</center></html>", SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JPanel logoAndNamePanel = new JPanel(new BorderLayout());
        logoAndNamePanel.setBackground(new Color(235, 153, 118));
        logoAndNamePanel.add(logoLabel, BorderLayout.NORTH);
        logoAndNamePanel.add(Box.createVerticalStrut(15), BorderLayout.CENTER);
        logoAndNamePanel.add(nameLabel, BorderLayout.SOUTH);

        logoPanel.add(logoAndNamePanel, BorderLayout.CENTER);
        sidebar.add(logoPanel, BorderLayout.NORTH);

        // Navigation buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBackground(new Color(235, 153, 118));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        String[] labels = {
                "Home", "Room Design", "History", "Account", "Logout"
        };
        String[] icons = {
                "/Resources/images/icon-home.png",
                "/Resources/images/icon-roomdesigner.png",
                "/Resources/images/icon-furniture.png",
                "/Resources/images/history.png",
                "/Resources/images/icon-logout.png"
        };

        for (int i = 0; i < labels.length; i++) {
            JButton button = createSidebarButton(labels[i], icons[i]);
            final String label = labels[i];

            if (label.equals("Logout")) {
                button.addActionListener(e -> {
                    dispose();
                    new LoginFrame().setVisible(true);
                });
            } else {
                button.addActionListener(e -> cardLayout.show(contentPanel, label));
            }

            buttonsPanel.add(button);
            if (i < labels.length - 1) {
                buttonsPanel.add(Box.createVerticalStrut(10));
            }
        }

        // Add some space at the bottom
        buttonsPanel.add(Box.createVerticalGlue());
        sidebar.add(buttonsPanel, BorderLayout.CENTER);
        return sidebar;
    }

    private ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        if (icon == null) {
            return new ImageIcon(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
        }
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    private JButton createSidebarButton(String text, String iconPath) {
        final int ICON_SIZE = 24;
        ImageIcon icon = new ImageIcon(new BufferedImage(ICON_SIZE, ICON_SIZE, BufferedImage.TYPE_INT_ARGB));

        URL iconURL = getClass().getResource(iconPath);
        if (iconURL != null) {
            icon = new ImageIcon(new ImageIcon(iconURL).getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH));
        }

        JButton button = new JButton(text, icon);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        button.setPreferredSize(new Dimension(200, 50));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(235, 153, 118));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(15);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(220, 140, 105)); // Slightly darker on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(235, 153, 118));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            HomeFrame homeFrame = new HomeFrame();
            homeFrame.setVisible(true);
            homeFrame.setLocationRelativeTo(null);
        });
    }
}