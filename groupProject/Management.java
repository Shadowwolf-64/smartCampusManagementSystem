package groupProject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Management extends JSplitPane {

    public void addTabChangeListener(JTabbedPane tabbedPane, JPanel userInputPanel, CardLayout cardLayout) {
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                switch (selectedIndex) {
                    case 0 -> cardLayout.show(userInputPanel, "Student");
                    case 1 -> cardLayout.show(userInputPanel, "Rooms");
                    case 2, 3 -> cardLayout.show(userInputPanel, "Booking");
                    case 4 -> cardLayout.show(userInputPanel, "Staff");

                }
            }
        });
    }
    
    // this might need to be looked at again once we have data to populate the tables //
    public void searchById(JTable... tables) {
        // asks the user to enter an id //
        String id = JOptionPane.showInputDialog(null, "Enter ID to search:", "Search by ID", JOptionPane.QUESTION_MESSAGE);

        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ID entered.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Iterate through all tables //
        for (JTable table : tables) {
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object cellValue = table.getValueAt(row, col);
                    if (cellValue != null && cellValue.toString().equalsIgnoreCase(id)) {
                        // get the row as an object array //
                        StringBuilder rowData = new StringBuilder();
                        for (int column = 0; column < table.getColumnCount(); column++) {
                            rowData.append(table.getColumnName(column)).append(": ")
                                    .append(table.getValueAt(row, column)).append("\n");
                        }
                        // display the result //
                        JOptionPane.showMessageDialog(null, "Match found in table: " + table.getName() + "\n\n" + rowData, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        }

        // if no match is found
        JOptionPane.showMessageDialog(null, "No match found for ID: " + id, "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }
}

