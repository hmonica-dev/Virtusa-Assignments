import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1. Add Book\n2. Add User\n3. Search Book\n4. Issue Book\n5. Return Book\n6. Remove Book\n7. Update Book\n8. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (lib.bookExists(id)) {
                    System.out.println("Book ID already exists!");
                    break;
                    }
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(id, title, author);
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    if (lib.userExists(uid)) {
                    System.out.println("User ID already exists!");
                    break;
                    }
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    lib.addUser(uid, name);
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    lib.searchBook(keyword);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int uid2 = sc.nextInt();

                    lib.issueBook(bid, uid2);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;

                case 6:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    lib.removeBook(removeId);
                    break;

                case 7:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new author: ");
                    String newAuthor = sc.nextLine();

                    lib.updateBook(updateId, newTitle, newAuthor);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;    
            }
        }
    }
}

