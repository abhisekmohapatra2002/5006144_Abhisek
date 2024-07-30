/*
Search Algorithms:
-----------------
Linear Search :-

Searches each element in the list sequentially until the desired element is found or the list ends.
Time Complexity: O(n)

Binary Search :-

Searches for the desired element by repeatedly dividing the sorted list into halves and comparing the target value with the middle element.
Time Complexity: O(log n)

*/

import java.util.Arrays;
import java.util.Comparator;

public class exercise6 {

    public static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getBookId() { 
            return bookId; 
        }
        public void setBookId(String bookId) { 
            this.bookId = bookId; 
        }
        public String getTitle() { 
            return title; 
        }
        public void setTitle(String title) { 
            this.title = title; 
        }
        public String getAuthor() { 
            return author; 
        }
        public void setAuthor(String author) { 
            this.author = author; 
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    private Book[] books;
    private int size;

    public exercise6(int capacity) {
        this.books = new Book[capacity];
        this.size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = books[mid].getTitle().compareToIgnoreCase(title);
            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }

    public static void main(String[] args) {
        exercise6 library = new exercise6(10);

        // Adding Books
        Book book1 = new Book("1", "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("2", "1984", "George Orwell");
        Book book3 = new Book("3", "To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Linear Search
        System.out.println("Linear Search for '1984':");
        Book foundBook = library.linearSearchByTitle("1984");
        if (foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found.");
        }

        library.sortBooksByTitle();

        // Binary Search
        System.out.println("\nBinary Search for 'The Great Gatsby':");
        foundBook = library.binarySearchByTitle("The Great Gatsby");
        if (foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}


/*
output :-
-------
Linear Search for '1984':
Book ID: 2, Title: 1984, Author: George Orwell

Binary Search for 'The Great Gatsby':
Book ID: 1, Title: The Great Gatsby, Author: F. Scott Fitzgerald

*/


/*
Time Complexity :-
---------------
Linear Search : O(n)
Binary Search : O(log n) 
Sort (for binary search): O(n log n)

When to Use Each Algorithm :-
--------------------------

Linear Search :- Suitable for small or unsorted datasets. It is simple and does not require the data to be in any specific order.
Binary Search :- Suitable for larger datasets where the list is sorted or can be sorted beforehand. It is more efficient than
                linear search for large datasets due to its logarithmic time complexity.
*/

