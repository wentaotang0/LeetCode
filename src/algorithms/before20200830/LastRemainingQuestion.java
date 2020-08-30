package algorithms.before20200830;

import java.util.ArrayList;

/**
 * @author twt
 * @description 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/03/30
 */
public class LastRemainingQuestion {

    /**
     * 假设当前删除的位置是 idxidx ,下一个删除的数字的位置是 idx + midx+m 。但是，由于把当前位置的数字删除了，后面的数字会前移一位，所以实际的下一个位置是 idx + m - 1idx+m−1。由于数到末尾会从头继续数，所以最后取模一下，就是 (idx + m - 1) \pmod n(idx+m−1)(modn)。
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            --n;
        }
        return list.get(0);
    }

    public int lastRemaining2(int n, int m) {

        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }

    public static void main(String[] args) {
        LastRemainingQuestion lastRemainingQuestion = new LastRemainingQuestion();
        System.out.println(lastRemainingQuestion.lastRemaining2(5, 3));
    }
}
