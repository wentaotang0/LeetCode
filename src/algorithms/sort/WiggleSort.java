package algorithms.sort;

import java.util.Arrays;

/**
 * @author twt
 * @description 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/20
 */
public class WiggleSort {

    /**
     * 1.排序
     * 2.将排序后的数组分为较大的数和较小的数两部分，两部分反转
     * 3.将反转后的两部分交替放入新数组
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int[] clone = nums.clone();
        int l = nums.length;
        for (int i = 0; i < l / 2; i++) {
            nums[2 * i] = clone[(l - 1) / 2 - i];
            nums[2 * i + 1] = clone[l - 1 - i];
        }

        //l为奇数时较小部分还会剩余第一个
        if (l % 2 == 1) nums[l - 1] = clone[0];

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6};
        new WiggleSort().wiggleSort(arr);
    }
}
