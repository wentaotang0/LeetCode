package before20200830;

import java.util.Arrays;

/**
 * @author twt
 * @description 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/03/31
 */
public class SortArray {

    public int[] sortArray(int[] nums) {

        Arrays.sort(nums);
        return nums;
    }


    /**
     * 计数排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        //求最大最小值
        int max = 50001;
        int min = -50001;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }


        //nums从小到大的个数放入数组
        int[] count = new int[max - min + 1];
        for (int i : nums) {
            count[i - min]++;
        }


        int index = 0;
        for (int i = min; i <= max; i++) {
            int cou = count[i - min];
            //该数字是nums中的元素
            if (cou > 0) {
                //可能有重复数字
                while (cou-- > 0) {
                    nums[index++] = i;
                }
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        SortArray array = new SortArray();
        int[] arr = {5, 2, 3, 1};
        array.sortArray2(arr);
    }
}
