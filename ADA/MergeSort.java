import java.util.Scanner;
import java.util.Random;
public class MergeSort {
    static void generateArray(int arr[]) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(100);
    }
    static void merge(int arr[], int low, int mid, int high) {
        int temp[] = new int[arr.length];
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= high)
            temp[k++] = arr[j++];
        for (i = low; i <= high; i++)
            arr[i] = temp[i];
    }
    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
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
            mergeSort(arr, 0, n - 1);
            long endTime = System.nanoTime();
            System.out.println("Sorted Array:");
            printArray(arr);
            System.out.println("Time Taken = " + (endTime - startTime) + " nanoseconds");
        }
    }
}
