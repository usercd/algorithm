package day1;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 3, 342, 34, 422, 45};
        printArr(arr);
        insertionSort(arr);
        printArr(arr);

    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int end = 1; end < arr.length; end++) {
            for (int i = end -1 ; i >= 0 && arr[i] > arr[i+1]; i--) {
                swap(arr, i, i+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArr(int[] arr){
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
    }
}
