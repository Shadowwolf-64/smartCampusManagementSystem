package groupProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//this class needs to extend the Records class when create the method overrides (it was removed to prevent errors till they were created)
public class StaffRecords extends JPanel {
    //variables
    private final List<Object> staff = new ArrayList<>();

    public void staffRecords(JPanel staffInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //JLabels for the student input fields in the userInputPanel
        JLabel staffName = new JLabel("Staff Name:");
        JLabel department = new JLabel("Department:");
        JLabel staffID = new JLabel("Staff ID:");
        JLabel officeHours = new JLabel("Office Hours:");

        //JTextFields for the above JLabels for userInputPanel
        JTextField name = new JTextField(10);
        JTextField dept = new JTextField(10);
        JTextField id = new JTextField(10);
        JTextField hours = new JTextField(10);

        //adding the layout and constraints for the studentInputCard
        staffInputCard.setLayout(layout);
        //positioning and adding JLabels and JTextFields to the studentInputCard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        staffInputCard.add(staffName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        staffInputCard.add(name, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        staffInputCard.add(staffID, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        staffInputCard.add(id, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        staffInputCard.add(department, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        staffInputCard.add(dept, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        staffInputCard.add(officeHours, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        staffInputCard.add(hours, gbc);
    }
}
