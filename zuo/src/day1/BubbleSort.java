package day1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 3, 342, 34, 422, 45};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);

    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int end = arr.length-1; end >=  0; end--){
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
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
