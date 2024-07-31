import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {
    private Book[] books;
    private int count;

    public LibraryManagementSystem(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Method to sort books by title
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(book -> book.title));
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem(10);

        // Add books
        system.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        system.addBook(new Book(2, "1984", "George Orwell"));
        system.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        system.addBook(new Book(4, "Moby Dick", "Herman Melville"));
        system.addBook(new Book(5, "Pride and Prejudice", "Jane Austen"));

        // Sort books by title for binary search
        system.sortBooksByTitle();

        // Linear search for a book by title
        String searchTitle = "1984";
        Book foundBook = system.linearSearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("\nLinear search: Book found: " + foundBook);
        } else {
            System.out.println("\nLinear search: Book not found.");
        }

        // Binary search for a book by title
        foundBook = system.binarySearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("\nBinary search: Book found: " + foundBook);
        } else {
            System.out.println("\nBinary search: Book not found.");
        }
    }
}
