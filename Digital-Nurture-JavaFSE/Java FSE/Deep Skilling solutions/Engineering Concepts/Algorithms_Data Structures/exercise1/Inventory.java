package exercise1;
import java.util.HashMap;
public class Inventory {
    private HashMap<String, Product> products = new HashMap<>();
    public void addProduct(Product product) { products.put(product.getProductId(), product); }
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        if (products.containsKey(productId)) {
            Product p = products.get(productId);
            p.setQuantity(newQuantity); p.setPrice(newPrice);
        }
    }
    public void deleteProduct(String productId) { products.remove(productId); }
    public void displayInventory() { for (Product p : products.values()) System.out.println(p); }
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product("P01", "Laptop", 10, 1000.0));
        inv.addProduct(new Product("P02", "Mouse", 50, 20.0));
        inv.displayInventory();
        inv.updateProduct("P01", 8, 950.0);
        inv.deleteProduct("P02");
        inv.displayInventory();
    }
}
