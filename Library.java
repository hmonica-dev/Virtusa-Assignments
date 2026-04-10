import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class Library {
    ArrayList<Book>books = new ArrayList<>();
    ArrayList<User>users=new ArrayList<>();
    ArrayList<Transaction>transactions=new ArrayList<>();
    void addBook(int id,String title,String author){
        Book b = new Book(id, title, author);
        books.add(b);
        System.out.println("Book added!");
    }

    void addUser(int id,String name){
        users.add(new User(id,name));
        System.out.println("User registered!");
    }
    
    void searchBook(String keyword){
        for (Book b: books){
            if(b.title.contains(keyword) || b.author.contains(keyword)){
                System.out.println("Found: " + b.title + " by "+ b.author);
            }
        }
    }

    void issueBook(int bookid,int userid){
        for (Book b : books){
            if(b.id==bookid && !b.isIssued){
                b.isIssued=true;
                transactions.add(new Transaction(bookid, userid));
                System.out.println("Book issued!");
                return;

            }
        }
        System.out.println("Book not available.");
    }

    void returnBook(int bookid){
        for (Transaction t:transactions){
            if(t.bookid==bookid){
                LocalDate today = LocalDate.now();
                long latedays=ChronoUnit.DAYS.between(t.dueDate,today);
                if(latedays>0){
                    System.out.println("Fine: ₹" + (latedays * 10));
                }else{
                    System.out.println("Returned on time!");
                }
                for (Book b : books) {
                    if (b.id == bookid) {
                        b.isIssued = false;
                    }
                }
                return;
            }
        }
    }
}
