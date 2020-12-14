package algorithms.recursion;

/**
 * @author twt
 * @description 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/14
 */
public class Multiply {


    /**
     * 很精妙的代码
     * @param A
     * @param B
     * @return
     */
    /*public int multiply(int A, int B) {
        int ans = 0;
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += (max << i);
            }
            min >>= 1;
        }
        return ans;
    }*/

    /**
     * A和B相乘就是A个B相加或者B个A相加
     * A个B相加等于B和A-1个B相加的和相加
     * B个A相加同理
     *
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        if (A == 0) return 0;
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        //每次递归前算出A和B中较小的一个，将较大的一个相加较小次可以使递归次数变少
        return max + multiply(min - 1, max);
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply(918795921, 1));
        //System.out.println(12 >> 4);
        //System.out.println();
        //int i = 3 & 1;
    }
}
