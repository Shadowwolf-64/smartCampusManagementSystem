package groupProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {

    public GUI() {

        // JPanels //
        JPanel userInputPanel = new JPanel(new CardLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel feedbackPanel = new JPanel(new GridLayout(2 ,1));
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new GridLayout(3,1, 10, 10 ));
        JPanel feedbackTopPanel = new JPanel();
        JPanel feedbackBottomPanel = new JPanel();

        // Cards for userInputPanel //
        JPanel studentInputCard = new JPanel(); // names can be changed and more cards can be added //
        JPanel bookingInputCard = new JPanel();
        JPanel staffInputCard = new JPanel();
        JPanel roomSchedulerInputCard = new JPanel();

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
        infoLabel.setVisible(false);

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
        feedbackPanel.add(feedbackTopPanel);
        feedbackPanel.add(feedbackBottomPanel);
        feedbackTopPanel.add(feedbackLabel);
        feedbackBottomPanel.add(infoLabel);

        // left panel of split pane //
        leftPanel.add(tabbedPane);

        // set table column names //
        String[] studentRecordColumns = {"Student Name", "Student ID", "Degree Pathway", "Grade", " "};
        String[] bookColumns = {"Book Name", "Book Author", "Book ID", "Availability", " "};
        String[] labEquipColumns = {"Equipment Name", "Equipment ID", "Department", "Availability", " "};
        String[] roomColumns = {"Room Name", "Room Type", "Availability", "Capacity", " "};
        String[] staffRecordColumns = {"Staff Name", "Staff ID", "Office Hours", "Department", " "};

        // tables //
        TableModel studentRecordModel = new TableModel(studentRecordColumns);
        JTable studentRecordTable = new JTable(studentRecordModel);
        TableModel bookModel = new TableModel(bookColumns);
        JTable bookTable = new JTable(bookModel);
        TableModel labEquipModel = new TableModel(labEquipColumns);
        JTable labEquipTable = new JTable(labEquipModel);
        TableModel roomModel = new TableModel(roomColumns);
        JTable roomTable = new JTable(roomModel);
        TableModel staffRecordModel = new TableModel(staffRecordColumns);
        JTable staffRecordTable = new JTable(staffRecordModel);

        // assign names to tables //
        studentRecordTable.setName("Student Records");
        bookTable.setName("Books");
        labEquipTable.setName("Lab Equipment");
        roomTable.setName("Rooms");
        staffRecordTable.setName("Staff Records");

        // adding the tables //
        studentScrollPane.setViewportView(studentRecordTable);
        booksScrollPane.setViewportView(bookTable);
        roomsScrollPane.setViewportView(roomTable);
        labEquipmentScrollPane.setViewportView(labEquipTable);
        staffScrollPane.setViewportView(staffRecordTable);

        //creating the class objects
        StudentRecords studentRecords = new StudentRecords(studentRecordModel);
        StaffRecords staffRecords = new StaffRecords();
        ResourceTracker resourceTracker = new ResourceTracker();
        RoomScheduler roomScheduler = new RoomScheduler();

        // creating management for changeListener //
        Management management = new Management();


        // Student Records
        Object[] student1 = {"John Doe", "12345", "Computer Science", "A", false};
        Object[] student2 = {"Jane Smith", "67890", "Mathematics", "B", false};
        Object[] student3 = {"Alice Johnson", "11223", "Physics", "A+", false};

        // Staff Records
        Object[] staff1 = {"Dr. Brown", "54321", "9 AM - 5 PM", "Physics", false};
        Object[] staff2 = {"Prof. Green", "98765", "10 AM - 6 PM", "Chemistry", false};
        Object[] staff3 = {"Dr. White", "19283", "8 AM - 4 PM", "Biology", false};

        // Books
        Object[] book1 = {"Introduction to Java", "James Gosling", "001", "Available", false};
        Object[] book2 = {"Data Structures", "Mark Allen Weiss", "002", "Checked Out", false};
        Object[] book3 = {"Operating Systems", "Abraham Silberschatz", "003", "Available", false};

        // Lab Equipment
        Object[] labEquip1 = {"Microscope", "E001", "Biology", "Available", false};
        Object[] labEquip2 = {"Oscilloscope", "E002", "Physics", "In Use", false};
        Object[] labEquip3 = {"3D Printer", "E003", "Engineering", "Available", false};

        // Rooms
        Object[] room1 = {"Room 101", "Lecture Hall", "Available", "50", false};
        Object[] room2 = {"Lab A", "Laboratory", "In Use", "30", false};
        Object[] room3 = {"Conference Room", "Meeting Room", "Available", "20", false};


        // manually adding table data for testing purposes //
        //studentRecordModel.addRow();
        studentRecordModel.addRow(student1);
        studentRecordModel.addRow(student2);
        studentRecordModel.addRow(student3);
        staffRecordModel.addRow(staff1);
        staffRecordModel.addRow(staff2);
        staffRecordModel.addRow(staff3);
        bookModel.addRow(book1);
        bookModel.addRow(book2);
        bookModel.addRow(book3);
        labEquipModel.addRow(labEquip1);
        labEquipModel.addRow(labEquip2);
        labEquipModel.addRow(labEquip3);
        roomModel.addRow(room1);
        roomModel.addRow(room2);
        roomModel.addRow(room3);







        //creating a GridBaGLayout and constraints to pass to the different cards
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //passing the JPanel component, GridBagLayout and GridBagConstraints
        // to the StudentRecords, StaffRecords, RoomScheduler, and ResourceTracker classes
        studentRecords.studentRecords(studentInputCard, layout, gbc);
        staffRecords.staffRecords(staffInputCard, layout, gbc);
        resourceTracker.resourceTracker(bookingInputCard, layout, gbc);
        roomScheduler.roomScheduler(roomSchedulerInputCard, layout, gbc);

        // retrieving CardLayout from userInputPanel //
        CardLayout cardLayout = (CardLayout) userInputPanel.getLayout();

        //adding ChangeListener to the tabbedPane using Management //
        management.addTabChangeListener(tabbedPane, userInputPanel, cardLayout);


        // actionListeners for buttons //
        findButton.addActionListener(_ -> { management.searchById(studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable); });
        removeButton.addActionListener(_ ->{ management.removeCheckedRow(studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable); });
        modifyButton.addActionListener(_ ->{ management.modifyCheckedRow(studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable); });
        addButton.addActionListener(_ -> {studentRecords.addStudent(infoLabel);});

        //adding key listeners to the add button to allow key presses instead of using the mouse
        addButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    studentRecords.addStudent(infoLabel);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        // Frame Configurations //
        add(splitPane);
        setResizable(false);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Smart Campus Management System");
        setVisible(true);
    }
}
