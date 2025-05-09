package Frames;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryFrame extends JFrame {
    private JTable roomTable;
    private RoomTableModel tableModel;
    private final Color BACKGROUND_COLOR = new Color(255, 234, 222);
    private final Color BUTTON_COLOR = new Color(139, 69, 19);

    public HistoryFrame() {
        setTitle("Room History");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Title panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        getContentPane().add(mainPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Room History");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        mainPanel.add(titleLabel, BorderLayout.WEST);

        JButton viewDesignButton = new JButton("View Design");
        viewDesignButton.setBackground(BUTTON_COLOR);
        viewDesignButton.setForeground(Color.WHITE);
        viewDesignButton.setFont(viewDesignButton.getFont().deriveFont(15f));
        viewDesignButton.addActionListener(e -> new EditRoomDesigner(null).setVisible(true));
        mainPanel.add(viewDesignButton, BorderLayout.EAST);

        // Table setup
        tableModel = new RoomTableModel();
        roomTable = new JTable(tableModel);
        roomTable.setRowHeight(60);
        roomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        roomTable.setBackground(BACKGROUND_COLOR);
        roomTable.setFillsViewportHeight(true);

        // Button Renderer and Editor
        roomTable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        roomTable.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox(), true));
        roomTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        roomTable.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox(), false));

        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        loadSavedRooms();
    }

    private void loadSavedRooms() {
        File file = new File("room_design.txt");
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("Room Number: ")) {
                        String roomNumber = line.substring("Room Number: ".length());
                        tableModel.addRoom(new RoomInfo(roomNumber, "Admin", "01/01/2024", "/Resources/images/room1.png"));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Room Table Model
    class RoomTableModel extends AbstractTableModel {
        private final String[] columns = {"Room Number", "Design By", "Date", "Edit", "Delete"};
        private final List<RoomInfo> rooms = new ArrayList<>();

        public void addRoom(RoomInfo room) {
            rooms.add(room);
            fireTableRowsInserted(rooms.size() - 1, rooms.size() - 1);
        }

        @Override
        public int getRowCount() {
            return rooms.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int col) {
            return columns[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            RoomInfo room = rooms.get(row);
            switch (col) {
                case 0: return room.getRoomNumber();
                case 1: return room.getDesignBy();
                case 2: return room.getDate();
                case 3:
                case 4: return "Button";
                default: return null;
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 3 || col == 4;
        }

        public RoomInfo getRoomAt(int row) {
            return rooms.get(row);
        }

        public void removeRoom(int row) {
            rooms.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

    // Button Renderer
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setBackground(BUTTON_COLOR);
            setForeground(Color.WHITE);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText(column == 3 ? "Edit" : "Delete");
            return this;
        }
    }

    // Button Editor
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private boolean isEdit;
        private int row;

        public ButtonEditor(JCheckBox checkBox, boolean isEdit) {
            super(checkBox);
            this.isEdit = isEdit;
            button = new JButton();
            button.setOpaque(true);
            button.setBackground(BUTTON_COLOR);
            button.setForeground(Color.WHITE);
            button.addActionListener(this::handleClick);
        }

        private void handleClick(ActionEvent e) {
            RoomInfo room = tableModel.getRoomAt(row);
            if (isEdit) {
                new EditRoomDesigner(room).setVisible(true);
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.removeRoom(row);
                    JOptionPane.showMessageDialog(null, "Deleted!");
                }
            }
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            this.row = row;
            button.setText(column == 3 ? "Edit" : "Delete");
            return button;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HistoryFrame().setVisible(true));
    }
}
