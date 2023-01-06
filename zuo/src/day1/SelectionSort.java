package day1;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 3, 342, 34, 422, 45};
        printArr(arr);
        selectionSort(arr);
        printArr(arr);

    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j=i+1; j<N;j++){
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
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
