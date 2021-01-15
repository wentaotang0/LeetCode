package algorithms.hashtable;

/**
 * @Description 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/15
 */
public class RepeatedNTimes {

    /**
     * 根据题意：N个元素相同，N个元素不同，2N个元素中总共有N+1个不同的元素
     *
     * @param A
     * @return
     */
    /*public int repeatedNTimes(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int n : A) {
            if (map.getOrDefault(n, 0) == 1) {
                ans = n;
                break;
            }
            map.putIfAbsent(n, 1 + map.getOrDefault(n, 0));
        }
        return ans;
    }*/

    /**
     * 数组长度为2、4、6、8...
     * 如果长度大于2，则所有连续的3个元素中肯定存在有两个相等的情况
     *
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        int l = A.length;
        for (int i = 0; i < l - 2; i++) {
            if (A[i] == A[i + 1] || A[i] == A[i + 2]) {
                return A[i];
            }
        }
        //arr.length==2的情况和连续3个数后两个相等的情况都包含了
        return A[l-1];
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedNTimes().repeatedNTimes(new int[]{1, 2, 3, 3}));
    }
}
