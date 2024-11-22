import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Sample data
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.registerMember(new Member(1, "Alice"));
        library.registerMember(new Member(2, "Bob"));
        
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Display Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Member's Borrowed Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    library.issueBook(bookId, memberId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    bookId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextInt();
                    library.returnBook(bookId, memberId);
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextInt();
                    library.viewMemberBorrowedBooks(memberId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
