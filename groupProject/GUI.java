package groupProject;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {

        //creating the StudentRecords object
        StudentRecords studentRecords = new StudentRecords();

        // JPanels //
        JPanel userInputPanel = new JPanel(new CardLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel feedbackPanel = new JPanel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new GridLayout(3,1, 10, 10 ));

        // Cards for userInputPanel //
        JPanel studentInputCard = new JPanel(); // names can be changed and more cards can be added //
        JPanel bookingInputCard = new JPanel();
        JPanel staffInputCard = new JPanel();
        JPanel roomSchedulerInputCard = new JPanel();

        //JLabel for the userInputCard
//        JLabel userInputMessage = new JLabel("Student Input (placeholder)");
//        userInputMessage.setPreferredSize(new Dimension(10,10));
//        userInputPanel.add(userInputMessage, "Student");

        // add cards to userInputPanel //
        userInputPanel.add(studentInputCard, "Student");
        userInputPanel.add(bookingInputCard, "Booking");
        userInputPanel.add(staffInputCard, "Staff");
        userInputPanel.add(roomSchedulerInputCard, "Rooms");


        // Buttons for buttonPanel//
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

        // JLabels for feedbackPanel//
        JLabel feedbackLabel = new JLabel("Feedback");
        JLabel infoLabel = new JLabel("Placeholder text");

        // JLabel configurations for feedbackPanel //
        feedbackLabel.setFont(new Font( feedbackLabel.getName(), Font.BOLD, 16));

        // ScrollPanes //
        JScrollPane studentScrollPane = new JScrollPane();
        JScrollPane roomsScrollPane = new JScrollPane();
        JScrollPane booksScrollPane = new JScrollPane();
        JScrollPane labEquipmentScrollPane = new JScrollPane();
        JScrollPane staffScrollPane = new JScrollPane();


        // JTabbedPane //
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Student Records", studentScrollPane);
        tabbedPane.addTab("Rooms", roomsScrollPane);
        tabbedPane.addTab("Books", booksScrollPane);
        tabbedPane.addTab("Lab Equipment", labEquipmentScrollPane);
        tabbedPane.addTab("Staff Records", staffScrollPane);

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
        feedbackPanel.add(feedbackLabel);
        feedbackLabel.add(infoLabel);

        // left panel of split pane //
        leftPanel.add(tabbedPane);

        // set table column names //
        String[] studentRecordColumns = {"Student Name", "ID", "Degree Pathway", "Grade", " "};
        String[] bookColumns = {"Book Name", "Id", "Availability", " "};
        String[] labEquipColumns = {"Equipment Name", "Equipment ID", "Availability", " "};
        String[] roomColumns = {"Room Name", "Room Type", "Availability", "Capacity", " "};

        // tables //
        TableModel studentRecordModel = new TableModel(studentRecordColumns);
        JTable studentRecordTable = new JTable(studentRecordModel);
        TableModel bookModel = new TableModel(bookColumns);
        JTable bookTable = new JTable(bookModel);
        TableModel labEquipModel = new TableModel(labEquipColumns);
        JTable labEquipTable = new JTable(labEquipModel);
        TableModel roomModel = new TableModel(roomColumns);
        JTable roomTable = new JTable(roomModel);

        // adding the tables //
        studentScrollPane.setViewportView(studentRecordTable);
        booksScrollPane.setViewportView(bookTable);
        roomsScrollPane.setViewportView(roomTable);
        labEquipmentScrollPane.setViewportView(labEquipTable);








        //creating a GridBaGLayout and constraints to pass to the different cards
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //passing the JPanel component, GridBagLayout and GridBagConstraints to the StudentRecords class
        studentRecords.studentRecords(studentInputCard, layout, gbc);

        // Frame Configurations //
        add(splitPane);
        setResizable(false);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Smart Campus Management System");
        setVisible(true);
    }
}
