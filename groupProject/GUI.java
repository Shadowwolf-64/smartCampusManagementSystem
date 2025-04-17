package groupProject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {

        // JPanels //
        JPanel userInputPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel feedbackPanel = new JPanel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new GridLayout(3,1, 10, 10 ));
        
        // Buttons //
        JButton findButton = new JButton("Find");
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton modifyButton = new JButton("Modify");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        // button size configuration //
        findButton.setPreferredSize(new Dimension(85, 20));
        addButton.setPreferredSize(new Dimension(85, 20));
        removeButton.setPreferredSize(new Dimension(85, 20));
        modifyButton.setPreferredSize(new Dimension(85, 20));
        saveButton.setPreferredSize(new Dimension(85, 20));
        loadButton.setPreferredSize(new Dimension(85, 20));

        // ScrollPanes //
        JScrollPane studentScrollPane = new JScrollPane();
        JScrollPane roomsScrollPane = new JScrollPane();
        JScrollPane booksScrollPane = new JScrollPane();
        JScrollPane labEquipmentScrollPane = new JScrollPane();


        // JTabbedPane //
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Student Records", studentScrollPane);
        tabbedPane.addTab("Rooms", roomsScrollPane);
        tabbedPane.addTab("Books", booksScrollPane);
        tabbedPane.addTab("Lab Equipment", labEquipmentScrollPane);

        // SplitPane //
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(700);
        splitPane.setEnabled(false);
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        // right Panels of split pane //
        rightPanel.add(userInputPanel);
        rightPanel.add(buttonPanel);
        rightPanel.add(feedbackPanel);
        buttonPanel.add(findButton);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

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
