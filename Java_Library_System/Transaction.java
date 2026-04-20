import java.time.LocalDate;

public class Transaction {
    private int bookId;
    private int userId;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Transaction(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(7); 
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
