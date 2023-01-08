package day2;

/**
 * @author CD
 */
public class Rand {
    public static void main(String[] args) {
        //[0,1)
        //概率x变成x平方
        int testTimes = 10000000;
        int count = 0;
        double x = 0.3;
        for (int i = 0; i < testTimes; i++) {
            if (xToxPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));

        System.out.println("============");
        // 1~5 实现 1~7
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("============");
        //不等概率产生等概率
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f4() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
    }

    /**
     * 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
     */
    public static double xToxPower2(){
        return Math.max(Math.random(), Math.random());
    }

    /**
     * f函数提供 1~5 等概率随机整数，不可更改
     * 求函数提供 1~7 等概率随机整数
     */
    public static int f(){
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 0 1 产生器
     */
    public static int f1(){
        int ans;
        //等概率产生
        do {
            ans = f();
        }while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 1~7 等概率产生
     *
     */
    public static int f2(){
        int ans;
        do{
            ans = (f1() << 2) + (f1() << 1) + f1();
        }while (ans == 0);
        return ans;
    }

    /**
     *  不等概率产生等概率
     */
    public static int f3(){
        return (Math.random() < 0.6) ? 0 : 1;
    }

    public static int f4(){
        int ans;
        do {
            ans = f3();
        }while (ans == f3());
        return ans;
    }

}
