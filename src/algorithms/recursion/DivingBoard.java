package algorithms.recursion;

/**
 * @author twt
 * @description 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例 1
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/10
 */
public class DivingBoard {


    /**
     * -表示短木板
     * --表示长木板
     * k==3
     * <p>
     * - - -
     * -- - -
     * -- -- -
     * -- -- --
     * <p>
     * k个数总共有k+1种组合
     * 假设有i个长模板，则有k-i个短木板
     * lengt(k)=i*longer+(k-i)*shorter
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    /*public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) return new int[0];
        if (shorter == longer) {
            int[] ans = new int[1];
            ans[0] = k * shorter;
            return ans;
        }

        int[] ans = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            ans[i] = i * longer + (k - i) * shorter;
        }
        return ans;
    }*/
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            int[] ans = new int[1];
            ans[0] = k * shorter;
            return ans;
        }

        //等差数列
        int[] ans = new int[k + 1];
        int a1 = k * shorter, d = longer - shorter;
        for (int i = 1; i <= k + 1; i++) {
            ans[i - 1] = a1 + (i - 1) * d;
        }
        return ans;

    }


}
