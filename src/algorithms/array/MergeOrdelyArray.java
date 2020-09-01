package algorithms.array;

/**
 * @author twt
 * @description 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/01
 */
public class MergeOrdelyArray {


    /**
     * 合并数组后快排
     * @param A
     * @param m
     * @param B
     * @param n
     */
   /* public void merge(int[] A, int m, int[] B, int n) {

        for (int i = 0; i < B.length; i++) {
            A[m+i] = B[i];
        }

        Arrays.sort(A);
    }*/

    /**
     * 正向双指针
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    /*public void merge(int[] A, int m, int[] B, int n) {

        int[] ordered = new int[m + n];
        int i = 0;
        int j = 0;
        int cur = 0;
        while (i < m || j < n) {
            //A数组已经遍历完，此时B数组没有遍历完
            if (i == m) {
                cur = B[j++];
                //B数组已经遍历完，此时A数组没有遍历完
            } else if (j == n) {
                cur = A[i++];
            } else if (A[i] < B[j]) {
                cur = A[i++];
            } else {
                cur = B[j++];
            }

            ordered[i + j - 1] = cur;
        }
        for (int k = 0; k < ordered.length; k++) {
            A[k] = ordered[k];
        }
    }*/

    /**
     * 逆向双指针：相比正向双指针空间复杂度直接降低到 o(1)
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {

        int tail = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        int cur = 0;
        while (i >= 0 || j >= 0) {
            //A数组已经遍历完，此时B数组没有遍历完
            if (i == -1) {
                cur = B[j--];
            } else if (j == -1) {
                //B数组已经遍历完，此时A数组没有遍历完
                cur = A[i--];
            } else if (A[i] > B[j]) {
                cur = A[i--];
            } else {
                cur = B[j--];
            }
            A[tail--] = cur;
        }
    }


}
