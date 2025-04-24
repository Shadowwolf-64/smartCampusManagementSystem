package groupProject;

import javax.swing.*;
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
        JButton reserveButton = new JButton("Reserve");
        JButton unreserveButton = new JButton("Remove Reservation");

        // button size configuration //
        findButton.setPreferredSize(new Dimension(85, 20));
        addButton.setPreferredSize(new Dimension(85, 20));
        removeButton.setPreferredSize(new Dimension(85, 20));
        modifyButton.setPreferredSize(new Dimension(85, 20));
        saveButton.setPreferredSize(new Dimension(85, 20));
        loadButton.setPreferredSize(new Dimension(85, 20));
        reserveButton.setPreferredSize(new Dimension(85, 20));
        unreserveButton.setPreferredSize(new Dimension(170, 20));


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
        buttonPanel.add(reserveButton);
        buttonPanel.add(unreserveButton);
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
        String[] roomColumns = {"Room Name", "Room Type",  "Capacity", "Availability", " "};
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
        studentRecordTable.setName("Student Records Table");
        bookTable.setName("Books Table");
        labEquipTable.setName("Lab Equipment Table");
        roomTable.setName("Rooms Table");
        staffRecordTable.setName("Staff Records Table");

        //making table headings unmoveable //
        studentRecordTable.getTableHeader().setReorderingAllowed(false);
        bookTable.getTableHeader().setReorderingAllowed(false);
        labEquipTable.getTableHeader().setReorderingAllowed(false);
        roomTable.getTableHeader().setReorderingAllowed(false);
        staffRecordTable.getTableHeader().setReorderingAllowed(false);

        // adding the tables //
        studentScrollPane.setViewportView(studentRecordTable);
        booksScrollPane.setViewportView(bookTable);
        roomsScrollPane.setViewportView(roomTable);
        labEquipmentScrollPane.setViewportView(labEquipTable);
        staffScrollPane.setViewportView(staffRecordTable);

        //creating the class objects
        StudentRecords studentRecords = new StudentRecords(studentRecordModel);
        StaffRecords staffRecords = new StaffRecords(staffRecordModel);
        ResourceTracker resourceTracker = new ResourceTracker(bookModel, labEquipModel);
        RoomScheduler roomScheduler = new RoomScheduler(roomModel);

        // creating management for changeListener //
        Management management = new Management();

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
        findButton.addActionListener(_ -> management.searchById(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
        removeButton.addActionListener(_ -> management.removeCheckedRow(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
        modifyButton.addActionListener(_ -> management.modifyCheckedRow(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
        addButton.addActionListener(_ -> {
            //deciding which add method should be implemented based on the current tabbedPane by using the value int of the getSelectedIndex
            if(tabbedPane.getSelectedIndex() == 0) {
                studentRecords.addStudent(infoLabel);
            }else if (tabbedPane.getSelectedIndex() == 1) {
                roomScheduler.addRoom(infoLabel);
            }else if (tabbedPane.getSelectedIndex() == 2) {
                resourceTracker.addBook(infoLabel);
            }else if (tabbedPane.getSelectedIndex() == 3) {
                resourceTracker.addLabEquip(infoLabel);
            }else if (tabbedPane.getSelectedIndex() == 4) {
                staffRecords.addStaff(infoLabel);
            }

        });
        saveButton.addActionListener(_ -> management.saveToFile(infoLabel, "groupProject/systemSavedData.txt", studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
        loadButton.addActionListener(_-> management.loadFromFile(infoLabel, "groupProject/systemSavedData.txt", studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
        reserveButton.addActionListener(_ -> management.reserving(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
        unreserveButton.addActionListener(_ -> management.unreserve(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));

        //adding key listeners to the buttons to allow key presses instead of using the mouse
        findButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    management.searchById(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        removeButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    management.removeCheckedRow(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        modifyButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    management.modifyCheckedRow(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        addButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    //deciding which add method should be implemented based on the current tabbedPane by using the value int of the getSelectedIndex
                    if(tabbedPane.getSelectedIndex() == 0) {
                        studentRecords.addStudent(infoLabel);
                    }else if (tabbedPane.getSelectedIndex() == 1) {
                        roomScheduler.addRoom(infoLabel);
                    }else if (tabbedPane.getSelectedIndex() == 2) {
                        resourceTracker.addBook(infoLabel);
                    }else if (tabbedPane.getSelectedIndex() == 3) {
                        resourceTracker.addLabEquip(infoLabel);
                    }else if (tabbedPane.getSelectedIndex() == 4) {
                        staffRecords.addStaff(infoLabel);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        saveButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    management.saveToFile(infoLabel, "groupProject/systemSavedData.txt", studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        reserveButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    reserveButton.addActionListener(_ -> management.reserving(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        unreserveButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //defines which key needs to be pressed to activate the button
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    unreserveButton.addActionListener(_ -> management.unreserve(infoLabel, studentRecordTable, bookTable, labEquipTable, roomTable, staffRecordTable));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        //setting tool tips for the buttons
        findButton.setToolTipText("Find a student, staff member, room, or resource using ID numbers");
        removeButton.setToolTipText("Remove an item or person from a table by checking the tick box and pressing this button");
        saveButton.setToolTipText("Save data to the system file");
        modifyButton.setToolTipText("Modify an entry by ticking the check box of the one you need to alter and then click this button");
        loadButton.setToolTipText("Load the data from the system file");
        addButton.setToolTipText("Add data from the input boxes into the correct table");
        reserveButton.setToolTipText("Reserve a room, book or lab equipment");
        unreserveButton.setToolTipText("Remove the reservation from a room or resource");


        // Frame Configurations //
        add(splitPane);
        setResizable(false);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Smart Campus Management System");
        setVisible(true);
    }
}