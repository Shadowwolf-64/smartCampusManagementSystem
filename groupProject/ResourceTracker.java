package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResourceTracker extends JPanel{
    //variables
    private final List<Object> books = new ArrayList<>();
    private final List<Object> labEquipment = new ArrayList<>();

    private final TableModel bookModel;
    private final TableModel labEquipModel;
    Book book = new Book();
    LabEquipment labEquipment1 = new LabEquipment();
    Management management = new Management();

    //JLabels for the student input fields in the userInputPanel
    JLabel resourceName = new JLabel("Resource Name: ");
    JLabel resourceID = new JLabel("Resource ID:");
    JLabel availabilityLabel = new JLabel("Resource Availability: ");
    JLabel departmentOrAuthorLabel = new JLabel("Department or Author:  ");

    //JTextFields for the above JLabels for userInputPanel
    JTextField name = new JTextField(10);
    JTextField resId = new JTextField(10);
    JTextField availability = new JTextField(10);
    JTextField departmentOrAuthor = new JTextField(10);

    public ResourceTracker(TableModel bookModel, TableModel labEquipModel) {
        this.bookModel = bookModel;
        this.labEquipModel = labEquipModel;
    }

    public void resourceTracker(JPanel bookingInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Resources");
        //adds border and title to the card
        bookingInputCard.setBorder(blackline);

        //adding the layout and constraints for the bookingInputCard
        bookingInputCard.setLayout(layout);
        //positioning and adding JLabels and JTextFields to the bookingInputCard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        bookingInputCard.add(resourceName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        bookingInputCard.add(name, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        bookingInputCard.add(resourceID, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        bookingInputCard.add(resId, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        bookingInputCard.add(departmentOrAuthorLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        bookingInputCard.add(departmentOrAuthor, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        bookingInputCard.add(availabilityLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        bookingInputCard.add(availability, gbc);
    }

    public void addBook(JLabel infoLabel) {
        String bookname = name.getText();
        String bookID = resId.getText();
        String available = availability.getText();
        String deptOrAuth = departmentOrAuthor.getText();

        //sets the time limit for displaying error/feedback messages when adding book
        int delay = 4500;

        if(Objects.equals(bookname, "") || Objects.equals(deptOrAuth, "")) {
            infoLabel.setText("Please fill in all the boxes correctly");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        }else if (!Objects.equals(String.valueOf(available), "Available") || Objects.equals(available, "") && resId.getText().isEmpty()) {
            bookID = String.valueOf(management.generateNewID());
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this Book?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    bookModel.addRow(new Object[]{bookname, deptOrAuth, bookID, "Available", false});
                    infoLabel.setText("New book added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    departmentOrAuthor.setText("");
                    resId.setText("");
                    availability.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }

        }else if (resId.getText().isEmpty()) {
            bookID = String.valueOf(management.generateNewID());
            // confirm addition of book //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this Book?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    bookModel.addRow(new Object[]{bookname, deptOrAuth, bookID, available, false});
                    infoLabel.setText("New book added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    departmentOrAuthor.setText("");
                    resId.setText("");
                    availability.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        } else {
            // confirm addition of book //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this student?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    bookModel.addRow(new Object[]{bookname, deptOrAuth, bookID, available, false});
                    infoLabel.setText("New book added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    departmentOrAuthor.setText("");
                    resId.setText("");
                    availability.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public void addLabEquip(JLabel infoLabel) {
        String equipName = name.getText();
        String equipID = resId.getText();
        String available = availability.getText();
        String deptOrAuth = departmentOrAuthor.getText();

        //sets the time limit for displaying error/feedback messages when adding resources
        int delay = 4500;

        if(Objects.equals(equipName, "") || Objects.equals(deptOrAuth, "")) {
            infoLabel.setText("Please fill in all the boxes correctly");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        }else if (!Objects.equals(String.valueOf(available), "Available") || Objects.equals(available, "") && resId.getText().isEmpty()) {
            equipID = String.valueOf(management.generateNewID());
            // confirm addition of lab equipment
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this lab equipment?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    labEquipModel.addRow(new Object[]{equipName, deptOrAuth, equipID, available, false});
                    infoLabel.setText("New lab equipment added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    departmentOrAuthor.setText("");
                    resId.setText("");
                    availability.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        } else if (resId.getText().isEmpty()) {
            equipID = String.valueOf(management.generateNewID());
            // confirm addition of lab equipment
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this lab equipment?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    labEquipModel.addRow(new Object[]{equipName, deptOrAuth, equipID, available, false});
                    infoLabel.setText("New lab equipment added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    departmentOrAuthor.setText("");
                    resId.setText("");
                    availability.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        } else {
            // confirm addition of lab equipment //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this student?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    labEquipModel.addRow(new Object[]{equipName, equipID, deptOrAuth, available, false});
                    infoLabel.setText("New lab equipment added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    departmentOrAuthor.setText("");
                    resId.setText("");
                    availability.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
