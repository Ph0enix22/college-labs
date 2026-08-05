import java.util.Scanner;
import java.util.Random;
public class QuickSort {
    static void generateArray(int arr[]) {
        Random r = new Random();
        for (int i=0; i<arr.length; i++)
            arr[i] = r.nextInt(100);
    }
    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && arr[left] <= pivot)
                left++;
            while (arr[right] > pivot)
                right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[right];
        arr[right] = pivot;
        return right;
    }
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Invalid Array Size!");
                return;
            }
            int arr[] = new int[n];
            generateArray(arr);
            System.out.println("Original Array:");
            printArray(arr);
            long startTime = System.nanoTime();
            quickSort(arr, 0, n - 1);
            long endTime = System.nanoTime();
            System.out.println("Sorted Array:");
            printArray(arr);
            System.out.println("Time Taken = " + (endTime - startTime) + " nanoseconds");
        }
    }
}
