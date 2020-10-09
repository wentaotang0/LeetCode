package algorithms.sort;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author twt
 * @description 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/08
 */
public class Intersection {

    /**
     * 使用哈希
     *
     * @param nums1
     * @param nums2
     * @return
     */
    /*public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }

        HashSet<Integer> s2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (s1.contains(nums2[i])) s2.add(nums2[i]);
        }

        int[] ans = new int[s2.size()];
        int index = 0;
        Iterator<Integer> iterator = s2.iterator();
        while (iterator.hasNext()) {
            ans[index++] = iterator.next();
        }
        return ans;
    }*/

    /**
     * 使用自带API+哈希
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }

        HashSet<Integer> s2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
        }

        s1.retainAll(s2);
        int[] arr = new int[s1.size()];
        int index = 0;
        for (Integer e : s1) {
            arr[index++] = e;
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = new int[10];
        ArrayList<Integer> list = new ArrayList<>();
    }
}
