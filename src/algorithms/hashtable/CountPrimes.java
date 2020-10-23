package algorithms.hashtable;

import java.util.Arrays;

/**
 * @Description 统计所有小于非负整数 n 的质数的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/23
 */
public class CountPrimes {

    /**
     * 质数的定义：除了1和它本身以外不再有其他因数的自然数
     * 思路：假设自然数为n，如果2到（n-1）存在n的因数则不为质数
     *
     * @param n
     * @return
     */
    /*public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }*/


    /**
     * Sieve of Eratosthenes算法
     * <p>
     * 排除法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        //for (int i = 2; i < n; i++) {
        //优化：如果在 [2,sqrt(n)] 这个区间
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                //如果一个数为质数，那么除过1之外的倍数肯定不为质数
                //for (int j = 2 * i; j < n; j += i) {
                //优化：比如 n = 25，i = 4 时算法会标记 4 × 2 = 8，4 × 3 = 12 等等数字，但是这两个数字已经被 i = 2 和 i = 3 的 2 × 4 和 3 × 4 标记了。
                //我们可以稍微优化一下，让 j 从 i 的平方开始遍历，而不是从 2 * i 开始：
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                count++;
            }
        }
        return count;
    }


    /**
     * i 不需要遍历到 n，而只需要到 sqrt(n) 即可。为什么呢，我们举个例子，假设 n = 12。
     * 12 = 2 × 6
     * 12 = 3 × 4
     * 12 = sqrt(12) × sqrt(12)
     * 12 = 4 × 3
     * 12 = 6 × 2
     * 即如果在 [2,sqrt(n)] 这个区间之内没有发现可整除因子，就可以直接断定 n 是素数了，因为在区间 [sqrt(n),n] 也一定不会发现可整除因子。
     *
     * @param n
     * @return
     */
    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(7));
    }
}
