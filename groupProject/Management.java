package groupProject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Management extends JSplitPane {

    public void addTabChangeListener(JTabbedPane tabbedPane, JPanel userInputPanel, CardLayout cardLayout) {
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                switch (selectedIndex) {
                    case 0 -> cardLayout.show(userInputPanel, "Student");
                    case 1 -> cardLayout.show(userInputPanel, "Booking");
                    case 2 -> cardLayout.show(userInputPanel, "Rooms");
                    case 3 -> cardLayout.show(userInputPanel, "Booking");
                    case 4 -> cardLayout.show(userInputPanel, "Staff");

                }
            }
        });
    }
}

