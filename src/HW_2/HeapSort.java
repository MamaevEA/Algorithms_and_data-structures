package HW_2;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 55, 33, 77, 11};
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i);
        }
    }

    // Функция для создания максимальной кучи
    private static void maxHeapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;
        if (left < arr.length && arr[left] > arr[i]) {
            largest = left;
        }
        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }

    // Построение максимальной кучи за O(n)
    private static void buildMaxHeap(int[] arr){
        for(int i = arr.length/2 - 1 ; i >= 0 ; i--){
            maxHeapify(arr,i);
        }
    }

    // Обмен значениями двух элементов
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
