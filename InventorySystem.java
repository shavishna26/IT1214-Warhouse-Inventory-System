import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;

    Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
    }
}

public class InventorySystem {
    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Warehouse Inventory System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Quantity");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        inventory.add(new Product(id, name, quantity));
        System.out.println("Product added successfully!");
    }

    static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- Product List ---");
        for (Product p : inventory) {
            p.display();
        }
    }

    static void updateQuantity() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                System.out.print("Enter new quantity: ");
                p.quantity = scanner.nextInt();
                System.out.println("Quantity updated!");
                return;
            }
        }

        System.out.println("Product not found!");
    }
}