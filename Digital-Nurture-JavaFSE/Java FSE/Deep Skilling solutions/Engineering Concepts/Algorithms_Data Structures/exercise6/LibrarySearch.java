package exercise6;
import java.util.Arrays;
import java.util.Comparator;
public class LibrarySearch {
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            int cmp = books[mid].getTitle().compareTo(title);
            if(cmp==0) return books[mid];
            if(cmp<0) left = mid+1; else right = mid-1;
        }
        return null;
    }
    public static void main(String[] args) {
        Book[] books = { new Book("A"), new Book("B"), new Book("C") };
        System.out.println(binarySearch(books, "B"));
    }
}
