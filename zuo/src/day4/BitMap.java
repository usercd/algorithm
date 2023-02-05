package day4;

import java.util.HashSet;

/**
 * @author CD
 * @since 2023/2/5 8:44
 * package: day4
 * class: BitMap
 */
public class BitMap {
    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    private long[] bits;

    /**
     * 生成位图
     */
    public BitMap(int max){
        //bits = new long[(max + 64) / 64];
        bits = new long[(max + 64) >> 6];
    }

    /**
     * 将num放进位图
     */
    public void  add(int num){
        // num & 63等于num % 64 适用于2的N次方
        // & 运算快于 % 	位运算比加减乘除求模快
        bits[num >> 6] |= (1L << (num & 63));
    }

    public void delete(int num){
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num){
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }

}
