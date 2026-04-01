import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    inventory.addItem(new Item(id, name, qty, price));
                    System.out.println("Item added");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    inventory.removeItem(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String uid = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(uid, newQty);
                    break;

                case 4:
                    System.out.print("Enter ID or Name: ");
                    inventory.searchItem(sc.nextLine());
                    break;

                case 5:
                    inventory.displayAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}