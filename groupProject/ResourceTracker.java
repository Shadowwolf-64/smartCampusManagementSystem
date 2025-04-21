package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceTracker extends Records{
    //variables
    private final List<Object> books = new ArrayList<>();
    private final List<Object> labEquipment = new ArrayList<>();

    public void resourceTracker(JPanel bookingInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Resources");
        //adds border and title to the card
        bookingInputCard.setBorder(blackline);
        //JLabels for the student input fields in the userInputPanel
        JLabel resourceName = new JLabel("Resource Name:");
        JLabel resourceID = new JLabel("Resource ID:");

        //JTextFields for the above JLabels for userInputPanel
        JTextField name = new JTextField(10);
        JTextField id = new JTextField(10);

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
        bookingInputCard.add(id, gbc);
    }

    @Override
    public void find() {

    }

    @Override
    public void modify() {

    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public int generateID() {
        return 0;
    }
}
