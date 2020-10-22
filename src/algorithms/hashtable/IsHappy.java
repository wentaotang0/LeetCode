package algorithms.hashtable;

/**
 * @author twt
 * @description 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/21
 */
public class IsHappy {

    static {
        System.out.println("static");
    }

    public IsHappy() {
        System.out.println("construct");
    }

    /**
     * 见官方题解，重点看证明不存在n越来越大，趋近于无穷大的情况、环的解决方案
     *
     * @param n
     * @return
     */
    /*public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }*/

    int getNext(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            ans += (digit * digit);
            n /= 10;
        }
        return ans;
    }


    /**
     * 双指针检测环的思想
     * 1.如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1
     * 2.如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        int fast = getNext(n);
        int slow = n;
        while ((fast != 1) && (fast != slow)) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }


    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
    }
}
