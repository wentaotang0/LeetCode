package algorithms.hashtable;

/**
 * @author twt
 * @description 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/29
 */
public class SmallerNumbersThanCurrent {


    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    /*public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) num++;
            }
            ans[i] = num;
        }
        return ans;
    }*/


    /**
     * 排序+哈希思想
     *
     * @param nums
     * @return
     */
    /*public int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] ret = new int[n];
        ret[data[0][1]] = 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (data[i - 1][0] != data[i][0]) {
                count = i;
            }
            ret[data[i][1]] = count;
        }
        return ret;
    }*/

    /**
     * 计数+哈希思想
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = new int[101];

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            temp[nums[i]]++;
        }

        //temp[i-1]保存小于i的次数（i>0）。i==0时单独判断
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : temp[nums[i] - 1];
        }
        return ret;
    }


    public static void main(String[] args) {

        int[] arr = {6, 5, 4, 8};
        new SmallerNumbersThanCurrent().smallerNumbersThanCurrent(arr);
        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);
        System.out.println(1 << 4);
        System.out.println(1 << 14);
    }
}
