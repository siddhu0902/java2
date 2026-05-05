import java.util.*;
import java.io.*;

// ========== INTERFACE ==========
interface Searchable {
    boolean isAvailable();
    String getDetails();
}

// ========== ABSTRACT CLASS ==========
abstract class LibraryItem implements Searchable {
    protected String itemId, title, author;
    protected boolean available;

    public LibraryItem(String id, String t, String a) {
        itemId = id; title = t; author = a; available = true;
    }

    public abstract int getMaxLoanDays();

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean a) { available = a; }
    public String getDetails() { return itemId + ": " + title + " by " + author; }
    public String toFileString() { return itemId + "," + title + "," + author + "," + available; }
}

// ========== CONCRETE CLASS 1 ==========
class Book extends LibraryItem {
    public Book(String id, String t, String a) { super(id, t, a); }
    public int getMaxLoanDays() { return 14; }
}

// ========== CONCRETE CLASS 2 ==========
class ReferenceBook extends LibraryItem {
    public ReferenceBook(String id, String t, String a) { super(id, t, a); }
    public int getMaxLoanDays() { return 1; }
}

// ========== CUSTOM EXCEPTION ==========
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String m) { super(m); }
}
class MemberLimitException extends Exception {
    public MemberLimitException(String m) { super(m); }
}

// ========== MEMBER CLASS ==========
class Member {
    String memberId, name;
    int booksIssued, maxLimit;

    public Member(String id, String n, int max) {
        memberId = id; name = n; maxLimit = max; booksIssued = 0;
    }

    public boolean canIssue() { return booksIssued < maxLimit; }
    public void incBooks() { booksIssued++; }
    public void decBooks() { if (booksIssued > 0) booksIssued--; }
}

// ========== MANAGER CLASS ==========
class Library {
    private List<LibraryItem> catalog = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private static final String BOOKS_FILE = "library_books.txt";

    public Library() { loadFromFile(); }

    public void addBook(LibraryItem item) {
        catalog.add(item);
        saveToFile();
        System.out.println("Added: " + item.title);
    }

    public void registerMember(Member m) {
        members.add(m);
        System.out.println("Registered: " + m.name);
    }

    public void issueBook(String itemId, String memberId)
            throws BookNotAvailableException, MemberLimitException {
        LibraryItem item = null;
        for (LibraryItem i : catalog)
            if (i.itemId.equals(itemId)) { item = i; break; }

        Member mem = null;
        for (Member m : members)
            if (m.memberId.equals(memberId)) { mem = m; break; }

        if (item == null) throw new BookNotAvailableException("Book not found!");
        if (!item.isAvailable()) throw new BookNotAvailableException("Book already issued!");
        if (!mem.canIssue()) throw new MemberLimitException("Member limit reached!");

        item.setAvailable(false);
        mem.incBooks();
        saveToFile();
        System.out.println("✅ Issued: " + item.title + " to " + mem.name);
    }

    public void returnBook(String itemId, String memberId) {
        for (LibraryItem i : catalog)
            if (i.itemId.equals(itemId)) { i.setAvailable(true); break; }
        for (Member m : members)
            if (m.memberId.equals(memberId)) { m.decBooks(); break; }
        saveToFile();
        System.out.println("📥 Returned: " + itemId);
    }

    public void displayBooks() {
        System.out.println("\n╔═══════════ LIBRARY CATALOG ═══════════╗");
        for (LibraryItem i : catalog) {
            System.out.println((i.isAvailable() ? "🟢" : "🔴") + " " + i.getDetails());
        }
        System.out.println("╚════════════════════════════════════════╝");
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKS_FILE))) {
            for (LibraryItem i : catalog)
                pw.println(i.toFileString());
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Book b = new Book(parts[0], parts[1], parts[2]);
                b.setAvailable(Boolean.parseBoolean(parts[3]));
                catalog.add(b);
            }
        } catch (IOException e) {
            System.out.println("Starting fresh library.");
        }
    }
}

// ========== MAIN CLASS ==========
public class LibraryTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        // Add sample data
        lib.addBook(new Book("B1", "Java Programming", "James Gosling"));
        lib.addBook(new Book("B2", "Clean Code", "Robert Martin"));
        lib.registerMember(new Member("M1", "Amit Kumar", 3));

        while (true) {
            System.out.println("\n1.View Books  2.Issue  3.Return  4.Exit");
            System.out.print("Choice: ");

            try {
                int ch = sc.nextInt(); sc.nextLine();

                switch (ch) {
                    case 1:
                        lib.displayBooks();
                        break;
                    case 2:
                        System.out.print("Book ID, Member ID: ");
                        String[] iss = sc.nextLine().split(",");
                        lib.issueBook(iss[0], iss[1]);
                        break;
                    case 3:
                        System.out.print("Book ID, Member ID: ");
                        String[] ret = sc.nextLine().split(",");
                        lib.returnBook(ret[0], ret[1]);
                        break;
                    case 4:
                        sc.close();
                        return;
                }
            } catch (BookNotAvailableException | MemberLimitException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❌ Invalid input!");
            }
        }
    }
}