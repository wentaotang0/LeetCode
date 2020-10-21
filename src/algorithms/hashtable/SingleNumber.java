package algorithms.hashtable;

import java.util.HashSet;

/**
 * @author twt
 * @description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/21
 */
public class SingleNumber {

    /**
     * 使用哈希表，key为元素，value为次数
     * 以前没有出现的元素put，出现过remove
     *
     * @param nums
     * @return
     */
    /*public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        Integer ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans = entry.getKey();
        }
        return ans;
    }*/


    /**
     * 使用异或
     * 异或运算有以下三个性质。
     * <p>
     * 任何数和0做异或运算，结果仍然是原来的数，即 a ⊕0=aa⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
     * <p>
     *
     * @param nums
     * @return
     */
    /*public int singleNumber(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }*/


    /**
     * 其他的思路
     * 1.数组所有不同的数字的2倍
     * 2.数组求和
     * 3.第一步的和减去第二步
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int e : set) {
            ans += e;
        }
        ans *= 2;

        for (int num : nums) {
            ans -= num;
        }
        return ans;

    }


}
