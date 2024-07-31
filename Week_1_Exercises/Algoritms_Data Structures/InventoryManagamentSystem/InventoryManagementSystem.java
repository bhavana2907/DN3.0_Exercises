import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagementSystem {
    private Map<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem sys = new InventoryManagementSystem();

        // Adding products
        sys.addProduct(new Product(1, "Smart TV", 7, 19999.99));
        sys.addProduct(new Product(2, "Video Games", 15, 1699.99));
        sys.addProduct(new Product(3, "Camera", 10, 5000.0));

        // Displaying inventory
        System.out.println("Inventory after adding products:");
        sys.displayInventory();

        // Updating a product
        sys.updateProduct(2, 10, 649.99);

        // Displaying inventory after update
        System.out.println("Inventory after updating product 2:");
        sys.displayInventory();

        // Deleting a product
        sys.deleteProduct(2);

        // Displaying inventory after deletion
        System.out.println("Inventory after deleting product 2:");
        sys.displayInventory();
    }
}
