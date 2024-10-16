// Example usage of the strategy pattern
public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};

        // Use BubbleSort
        Sorter sorter = new Sorter(new BubbleSort());
        sorter.performSort(array);
        printArray(array);

        // Switch to QuickSort
        sorter.setStrategy(new QuickSort());
        sorter.performSort(array);
        printArray(array);
    }

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}