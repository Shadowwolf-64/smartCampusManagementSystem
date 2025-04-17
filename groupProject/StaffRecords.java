package groupProject;

import java.util.ArrayList;
import java.util.List;

//this class needs to extend the Records class when create the method overrides (it was removed to prevent errors till they were created)
public class StaffRecords extends Records {

    //variables
    private final List<Object> staff = new ArrayList<>();

    //override methods from the abstract class Record

    // generates a new staff ID number. Checks if the number is already in use and generates a new
    //number until it finds one that is not in use yet.
    @Override
    public int generateID() {
        int newStaffID = (int)(Math.random()*10000) + 1;
        while (staff.contains(newStaffID)) {
            newStaffID = (int)(Math.random()*10000) + 1;
        }
        return newStaffID;
    }
}
