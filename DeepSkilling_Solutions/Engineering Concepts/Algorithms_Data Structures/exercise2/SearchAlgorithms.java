package exercise2;
import java.util.Arrays;
import java.util.Comparator;
public class SearchAlgorithms {
    public static Product linearSearch(Product[] products, String productId) {
        for (Product p : products) if (p.getProductId().equals(productId)) return p;
        return null;
    }
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comp = products[mid].getProductId().compareTo(productId);
            if (comp == 0) return products[mid];
            else if (comp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
    public static void main(String[] args) {
        Product[] products = { new Product("P01", "Laptop", "Electronics"), new Product("P04", "Mouse", "Electronics"), new Product("P02", "Keyboard", "Electronics"), new Product("P03", "Monitor", "Electronics") };
        System.out.println(linearSearch(products, "P03"));
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        System.out.println(binarySearch(products, "P04"));
    }
}
