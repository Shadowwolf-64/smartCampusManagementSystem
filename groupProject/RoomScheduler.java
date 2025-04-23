package groupProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Objects;

public class RoomScheduler extends JPanel{

    private final TableModel roomModel;
    Room room = new Room();
    Management management = new Management();

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

    public RoomScheduler(TableModel roomModel) {
        this.roomModel = roomModel;
    }

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

        room.setRoomName(name);
        room.setRoomCapacity(capacity);
        room.setRoomType(roomType);
        room.setAvailability(availability);
    }

    public void addRoom(JLabel infoLabel) {
        String roomName = name.getText();
        String cap = capacity.getText();
        String available = availability.getText();
        String type = roomType.getText();

        int delay = 4500;

        if(Objects.equals(roomName, "") || Objects.equals(cap, "") || Objects.equals(available, "") || Objects.equals(type, "")) {
            infoLabel.setText("Please fill in all the boxes correctly");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        }else if (!Objects.equals(available, "Available") || !Objects.equals(available, "In Use")) {
            infoLabel.setText("Please fill in the room availability as either Available or In Use!");
            infoLabel.setVisible(true);
            ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
            new Timer(delay, taskPerformed).start();
        } else {
            // confirm addition of new room //
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this room?", "Confirm addition", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            // adding the row
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //adding user input to the table model
                    roomModel.addRow(new Object[]{roomName, type, available, cap, false});
                    infoLabel.setText("New room added!"); //confirmation message
                    infoLabel.setVisible(true);
                    ActionListener taskPerformed = _ -> infoLabel.setVisible(false);
                    new Timer(delay, taskPerformed).start();
                    //resetting the input fields to empty strings
                    name.setText("");
                    capacity.setText("");
                    availability.setText("");
                    roomType.setText("");
                }catch (Exception ex) {
                    infoLabel.setText("You screwed up!");
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
