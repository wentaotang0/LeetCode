package algorithms.recursion;

import java.util.HashMap;

/**
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/4
 */
public class NumWays {

    private HashMap<Integer, Integer> cacheMap = new HashMap<>();

    /**
     * 递归
     * @param n
     * @return
     */
    /*public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        if (cacheMap.containsKey(n)) return cacheMap.get(n);
        int ans = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        cacheMap.put(n, ans);
        return ans;
    }*/


    /**
     * 循环
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int pre = 2;
        int prepre = 1;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new NumWays().numWays(100));
    }
}
