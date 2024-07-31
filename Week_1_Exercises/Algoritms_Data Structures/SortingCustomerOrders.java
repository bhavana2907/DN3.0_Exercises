class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
public class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}
public class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (orders[j].totalPrice <= pivot) {
                i++;

                // swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Kumar", 350.0),
            new Order(2, "Raju", 950.0),
            new Order(3, "Joe", 400.0),
            new Order(4, "Pankaj", 600.0),
            new Order(5, "Emma", 300.0)
        };

        // Bubble Sort
        System.out.println("Orders before Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
        
        BubbleSort.bubbleSort(orders);

        System.out.println("\nOrders after Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reset the orders array for Quick Sort
        orders = new Order[]{
            new Order(1, "Kumar", 350.0),
            new Order(2, "Raju", 950.0),
            new Order(3, "Joe", 400.0),
            new Order(4, "Pankaj", 600.0),
            new Order(5, "Emma", 300.0)

        };

        // Quick Sort
        System.out.println("\nOrders before Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        QuickSort.quickSort(orders, 0, orders.length - 1);

        System.out.println("\nOrders after Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

