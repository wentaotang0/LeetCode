package algorithms.sort;

/**
 * @author twt
 * @description 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/17
 */
public class SortArrayByParityII {


    /**
     * 双指针，分别指向奇数索引位置和偶数索引位置
     *
     * @param A
     * @return
     */
    /*public int[] sortArrayByParityII(int[] A) {

        int i = 0;
        int j = 1;
        int l = A.length;
        while (i < l && j < l) {
            int r1 = A[i] % 2;
            int r2 = A[j] % 2;
            if (r1 == 0 && r2 == 1) {
                i += 2;
                j += 2;
            } else if (r1 == 0 && r2 != 1) {
                i += 2;
            } else if (r1 != 0 && r2 == 1) {
                j += 2;
            } else {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }*/

    /**
     * 一旦所有偶数都放在了正确的位置上，那么所有奇数也一定都在正确的位子上
     * 让偶数部分下标 i 之前的所有数都是偶数。
     * 为了实现这个目标，把奇数部分作为暂存区，不断增加指向奇数部分的指针，直到找到一个偶数，然后交换指针 i，j 所指的数。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {

        int j = 1;
        for (int i = 0; i < A.length; i += 2) {

            if (A[i] % 2 != 0) {
                while (A[j] % 2 != 1) {
                    j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
