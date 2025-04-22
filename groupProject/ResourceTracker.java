package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceTracker extends JPanel{
    //variables
    private final List<Object> books = new ArrayList<>();
    private final List<Object> labEquipment = new ArrayList<>();

    //methods
    public boolean checkBookAvailability(boolean isBookAvailable) { 
        return isBookAvaiable;
    }

    public boolean checkEquipmentAvailability(boolean isEquipmentAvailable) {
        return isEquipmentAvailable;
    }
    
    //JLabels for the student input fields in the userInputPanel
    JLabel resourceName = new JLabel("Resource Name: ");
    JLabel resourceID = new JLabel("Resource ID:");
    JLabel availabilityLabel = new JLabel("Resource Availability: ");
    JLabel departmentOrAuthorLabel = new JLabel("Department or Author:  ");

    //JTextFields for the above JLabels for userInputPanel
    JTextField name = new JTextField(10);
    JTextField id = new JTextField(10);
    JTextField availability = new JTextField(10);
    JTextField departmentOrAuthor = new JTextField(10);

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
        bookingInputCard.add(id, gbc);

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
}
