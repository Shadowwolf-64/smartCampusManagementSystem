package groupProject;

import javax.swing.*;

public class Book {

    //variables
    private JTextField bookName;
    private JTextField bookAuthor;
    private JTextField bookID;
    private boolean isAvailable = true;

    // getters and setters //
    public JTextField getBookName() {
        return bookName;
    }

    public void setBookName(JTextField bookName) {
        this.bookName = bookName;
    }

    public JTextField getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(JTextField bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public JTextField getBookID() {
        return bookID;
    }

    public void setBookID(JTextField bookID) {
        this.bookID = bookID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
