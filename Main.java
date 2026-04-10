import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
                while (true) {
                    System.out.println("\n1.Add Book\n2.Add User\n3.Search\n4.Issue\n5.Return\n6.Exit");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Title: ");
                            String title = sc.nextLine();
                            System.out.print("Author: ");
                            String author = sc.nextLine();
                            lib.addBook(id, title, author);
                            break;

                        case 2:
                        System.out.print("User ID: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        lib.addUser(uid, name);
                        break;

                        case 3:
                        sc.nextLine();
                        System.out.print("Search keyword: ");
                        lib.searchBook(sc.nextLine());
                        break;

                        case 4:
                        System.out.print("Book ID: ");
                        int bid = sc.nextInt();
                        System.out.print("User ID: ");
                        int uid2 = sc.nextInt();
                        lib.issueBook(bid, uid2);
                        break;

                        case 5:
                        System.out.print("Book ID: ");
                        lib.returnBook(sc.nextInt());
                        break;

                        case 6:
                        System.out.println("Exit...");
                        return;
            }
        }
    }
    }

