package algorithms.before20200830;

/**
 * @author twt
 * @description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/08/26
 */
public class ReverseQuestion {


    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            //result是上一次while循环计算的反转后值，mode是本次循环的余数
            //int类型最大最小值分别为2147483647、-2147483648
            //
            if (result > 214748364 || (result == 214748364 && mod > 7)) {
                return 0;
            }

            if (result < -214748364 || (result == -214748364 && mod < -8)) {
                return 0;
            }
            result = result * 10 + mod;
            x /= 10;
        }
        return result;

    }


    public static void main(String[] args) {

    }
}
