package groupProject;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
    // Constructor with custom column names //
    public TableModel(String[] columnNames) {
        super(columnNames, 0);
    }

    //override method to set the data type for each column //
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3 || columnIndex == 4) {
            return Boolean.class; // Sets the "Select" column to boolean
        }
        return String.class;
    }

    // Override method to make the checkbox column editable //
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3; // Only the "Select" column is editable
    }
}
