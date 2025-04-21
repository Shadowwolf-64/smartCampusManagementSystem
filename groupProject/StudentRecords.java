package groupProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

//this class needs to extend the Records class when create the method overrides (it was removed to prevent errors till they were created)
public class StudentRecords extends JPanel{
    //variables
    private final List<Object> students = new ArrayList<>();

    public void studentRecords(JPanel studentInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Student Records");
        //adds border and title to the card
        studentInputCard.setBorder(blackline);

        //JLabels for the student input fields in the userInputPanel
        JLabel studentName = new JLabel("Student Name: ");
        JLabel degreePathway = new JLabel("Degree Pathway:  ");
        JLabel studentID = new JLabel("Student ID: ");
        JLabel grade = new JLabel("Grade: ");

        //JTextFields for the above JLabels for userInputPanel
        JTextField name = new JTextField(10);
        JTextField pathway = new JTextField(10);
        JTextField id = new JTextField(10);
        JTextField gradeInput = new JTextField(10);

        //adding the layout and constraints for the studentInputCard
        studentInputCard.setLayout(layout);
        //positioning and adding JLabels and JTextFields to the studentInputCard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        studentInputCard.add(studentName,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        studentInputCard.add(name, gbc);

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
        studentInputCard.add(degreePathway, gbc);
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

    }
}
