package exercise2;
interface Document { void open(); }
class WordDocument implements Document { public void open() { System.out.println("Word"); } }
abstract class DocumentFactory { abstract Document create(); }
class WordFactory extends DocumentFactory { Document create() { return new WordDocument(); } }
public class Main {
    public static void main(String[] args) {
        new WordFactory().create().open();
    }
}
