package Frames.FurniturePage;

import Components.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunitureDetails extends JFrame {

    public FunitureDetails() {
//        Sidebar sidebar = new Sidebar();

        JPanel buttonpanel = new JPanel(new BorderLayout()); // Use BorderLayout for buttonpanel
        buttonpanel.setPreferredSize(new Dimension(900, 600)); // Setting preferred size of the button panel
        buttonpanel.setBackground(Color.WHITE);

        // Create a panel for holding the "hi" label
        JPanel hiPanel = new JPanel(new FlowLayout(FlowLayout.LEADING)); // Use FlowLayout.LEADING for hiPanel
        hiPanel.setBackground(Color.WHITE);
        // Add the "hi" label to the hiPanel
        JLabel upLabel = new JLabel("Appliances");
        upLabel.setFont(upLabel.getFont().deriveFont(Font.BOLD, 24f));
        hiPanel.add(upLabel);

        JLabel subHead = new JLabel("Edit");

        // Add the hiPanel to the NORTH position of buttonpanel
        buttonpanel.add(hiPanel, BorderLayout.NORTH);

        // Create a panel for holding the buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Use FlowLayout for buttonsPanel
        buttonsPanel.setBackground(Color.WHITE);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 70)));

        // Adding buttons to buttonsPanel
        ImageIcon pp = new ImageIcon(getClass().getResource("/Resources/images/bed1.png"));
        Image ppimage = pp.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JButton addbtn = new JButton(new ImageIcon(ppimage));
        addbtn.setPreferredSize(new Dimension(700, 500)); // Setting preferred size of Add button
        addbtn.setOpaque(false);
        addbtn.setContentAreaFilled(false);
        addbtn.setBorderPainted(false);
        buttonsPanel.add(addbtn);


        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 70)));

        // Adding buttons to buttonsPanel
        ImageIcon edtIcon = new ImageIcon(getClass().getResource("/Resources/images/Edit.png"));
        Image edtImg = edtIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton editButton = new JButton(new ImageIcon(edtImg));
        editButton.setPreferredSize(new Dimension(100, 50)); // Setting preferred size of Edit button
        editButton.setOpaque(false);
        editButton.setContentAreaFilled(false);
        editButton.setBorderPainted(false);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPage editPage = new EditPage();
                editPage.setVisible(true);
            }
        });
        buttonsPanel.add(editButton);

        // Adding delete button
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/Resources/images/Delete.png"));
        Image deleteImg = deleteIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton deleteButton = new JButton(new ImageIcon(deleteImg));
        deleteButton.setPreferredSize(new Dimension(100, 50)); // Setting preferred size of Delete button
        deleteButton.setOpaque(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Item Deleted");
                }
            }
        });
        buttonsPanel.add(deleteButton);

        buttonsPanel.add(Box.createRigidArea(new Dimension(20, 90)));

        //Add the buttonsPanel to the CENTER position of buttonpanel
        buttonpanel.add(buttonsPanel, BorderLayout.CENTER);

        // Add buttonpanel to the JFrame
        getContentPane().add(buttonpanel, BorderLayout.CENTER);

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(60, 60, 0, 50);
        detailsPanel.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        detailsPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        detailsPanel.add(new JLabel("King side bed"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        detailsPanel.add(new JLabel("Date:"), gbc);

        gbc.gridx = 1;
        detailsPanel.add(new JLabel("23/04/2023"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        detailsPanel.add(new JLabel("Price:"), gbc);

        gbc.gridx = 1;
        detailsPanel.add(new JLabel("Rs 100,000"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        detailsPanel.add(new JLabel("Size:"), gbc);

        gbc.gridx = 1;
        detailsPanel.add(new JLabel("6 * 4ft"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        detailsPanel.add(new JLabel("Category :"), gbc);

        gbc.gridx = 1;
        detailsPanel.add(new JLabel("Bed"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        detailsPanel.add(new JLabel("Description :"), gbc);

        gbc.gridx = 1;
        detailsPanel.add(new JLabel("Indulge in spacious comfort with our luxurious king-size bed. "), gbc);



        gbc.weightx = 0; // Set weightx to 1.0 for all columns to make them equally wide
        gbc.gridx = 0; // Reset gridx to 0 for the last component
        gbc.gridwidth = 2; // Set gridwidth to 2 to make the component span across two columns
        gbc.gridy++; // Increment gridy to move to the next row
        detailsPanel.add(new JLabel(), gbc); // Add an empty component to fill the last row

        // Create and add the edit button within the details panel
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        detailsPanel.add(editButton, gbc);

        // Create and add the delete button within the details panel
        gbc.gridx = 1;
        detailsPanel.add(deleteButton, gbc);

        detailsPanel.setPreferredSize(new Dimension(800, 600));

        getContentPane().add(detailsPanel, BorderLayout.EAST);
//        this.add(sidebar,BorderLayout.WEST);

    }

    public static void main(String[] args) {
        FunitureDetails furnitureDetails = new FunitureDetails();
        furnitureDetails.setTitle("Phoenix Furniture");
        furnitureDetails.setSize(990, 950);
        furnitureDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        furnitureDetails.setVisible(true);
    }

}