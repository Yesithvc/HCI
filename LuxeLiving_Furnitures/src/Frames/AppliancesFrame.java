package Frames;

import Components.ButtonUtils;
import Frames.FurniturePage.FunitureDetails;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppliancesFrame extends JFrame {

    public AppliancesFrame() {
        setTitle("Phoenix Furnitures - Appliances");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header colors
        Color orange = new Color(255, 234, 222); //new Color(235, 153, 118)
        Color brown = new Color(139, 69, 19);
        Color red = new Color(204, 0, 0);
        Color bgColor = new Color(255, 234, 222); // light background

        // Create header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(orange);

        // Appliances title
        JLabel titleLabel = new JLabel("Furniture", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        // Create grid panel for images
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 3, 15, 15)); // 2 rows, 3 columns
        gridPanel.setBackground(bgColor);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Sample image paths and labels
        String[] imagePaths = {
                "/Resources/images/TV21.jpg",
                "/Resources/images/drawer.jpg",
                "/Resources/images/sofa1.jpg",
                "/Resources/images/chr1.jpg",
                "/Resources/images/bed2.jpg",
                "/Resources/images/chair21.jpg"
        };
        String[] labels = {"TV", "Drawer", "Sofa", "chair", "Bed", "Wood chair"};

        for (int i = 0; i < imagePaths.length; i++) {
            int index = i;
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePaths[i]));

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createLineBorder(brown, 2));

            JButton imageButton = ButtonUtils.createImageButton(icon, null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FunitureDetails funitureDetails = new FunitureDetails();
                    funitureDetails.setVisible(true);
                }
            });

            JLabel textLabel = new JLabel(labels[i], SwingConstants.CENTER);
            textLabel.setFont(new Font("Arial", Font.BOLD, 14));
            textLabel.setForeground(red);
            textLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            panel.add(imageButton, BorderLayout.CENTER);
            panel.add(textLabel, BorderLayout.SOUTH);

            gridPanel.add(panel);
        }

        add(gridPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppliancesFrame frame = new AppliancesFrame();
            frame.setVisible(true);  // Only set visible here
        });
    }
}

// Optional: You can keep your custom border class if needed
class CustomBorderFactory {
    public static Border createRoundedBorder(int radius) {
        return new RoundedBorder(radius);
    }

    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
}
