package algorithms.sort;

/**
 * @author twt
 * @description 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/11
 */
public class RelativeSortArray {

    /**
     * 先将arr1中的数全都记录到数组count中，然后遍历arr2的同时，将arr2中的数置入arr1，注意由于arr2中的数在arr1中也出现了，所以直接从count中取出即可
     * 处理好arr2之后，再处理剩下的数字，一格一格往里填就好了
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] arr = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (arr[arr2[i]] > 0) {
                arr1[index++] = arr2[i];
                arr[arr2[i]]--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                arr1[index++] = i;
                arr[i]--;
            }
        }

        return arr1;
    }
}
