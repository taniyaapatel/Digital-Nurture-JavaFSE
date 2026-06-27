package exercise6;
public class Book {
    private String title;
    public Book(String t) { title = t; }
    public String getTitle() { return title; }
    @Override
    public String toString() { return title; }
}
