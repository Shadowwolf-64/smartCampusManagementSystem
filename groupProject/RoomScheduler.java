package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoomScheduler extends JPanel{

    public void roomScheduler(JPanel roomSchedulerInputCard, GridBagLayout layout, GridBagConstraints gbc) {
        //border and border title creation
        Border blackline = BorderFactory.createTitledBorder("Room Scheduler");
        //adds border and title to the card
        roomSchedulerInputCard.setBorder(blackline);
        //JLabels for the student input fields in the userInputPanel
        JLabel roomName = new JLabel("Room Name:");
        JLabel roomCapacity = new JLabel("Room Capacity:");

        //JTextFields for the above JLabels for userInputPanel
        JTextField name = new JTextField(10);
        JTextField capacity = new JTextField(10);

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
        roomSchedulerInputCard.add(roomCapacity, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        roomSchedulerInputCard.add(capacity, gbc);
    }
}
