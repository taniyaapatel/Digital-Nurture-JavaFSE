package exercise3;
public class SortAlgorithms {
    public static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j]; orders[j] = orders[j + 1]; orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i]; orders[i] = orders[j]; orders[j] = temp;
            }
        }
        Order temp = orders[i + 1]; orders[i + 1] = orders[high]; orders[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        Order[] orders = { new Order("O1", "A", 250), new Order("O2", "B", 150), new Order("O3", "C", 300) };
        quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) System.out.println(o);
    }
}
