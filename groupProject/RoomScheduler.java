package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoomScheduler extends JPanel{

    //JLabels for the student input fields in the userInputPanel
    JLabel roomName = new JLabel("Room Name:");
    JLabel roomCapacity = new JLabel("Room Capacity:  ");
    JLabel availabilityLabel = new JLabel("Room Availability:  ");
    JLabel roomTypeLabel = new JLabel("Room Type: ");

    //JTextFields for the above JLabels for userInputPanel
    JTextField name = new JTextField(10);
    JTextField capacity = new JTextField(10);
    JTextField availability = new JTextField(10);
    JTextField roomType = new JTextField(10);

    public void roomScheduler(JPanel roomSchedulerInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Room Scheduler");
        //adds border and title to the card
        roomSchedulerInputCard.setBorder(blackline);

        //adding the layout and constraints for the roomSchedulerInputCard
        roomSchedulerInputCard.setLayout(layout);
        //positioning and adding JLabels and JTextFields to the roomSchedulerInputCard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        roomSchedulerInputCard.add(roomName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        roomSchedulerInputCard.add(name, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        roomSchedulerInputCard.add(roomTypeLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        roomSchedulerInputCard.add(roomType, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        roomSchedulerInputCard.add(availabilityLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        roomSchedulerInputCard.add(availability, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        roomSchedulerInputCard.add(roomCapacity, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        roomSchedulerInputCard.add(capacity, gbc);
    }
}
