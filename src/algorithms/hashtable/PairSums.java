package algorithms.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author twt
 * @description 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * <p>
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * 提示：
 * <p>
 * nums.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/01/11
 */
public class PairSums {



    public List<List<Integer>> pairSums(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1 + map.getOrDefault(nums[i], 0));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer a1 = map.get(num);
            Integer a2 = map.get(target - num);
            if (a1 == null || a2 == null) continue;
            //两数不同，例如6=2+4
            if (num != target - num && a1 > 0 && a2 > 0) {
                int min = Math.min(a1, a2);
                map.put(num, a1 - min);
                map.put(target - num, a2 - min);
                for (int i = 0; i < min; i++) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(target - num);
                    ans.add(list);
                }
                //两数相同，例如6=3+3
            } else if (num == target - num && a1 > 1) {
                map.put(num, a1 % 2);
                for (int i = 0; i < a1 / 2; i++) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(num);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {5, 6, 3, -6, 2, 1, 1, 0, 8, 0, 2};
        System.out.println(new PairSums().pairSums(arr, 2));
    }
}
