package groupProject;

import javax.swing.*;

public class Staff {
    //variables
    private JTextField staffName;
    private JTextField staffID;
    private JTextField department;
    private JTextField officeHours;

    //getters and setters
    public JTextField getStaffName() {
        return staffName;
    }

    public void setStaffName(JTextField staffName) {
        this.staffName = staffName;
    }

    public JTextField getStaffID() {
        return staffID;
    }

    public void setStaffID(JTextField staffID) {
        this.staffID = staffID;
    }

    public JTextField getDepartment() {
        return department;
    }

    public void setDepartment(JTextField department) {
        this.department = department;
    }

    public JTextField getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(JTextField officeHours) {
        this.officeHours = officeHours;
    }
}
