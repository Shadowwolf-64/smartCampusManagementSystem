package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//this class needs to extend the Records class when create the method overrides (it was removed to prevent errors till they were created)
public class StaffRecords extends JPanel{
    //variables
    private final List<Object> staff = new ArrayList<>();

    private final TableModel staffRecordModel;
    Management management = new Management();
    Staff staff1 = new Staff();

    //JLabels for the student input fields in the userInputPanel
    JLabel staffName = new JLabel("Staff Name: ");
    JLabel department = new JLabel("Department: ");
    JLabel staffID = new JLabel("Staff ID: ");
    JLabel officeHours = new JLabel("Office Hours:  ");

    //JTextFields for the above JLabels for userInputPanel
    JTextField name = new JTextField(10);
    JTextField dept = new JTextField(10);
    JTextField id = new JTextField(10);
    JTextField hours = new JTextField(10);

    public StaffRecords(TableModel staffRecordModel) {
        this.staffRecordModel = staffRecordModel;
    }


    public void staffRecords(JPanel staffInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Staff Records");
        //adds border and title to the card
        staffInputCard.setBorder(blackline);

        //adding the layout and constraints for the staffInputCard
        staffInputCard.setLayout(layout);
        //positioning and adding JLabels and JTextFields to the staffInputCard
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

        staff1.setStaffName(name);
        staff1.setStaffID(id);
        staff1.setDepartment(dept);
        staff1.setOfficeHours(hours);
        Collections.addAll(staff, name, id, hours, dept);
    }

    public void addStaff(JLabel infoLabel) {
        String staffname = name.getText();
        String staffId = staffID.getText();
        String offHours = hours.getText();
        String depart = dept.getText();

        //sets the time limit for displaying error/feedback messages when adding tasks
        int delay = 4500;

        if(Objects.equals(staffname, "") || Objects.equals(offHours, "") || Objects.equals(depart, "")) {
            infoLabel.setText("Please fill in all the boxes correctly");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        } else if (id.getText().isEmpty()) {
            staffId = String.valueOf(management.generateNewID());
            // confirm addition of student //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this new staff member?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    staffRecordModel.addRow(new Object[]{staffname, staffId, offHours, depart, false});
                    infoLabel.setText("New staff member added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    id.setText("");
                    hours.setText("");
                    dept.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        } else {
            // confirm addition of student //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this new staff member?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    staffRecordModel.addRow(new Object[]{staffname, staffId, offHours, depart, false});
                    infoLabel.setText("New staff member added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    id.setText("");
                    hours.setText("");
                    dept.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
