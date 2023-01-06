package day1;

public class PrintB {
    public static void main(String[] args) {

        int num = 4;
        System.out.print("打印二进制:");
        print(num);
        System.out.print("打印相反数的二进制:");
        //按位取反.包括符号位,末尾加1
        int negNum = (~num + 1);
        print(negNum);

        int min = Integer.MIN_VALUE;
        System.out.print("Integer最小值:");
        print(min);
        System.out.print("带符号右移:");
        print(min >> 1);
        System.out.print("不带符号右移:");
        print(min >>> 1);
    }

    public static void print(int num){
        for (int i = 31; i >=0 ; i--) {

            System.out.print( (num & (1<<i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

}
