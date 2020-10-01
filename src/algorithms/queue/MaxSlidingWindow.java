package algorithms.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author twt
 * @description 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/29
 */
public class MaxSlidingWindow {

    /**
     * 双指针
     * @param nums
     * @param k
     * @return
     */
    /*public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) return new int[0];

        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        int begin = 0;
        int end = k - 1;

        while (end <= nums.length - 1) {
            int max = Integer.MIN_VALUE;
            for (int i = begin; i <= end; i++) {
                if (nums[i] > max) max = nums[i];
            }
            ans[j++] = max;
            begin++;
            end++;
        }
        return ans;
    }*/


    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }

        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            queue.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (k - 1)) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }*/

    /**
     * 单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //先形成一个窗口
        for (int i = 0; i < k; i++) {
            //形成单调队列
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        ans[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            //移除窗口滑过的元素
            if (deque.peekFirst().intValue() == nums[i - k]) {
                deque.pollFirst();
            }
            //形成单调队列
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(arr, 3)));
    }
}
