package groupProject;

import javax.swing.*;

public class LabEquipment {
    private JTextField equipmentName;
    private JTextField equipmentID;
    private JTextField department;
    private boolean isEquipmentAvailable = true;

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

    public boolean isEquipmentAvailable() {
        return isEquipmentAvailable;
    }

    public void setEquipmentAvailable(boolean available) {
        isEquipmentAvailable = available;
    }
}
