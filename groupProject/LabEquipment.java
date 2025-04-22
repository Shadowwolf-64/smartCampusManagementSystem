package groupProject;

import javax.swing.*;

public class LabEquipment {
    private JTextField equipmentName;
    private JTextField equipmentID;
    private JTextField department;
    private boolean isAvailable = true;

    public JTextField getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(JTextField equipmentName) {
        this.equipmentName = equipmentName;
    }

    public JTextField getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(JTextField equipmentID) {
        this.equipmentID = equipmentID;
    }

    public JTextField getDepartment() {
        return department;
    }

    public void setDepartment(JTextField department) {
        this.department = department;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
