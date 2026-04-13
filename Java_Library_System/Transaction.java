import java.time.LocalDate;
public class Transaction {
    int bookid;
    int userid;
    LocalDate issueDate;
    LocalDate dueDate;
    Transaction(int bookid,int userid){
        this.bookid=bookid;
        this.userid=userid;
        this.issueDate=LocalDate.now();
        this.dueDate=issueDate.plusDays(7);
    }
}
