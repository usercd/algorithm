/**
 * @author CD
 * @since 2023/2/5 21:47
 * package: PACKAGE_NAME
 * class: Code29_BitAddMinusMultiDiv
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *<p>
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *<p>
 * Return the quotient after dividing dividend by divisor.
 *<p>
 * Note: Assume we are dealing with an environment that
 * could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
 * For this problem, if the quotient is strictly greater than 231 - 1,
 * then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 * <p>
 * Example 1:
 *<p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 */
public class Code29_BitAddMinusMultiDiv {

    /**
     * 不使用加号实现加法
     */
    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            //异或获取无进位加法
            sum = a ^ b;
            //与运算获取进位信息
            b = (a & b) << 1;
            //递归直到进位信息为零
            a = sum;
        }
        return sum;
    }

    /**
     * 实现减法
     * 减法等于加上相反数
     */
    public static int negNum(int num){
        return add(~num, 1);
    }

    public static int minus(int a, int b){
        return add(a,negNum(b));
    }

    /**
     * 实现乘法
     * 乘法用加法实现
     */
    public static int multi(int a, int b){
        int res = 0;

        while (b != 0){
            if ((b & 1) != 0){
                res = add(res, a);
            }
            a <<= 1;
            //不带符号右移
            b >>>= 1;
        }
        return res;
    }

    /**
     * 实现除法
     * 若有负值 转成正数计算
     */

    public static boolean isNeg(int n) {
        return n < 0;
    }
    public static int div(int a, int b){
        //将除数和被除数取绝对值
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            //X右移避免Y左移到符号位
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        //异或判断结果符号
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }


    public static int divide(int a, int b) {
        //系统最小值不能转成绝对值
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            // LeetCode 规定系统最小除负一得到系统最大
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                //将系统最小加1 得到次最小 进行除法
                int c = div(add(a, 1), b);
                //得到结果加上差值补偿结果
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }
}
