import java.util.Scanner;
public class InsertionSort {
    static void sort(int arr[]) {
        int n = arr.length;
        for(int i=1; i<n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Invalid Array Size!");
                return;
            }
            int arr[] = new int[n];
            System.out.println("Enter elements:");
            for (int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            System.out.println("Original Array:");
            printArray(arr);
            long startTime = System.nanoTime();
            sort(arr);
            long endTime = System.nanoTime();
            System.out.println("Sorted Array:");
            printArray(arr);
            System.out.println("Time Taken = " + (endTime - startTime) + " nanoseconds");
        }
    }
}
