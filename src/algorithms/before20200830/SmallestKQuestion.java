package algorithms.before20200830;

import java.util.PriorityQueue;

/**
 * @author twt
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description
 * @date 2020/08/23
 */
public class SmallestKQuestion {

    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        if (arr == null || arr.length == 0) return result;
        //PriorityQueue 默认最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        SmallestKQuestion s = new SmallestKQuestion();
        int[] ints = new int[1];
        s.smallestK(ints, 0);
    }

}
