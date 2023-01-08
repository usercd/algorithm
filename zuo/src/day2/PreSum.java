package day2;

/**
 * @author CD
 */
public class PreSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 34, 43, 30};
        System.out.println(rangeSum(arr, 0, 5));
    }

    public static int rangeSum(int[] array, int L, int R) {
        int N = array.length;
        int[] preSum = new int[N];
        preSum[0] = array[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + array[i];
        }
        return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
    }
}

