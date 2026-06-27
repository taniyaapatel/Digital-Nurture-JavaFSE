package exercise2;
public class Product {
    private String productId;
    private String productName;
    private String category;
    public Product(String productId, String productName, String category) {
        this.productId = productId; this.productName = productName; this.category = category;
    }
    public String getProductId() { return productId; }
    @Override
    public String toString() { return "Product{" + "productId='" + productId + "', productName='" + productName + "', category='" + category + "'}"; }
}
