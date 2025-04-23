package groupProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class StudentRecords extends JPanel{
    //variables
    private final List<Object> students = new ArrayList<>();
    private final TableModel studentRecordModel;
    Student student = new Student();
    Management management = new Management();

    //JLabels for the student input fields in the userInputPanel
    JLabel studentNameLabel = new JLabel("Student Name: ");
    JLabel degreePath = new JLabel("Degree Pathway:  ");
    JLabel studentID = new JLabel("Student ID: ");
    JLabel grade = new JLabel("Grade: ");

    //JTextFields for the above JLabels for userInputPanel
    JTextField studentName = new JTextField(10);
    JTextField pathway = new JTextField(10);
    JTextField id = new JTextField(10);
    JTextField gradeInput = new JTextField(10);


    //constructor
    public StudentRecords(TableModel studentRecordModel) {
        this.studentRecordModel = studentRecordModel;
    }

    public void studentRecords(JPanel studentInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Student Records");
        //adds border and title to the card
        studentInputCard.setBorder(blackline);

        //adding the layout and constraints for the studentInputCard
        studentInputCard.setLayout(layout);
        //positioning and adding JLabels and JTextFields to the studentInputCard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        studentInputCard.add(studentNameLabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        studentInputCard.add(studentName, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        studentInputCard.add(studentID, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        studentInputCard.add(id,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        studentInputCard.add(degreePath, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        studentInputCard.add(pathway, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        studentInputCard.add(grade, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        studentInputCard.add(gradeInput, gbc);

        student.setStudentName(studentName);
        student.setDegreePathway(pathway);
        student.setGrade(gradeInput);
        Collections.addAll(students, studentName, pathway, gradeInput);
    }
    public void addStudent(JLabel infoLabel) {
        String name = studentName.getText();
        String path = pathway.getText();
        String stuID = id.getText();
        String grade = gradeInput.getText();

        //sets the time limit for displaying error/feedback messages when adding tasks
        int delay = 4500;

        if(Objects.equals(name, "") || Objects.equals(path, "") || Objects.equals(grade, "")) {
            infoLabel.setText("Please fill in all the boxes correctly");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        } else if (id.getText().isEmpty()) {
            stuID = String.valueOf(management.generateNewID());
            // confirm addition of student //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this student?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    studentRecordModel.addRow(new Object[]{name, stuID, path, grade, false});
                    infoLabel.setText("New student added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    studentName.setText("");
                    pathway.setText("");
                    id.setText("");
                    gradeInput.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        } else {
            // confirm addition of student //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this student?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    studentRecordModel.addRow(new Object[]{name, stuID, path, grade, false});
                    infoLabel.setText("New student added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    studentName.setText("");
                    pathway.setText("");
                    id.setText("");
                    gradeInput.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
