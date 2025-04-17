package groupProject;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {

        // JPanels //
        JPanel userInputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel feedbackPanel = new JPanel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel();


        // JTabbedPane //
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Student Records", null); // null is placeholder until the panel components are created //
        tabbedPane.addTab("Rooms", null);
        tabbedPane.addTab("Books", null);
        tabbedPane.addTab("Lab Equipment", null);

        // SplitPane //
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(700);
        splitPane.setEnabled(false);
        splitPane.setTopComponent(leftPanel);
        splitPane.setBottomComponent(rightPanel);

        // right Panels of split pane //
        rightPanel.add(userInputPanel);
        rightPanel.add(buttonPanel);
        rightPanel.add(feedbackPanel);

        // left panel of split pane //
        leftPanel.add(tabbedPane);













        // Frame Configurations //
        add(splitPane);
        setResizable(false);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Smart Campus Management System");
        setVisible(true);
    }
}
