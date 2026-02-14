import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final class Item {
        private final String name;
        private final int weight;
        private final int value;

        private Item(String name, int weight, int value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("Laptop", 3, 2000),
                new Item("Headphones", 1, 300),
                new Item("Jacket", 2, 700),
                new Item("Camera", 2, 1500),
                new Item("Water Bottle", 1, 200)
        };
        int capacity = 5;

        System.out.println("=== 0/1 Knapsack (Dynamic Programming) Demo ===");
        System.out.println("Capacity = " + capacity + " kg\n");

        printItems(items);

        int[][] dp = buildDpTable(items, capacity);
        printDpTable(dp, capacity);

        List<Item> selectedItems = pickSelectedItems(dp, items, capacity);

        int bestValue = dp[items.length][capacity];
        int totalWeight = selectedItems.stream().mapToInt(item -> item.weight).sum();

        System.out.println("\nBest total value = " + bestValue);
        System.out.println("Total weight used = " + totalWeight + " kg");
        System.out.println("Selected items:");
        for (Item item : selectedItems) {
            System.out.println("- " + item.name + " (w=" + item.weight + ", v=" + item.value + ")");
        }
    }

    private static void printItems(Item[] items) {
        System.out.println("Items:");
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            System.out.println((i + 1) + ". " + item.name + " (weight=" + item.weight + ", value=" + item.value + ")");
        }
        System.out.println();
    }

    private static int[][] buildDpTable(Item[] items, int capacity) {
        int[][] dp = new int[items.length + 1][capacity + 1];

        for (int i = 1; i <= items.length; i++) {
            Item item = items[i - 1];
            for (int w = 0; w <= capacity; w++) {
                int skip = dp[i - 1][w];
                int take = 0;
                if (item.weight <= w) {
                    take = item.value + dp[i - 1][w - item.weight];
                }
                dp[i][w] = Math.max(skip, take);
            }
        }

        return dp;
    }

    private static void printDpTable(int[][] dp, int capacity) {
        System.out.println("DP Table (rows = items considered, columns = capacity):");
        System.out.print("     ");
        for (int w = 0; w <= capacity; w++) {
            System.out.printf("%5d", w);
        }
        System.out.println();

        for (int i = 0; i < dp.length; i++) {
            System.out.printf("i=%d ", i);
            for (int w = 0; w <= capacity; w++) {
                System.out.printf("%5d", dp[i][w]);
            }
            System.out.println();
        }
    }

    private static List<Item> pickSelectedItems(int[][] dp, Item[] items, int capacity) {
        List<Item> selected = new ArrayList<>();
        int w = capacity;

        for (int i = items.length; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = items[i - 1];
                selected.add(item);
                w -= item.weight;
            }
        }

        Collections.reverse(selected);
        return selected;
    }
}
