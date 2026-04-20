import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    
    public void addBook(int id, String title, String author) {
    for (Book b : books) {
        if (b.getId() == id) {
            System.out.println("Book ID already exists!");
            return;
        }
    }

    books.add(new Book(id, title, author));
    System.out.println("Book added!");
}
    public boolean bookExists(int id) {
    for (Book b : books) {
        if (b.getId() == id) {
            return true;
        }
    }
    return false;
}

    
    public void addUser(int id, String name) {
    for (User u : users) {
        if (u.getUserId() == id) {
            System.out.println("User ID already exists!");
            return;
        }
    }

    users.add(new User(id, name));
    System.out.println("User registered!");
}
    public boolean userExists(int id) {
    for (User u : users) {
        if (u.getUserId() == id) {
            return true;
        }
    }
    return false;
}

    
    public void searchBook(String keyword) {
    boolean found = false;

    for (Book b : books) {
        if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
            b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

            System.out.println("Found: " + b.getTitle() + " by " + b.getAuthor());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No book found.");
    }
}

   
    public void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.setIssued(true);
                transactions.add(new Transaction(bookId, userId));
                System.out.println("Book issued!");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    
    public void returnBook(int bookId) {
        for (Transaction t : transactions) {
            if (t.getBookId() == bookId) {

                LocalDate today = LocalDate.now();
                long lateDays = ChronoUnit.DAYS.between(t.getDueDate(), today);

                if (lateDays > 0) {
                    System.out.println("Fine: Rs. " + (lateDays * 10));
                } else {
                    System.out.println("Returned on time!");
                }

                
                for (Book b : books) {
                    if (b.getId() == bookId) {
                        b.setIssued(false);
                    }
                }
                return;
            }
        }
    }

    public void removeBook(int bookId) {
    for (Book b : books) {
        if (b.getId() == bookId) {
            books.remove(b);
            System.out.println("Book removed successfully!");
            return;
        }
    }
    System.out.println("Book not found.");
    }

    public void updateBook(int bookId, String newTitle, String newAuthor) {
    for (Book b : books) {
        if (b.getId() == bookId) {
            b.setTitle(newTitle);
            b.setAuthor(newAuthor);
            System.out.println("Book updated successfully!");
            return;
        }
    }
    System.out.println("Book not found.");
}
}
