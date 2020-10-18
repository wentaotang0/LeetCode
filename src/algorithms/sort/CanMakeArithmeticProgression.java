package algorithms.sort;

import java.util.Arrays;

/**
 * @author twt
 * @description 给你一个数字数组 arr 。
 * <p>
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * <p>
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/15
 */
public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {

        if (arr.length <= 2) return true;
        Arrays.sort(arr);
        int differ = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int temp = arr[i] - arr[i - 1];
            if (differ != temp) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,4};
        System.out.println(new CanMakeArithmeticProgression().canMakeArithmeticProgression(arr));
    }
}
