package groupProject;

public class Room {
    String roomName;
    int roomCapacity;
    boolean disabledAccess;
    boolean isBooked;
    
    //setters and getters
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName() {
        this.roomName = roomName;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean getDisabledAccess() {
        return disabledAccess;
    }

    public void setDisabledAccess(boolean disabledAccess) {
        this.disabledAccess = disabledAccess;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}
