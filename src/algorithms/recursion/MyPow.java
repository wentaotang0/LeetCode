package algorithms.recursion;

/**
 * @author twt
 * @description 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/15
 */
public class MyPow {

    public MyPow() {
        new MyPow();
    }


    /**
     * 会栈溢出，需要减少递归数量
     *
     * @param x
     * @param n
     * @return
     */
    /*public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            n = -n;
            return 1 / (x * myPow(x, n - 1));
        }
    }*/

    /**
     * 二分法
     *
     * @param x
     * @param n
     * @return
     */
    /*public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            //这里如果n为Integer.MIN_VALUE,取负后仍为Integer.MIN_VALUE，所以提出一项1/x
            return 1/x * myPow(1/x, -n - 1);
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }*/
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double ans = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            if (i % 2 != 0) {
                ans *= x;
            }
        }
        return n > 0 ? ans : 1 / ans;
    }


    public static void main(String[] args) {
        //System.out.println(new MyPow().myPow(2.00000,Integer.MAX_VALUE ));
        //System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(-Integer.MIN_VALUE - 1);
    }
}
