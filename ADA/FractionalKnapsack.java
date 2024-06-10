import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;
    double valuePerWeight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.valuePerWeight = (double) value / weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(int[] weights, int[] values, int capacity) {
        Item[] items = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, Comparator.comparingDouble(o -> o.valuePerWeight));

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (int i = items.length - 1; i >= 0; i--) {
            if (remainingCapacity >= items[i].weight) {
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
            } else {
                totalValue += (double) remainingCapacity / items[i].weight * items[i].value;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
