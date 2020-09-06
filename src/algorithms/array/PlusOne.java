package algorithms.array;

/**
 * @author twt
 * @description 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/06
 */
public class PlusOne {

    /**
     * 1.最多digits.length+1的数组保存结果
     * 2.进位处理
     * 由于数组元素只存储单个数字，即0-9，加1操作后，只有9的情况下才会进位
     *
     * @param digits
     * @return
     */
    /*public int[] plusOne(int[] digits) {

        //能进入下一次for循环说明进位了
        for (int i = digits.length - 1; i >= 0; i--) {
            //进位
            if (digits[i] == 9) {
                digits[i] = 0;
                //不进位
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        //能走到这说明最高位进位了,并且其他位是0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }*/


    /**
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        //能进入下一次for循环说明进位了
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] = digits[i] % 10;
            //不需要进位
            if (digits[i] != 0) {
                return digits;
            }
        }

        //能走到这说明最高位进位了,并且其他位是0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
