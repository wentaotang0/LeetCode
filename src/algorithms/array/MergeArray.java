package algorithms.array;

import java.util.Arrays;

/**
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/2
 */
public class MergeArray {

    /**
     * 双指针(从前往后)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        //特殊情况处理
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int j = 0;
        int i = 0;
        for (; i < m; i++) {
            if (j == n) break;
            if (nums1[i] < nums2[j]) continue;
            //从后往前copy
            for (int k = m - 1; k >= i; k--) {
                nums1[k + 1] = nums1[k];
            }
            nums1[i] = nums2[j++];
            m++;
        }
        //剩余的nums2拷贝到nums1
        for (int k = j; k < n; k++) {
            nums1[i++] = nums2[k];
        }
    }*/

    /**
     * 双指针（从后往前）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        //p1==m不用考虑
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    /**
     * nums2拷贝到nums1后排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }*/
    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        new MergeArray().merge(nums1, 1, nums2, 1);
    }
}
