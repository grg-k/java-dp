// Define the SortingStrategy interface
interface SortingStrategy {
    void sort();
}

// Implement concrete sorting strategies
class BubbleSort implements SortingStrategy {
    private Sorter context;

    public BubbleSort(Sorter context) {
        this.context = context;
    }

    @Override
    public void sort() {
        int[] array = context.getData();
        System.out.println("Sorting using Bubble Sort");
        
        // Implementation of bubble sort
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Implement QuickSort strategy
class QuickSort implements SortingStrategy {
    private Sorter context;

    public QuickSort(Sorter context) {
        this.context = context;
    }

    @Override
    public void sort() {
        int[] array = context.getData();
        System.out.println("Sorting using Quick Sort");

        // Implementation of quick sort
        quickSort(array, 0, array.length - 1);

        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}

// Context class that retains data and passes itself to the selected sorting strategy
class Sorter {
    private SortingStrategy strategy;
    private int[] data;

    public Sorter(int[] data) {
        this.data = data;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] getData() {
        return data;
    }

    public void performSort() {
        strategy.sort();
    }
}