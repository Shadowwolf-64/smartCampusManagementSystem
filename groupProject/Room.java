package groupProject;

import javax.swing.*;

public class Room {
    private JTextField roomName;
    private JTextField roomCapacity;
    private JTextField roomType;
    private JTextField availability;
    boolean isAvailable;
    
    //setters and getters
    public JTextField getRoomName() {
        return roomName;
    }

    public void setRoomName(JTextField roomName) {
        this.roomName = roomName;
    }

    public JTextField getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(JTextField roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public JTextField getRoomType() {
        return roomType;
    }

    public void setRoomType(JTextField roomType) {
        this.roomType = roomType;
    }

    public JTextField getAvailability() {
        return availability;
    }

    public void setAvailability(JTextField availability) {
        this.availability = availability;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isBooked) {
        this.isAvailable = isBooked;
    }
}
