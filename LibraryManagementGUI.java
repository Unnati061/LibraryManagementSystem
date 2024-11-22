import java.awt.*;
import javax.swing.*;

public class LibraryManagementGUI {
    private Library library;
    private JFrame frame;

    public LibraryManagementGUI() {
        library = new Library();  // Using the Library class
        initialize();
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(4, "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book(5, "Moby-Dick", "Herman Melville"));
        library.addBook(new Book(6, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(7, "War and Peace", "Leo Tolstoy"));
        library.addBook(new Book(8, "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book(9, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(10, "Crime and Punishment", "Fyodor Dostoevsky"));

        library.registerMember(new Member(1, "Alice"));
        library.registerMember(new Member(2, "Bob"));
    }

    private void initialize() {
        frame = new JFrame("Library Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JButton addBookButton = new JButton("Add Book");
        JButton registerMemberButton = new JButton("Register Member");
        JButton issueBookButton = new JButton("Issue Book");
        JButton returnBookButton = new JButton("Return Book");
        JButton displayBooksButton = new JButton("Display Available Books");
        JButton viewBorrowedBooksButton = new JButton("View Borrowed Books");

        addBookButton.addActionListener(e -> addBook());
        registerMemberButton.addActionListener(e -> registerMember());
        issueBookButton.addActionListener(e -> issueBook());
        returnBookButton.addActionListener(e -> returnBook());
        displayBooksButton.addActionListener(e -> displayAvailableBooks());
        viewBorrowedBooksButton.addActionListener(e -> viewMemberBorrowedBooks());

        frame.add(addBookButton);
        frame.add(registerMemberButton);
        frame.add(issueBookButton);
        frame.add(returnBookButton);
        frame.add(displayBooksButton);
        frame.add(viewBorrowedBooksButton);

        frame.setVisible(true);
    }

    private void addBook() {
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();

        Object[] inputFields = {
            "Book ID:", idField,
            "Title:", titleField,
            "Author:", authorField
        };

        int option = JOptionPane.showConfirmDialog(frame, inputFields, "Add Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String author = authorField.getText();
            library.addBook(new Book(id, title, author));
        }
    }

    private void registerMember() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();

        Object[] inputFields = {
            "Member ID:", idField,
            "Name:", nameField
        };

        int option = JOptionPane.showConfirmDialog(frame, inputFields, "Register Member", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            library.registerMember(new Member(id, name));
        }
    }

    private void issueBook() {
        JTextField bookIdField = new JTextField();
        JTextField memberIdField = new JTextField();

        Object[] inputFields = {
            "Book ID:", bookIdField,
            "Member ID:", memberIdField
        };

        int option = JOptionPane.showConfirmDialog(frame, inputFields, "Issue Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int bookId = Integer.parseInt(bookIdField.getText());
            int memberId = Integer.parseInt(memberIdField.getText());
            library.issueBook(bookId, memberId);
        }
    }

    private void returnBook() {
        JTextField bookIdField = new JTextField();
        JTextField memberIdField = new JTextField();

        Object[] inputFields = {
            "Book ID:", bookIdField,
            "Member ID:", memberIdField
        };

        int option = JOptionPane.showConfirmDialog(frame, inputFields, "Return Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int bookId = Integer.parseInt(bookIdField.getText());
            int memberId = Integer.parseInt(memberIdField.getText());
            library.returnBook(bookId, memberId);
        }
    }

    private void displayAvailableBooks() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (Book book : library.getAvailableBooks()) {
            textArea.append(book.toString() + "\n");
        }
        JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Available Books", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewMemberBorrowedBooks() {
        String memberIdString = JOptionPane.showInputDialog("Enter Member ID:");
        if (memberIdString != null) {
            int memberId = Integer.parseInt(memberIdString);
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            for (Book book : library.getMemberBorrowedBooks(memberId)) {
                textArea.append(book.toString() + "\n");
            }
            JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Borrowed Books", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LibraryManagementGUI();
    }
}
