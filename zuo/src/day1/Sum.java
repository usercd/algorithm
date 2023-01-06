package day1;
//阶乘求和
public class Sum {
    public static void main(String[] args) {

        int num = 10;
        System.out.println(f(num));
    }

    public static long f(int num){
        long ans = 0;
        long tmp = 1;
        for (int i = 1; i <= num ; i++){
            tmp *= i;
            ans += tmp;
        }
        return ans;
    }
}
