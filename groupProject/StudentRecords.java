package groupProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class StudentRecords extends JPanel{
    //variables
    private final List<Object> students = new ArrayList<>();
    private final TableModel studentRecordModel;
    Student student = new Student();

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
        try {
            studentRecordModel.addRow(new Object[]{name, path, stuID, grade, false});
            infoLabel.setText("New student added!");
        }catch (Exception ex) {
            infoLabel.setText("You fucked up!");
            throw new RuntimeException(ex);
        }
    }

}
