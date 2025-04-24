package groupProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

public class Management extends JSplitPane {

    public void addTabChangeListener(JTabbedPane tabbedPane, JPanel userInputPanel, CardLayout cardLayout) {
        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            switch (selectedIndex) {
                case 0 -> cardLayout.show(userInputPanel, "Student");
                case 1 -> cardLayout.show(userInputPanel, "Rooms");
                case 2, 3 -> cardLayout.show(userInputPanel, "Booking");
                case 4 -> cardLayout.show(userInputPanel, "Staff");
            }
        });
    }

    //generate an ID for any staff, student, room, or resource
    public int generateNewID(JTable... tables) {
        int newID = (int)(Math.random()* 10000) + 1;
        for(JTable table : tables) {
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object cellValue = table.getValueAt(row, col);
                    while (cellValue != null && cellValue.toString().equalsIgnoreCase(String.valueOf(newID))) {
                        newID = (int)(Math.random()* 10000) + 1;
                    }
                }
            }
        }
        return newID;
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
                        for (int column = 0; column < table.getColumnCount() -1; column++) {
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

    // method to remove the row that is checked in a table //
    public void removeCheckedRow(JLabel infoLabel, JTable ... tables) {
        int delay = 5000;
        for (JTable table : tables) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            int rows = tableModel.getRowCount();
            if (rows == 0 ) {
                infoLabel.setText("No tables loaded, please press the load button.");
                infoLabel.setVisible(true);
                ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                new Timer(delay, taskPerformed).start();
            } else {
                // Iterate through rows in reverse order to prevent issues with the index when removing more than 1 row //
                for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                    // Assumes the checkbox column is the last column
                    int checkboxColumnIndex = tableModel.getColumnCount() - 1;

                    // Check if the checkbox is selected //
                    Boolean isChecked = (Boolean) tableModel.getValueAt(i, checkboxColumnIndex);
                    if (isChecked != null && isChecked) {
                        // confirm removal //
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this rows data?", "Confirm removal", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        // Remove the row
                        if (confirm == JOptionPane.YES_OPTION) {
                            tableModel.removeRow(i);
                        }
                    } else {
                        infoLabel.setText("No checkbox selected. Please select a checkbox.");
                        infoLabel.setVisible(true);
                        ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                        new Timer(delay, taskPerformed).start();
                    }
                }
            }
        }
    }


    public void modifyCheckedRow(JLabel infoLabel, JTable ... tables) {
        int delay = 5000;
        for (JTable table : tables) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            int rows = tableModel.getRowCount();
            if (rows == 0 ) {
                infoLabel.setText("No tables loaded, please press the load button.");
                infoLabel.setVisible(true);
                ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                new Timer(delay, taskPerformed).start();
            } else {
                // Assumes the checkbox column is the last column //
                for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                int checkboxColumnIndex = tableModel.getColumnCount() - 1;

                    // Check if the checkbox is selected //
                    Boolean isChecked = (Boolean) tableModel.getValueAt(i, checkboxColumnIndex);
                    if (isChecked != null && isChecked) {

                        // Iterate through rows in reverse order to prevent issues with the index when removing more than 1 row //
                        for (int col = 0; col < checkboxColumnIndex; col++) {
                            String columnName = tableModel.getColumnName(col);
                            Object currentValue = tableModel.getValueAt(i, col);

                            // Prompt the user for a new value
                            String newValue = JOptionPane.showInputDialog(
                                    null,
                                    "Enter new value for " + columnName + " (current: " + currentValue + "):",
                                    "Modify Row",
                                    JOptionPane.QUESTION_MESSAGE
                            );

                                // update if user provides input //
                                if (newValue != null && !newValue.trim().isEmpty()) {
                                    tableModel.setValueAt(newValue, i, col);
                                }
                            }
                        // uncheck the box after changes are made //
                        tableModel.setValueAt(false, i, checkboxColumnIndex);
                    } else {
                        infoLabel.setText("No checkbox selected. Please select a checkbox.");
                        infoLabel.setVisible(true);
                        ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                        new Timer(delay, taskPerformed).start();
                    }
                }
            }
        }
    }

    public void saveToFile(JLabel infoLabel, String filePath, JTable ... tables) {
        File fileToSave = new File(filePath);
        //sets time for how long message will be displayed //
        int delay = 5000;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
            // iterate through all tables //
        for (JTable table : tables) {
            // writes the table names //
            writer.write("\n" + table.getName() + "\n");
            // gets the table model to access the data //
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            //writes column names to file //
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                writer.write(tableModel.getColumnName(i) + "\t");
                }
                writer.write("\n");

            // writes the row to file //
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount() - 1; j++) {
                    Object value = tableModel.getValueAt(i, j);
                    writer.write((value != null ? value.toString() : "") + "\t");
                    }
                    writer.write("\n");
                }
            }

            // saved successfully message //
            infoLabel.setText("Saved Successfully");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        } catch (IOException ex) {
            //error message if something goes wrong //
            infoLabel.setText("Error saving: " + ex.getMessage());
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        }
    }

    public void loadFromFile(JLabel infoLabel, String filePath, JTable ... tables) {
        File fileToLoad = new File(filePath);
        //sets time for how long message will be displayed //
        int delay = 5000;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileToLoad))) {
            String line;
            DefaultTableModel currentTableModel = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();


                //checks if table name matches line //
                for(JTable table : tables) {
                    if(line.equalsIgnoreCase(table.getName())) {
                        currentTableModel = (DefaultTableModel) table.getModel();
                        currentTableModel.setRowCount(0); // clears the existing rows //
                        break;
                    }
                }
                //skip empty lines //
                if(currentTableModel == null || line.isEmpty() || line.contains("Name") || line.contains("Table")) {
                    continue;
                }

                // add rows to current table //
                String[] rowData = line.split("\t");
                if (currentTableModel != null) {
                    //adds placeholder for checkbox column //
                    Object[] rowWithCheckbox = new Object[currentTableModel.getColumnCount()];
                    for (int i = 0; i < rowData.length; i++) {
                        rowWithCheckbox[i] = rowData[i];
                    }
                    //set checkbox to false //
                    if (rowData.length < currentTableModel.getColumnCount()) {
                        rowWithCheckbox[currentTableModel.getColumnCount() - 1] = false;
                    }
                    currentTableModel.addRow(rowWithCheckbox);
                }
            }

            //load successful message//
            infoLabel.setText("Data loaded successfully");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        } catch (IOException ex) {
            //Error message //
            infoLabel.setText("Error loading: " + ex.getMessage());
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        }
    }

    public void reserving(JLabel infoLabel, JTable... tables) {
        //sets the time limit for displaying error/feedback messages when adding tasks
        int delay = 5000;
        for (JTable table : tables) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            int rows = tableModel.getRowCount();
            if (rows == 0 ) {
                infoLabel.setText("No tables loaded, please press the load button.");
                infoLabel.setVisible(true);
                ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                new Timer(delay, taskPerformed).start();
            } else {
                // Iterate through rows in reverse order to prevent issues with the index
                for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                    // Assumes the checkbox column is the last column
                    int checkboxColumnIndex = tableModel.getColumnCount() - 1;

                    // Check if the checkbox is selected
                    Boolean isChecked = (Boolean) tableModel.getValueAt(i, checkboxColumnIndex);
                    if (isChecked != null && isChecked) {
                        for (int col = 3; col < checkboxColumnIndex; col++) {
                            Object currentValue = tableModel.getValueAt(i, col);
                            String availabilityChange1 = "In Use";
                            if (Objects.equals(String.valueOf(currentValue), "Available")) {
                                try {
                                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this reservation?", "Confirm reservation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                    // Update the row
                                    if (confirm == JOptionPane.YES_OPTION) {
                                        tableModel.setValueAt(availabilityChange1, i, col);
                                        // uncheck the box after changes are made
                                        tableModel.setValueAt(false, i, checkboxColumnIndex);
                                        infoLabel.setText("Reservation successful!"); //confirmation message
                                        infoLabel.setVisible(true);
                                        ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                                        new Timer(delay, taskPerformed).start();
                                    }
                                }catch (Exception ex) {
                                    infoLabel.setText("You screwed up!");
                                    throw new RuntimeException(ex);
                                }
                            }else {
                                JOptionPane.showMessageDialog(null, "Unable to reserve, already in use", "Reservation failure", JOptionPane.INFORMATION_MESSAGE);
                                // uncheck the box after changes are made
                                tableModel.setValueAt(false, i, checkboxColumnIndex);
                            }
                        }
                    } else {
                        infoLabel.setText("No checkbox selected. Please select a checkbox.");
                        infoLabel.setVisible(true);
                        ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                        new Timer(delay, taskPerformed).start();
                    }
                }
            }

        }
    }

    public void unreserve(JLabel infoLabel, JTable... tables) {
        //sets the time limit for displaying error/feedback messages when adding tasks
        int delay = 5000;
        for (JTable table : tables) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            // Iterate through rows in reverse order to prevent issues with the index
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                // Assumes the checkbox column is the last column
                int checkboxColumnIndex = tableModel.getColumnCount() - 1;

                // Check if the checkbox is selected
                Boolean isChecked = (Boolean) tableModel.getValueAt(i, checkboxColumnIndex);
                if (isChecked != null && isChecked) {
                    for (int col = 3; col < checkboxColumnIndex; col++) {
                        Object currentValue = tableModel.getValueAt(i, col);
                        String availabilityChange1 = "Available";
                        if (Objects.equals(String.valueOf(currentValue), "In Use")) {
                            try {
                                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this reservation?", "Confirm reservation removal", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                // Update the row
                                if (confirm == JOptionPane.YES_OPTION) {
                                    tableModel.setValueAt(availabilityChange1, i, col);
                                    // uncheck the box after changes are made
                                    tableModel.setValueAt(false, i, checkboxColumnIndex);
                                    infoLabel.setText("Reservation successfully removed!"); //confirmation message
                                    infoLabel.setVisible(true);
                                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                                    new Timer(delay, taskPerformed).start();
                                }
                            }catch (Exception ex) {
                                infoLabel.setText("You screwed up!");
                                throw new RuntimeException(ex);
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Unable to remove reservation due to being available", "Reservation removal failure", JOptionPane.INFORMATION_MESSAGE);
                            // uncheck the box after changes are made
                            tableModel.setValueAt(false, i, checkboxColumnIndex);
                        }
                    }
                }
            }
        }
    }
}

