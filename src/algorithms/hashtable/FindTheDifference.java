package algorithms.hashtable;

/**
 * @author twt
 * @description 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/01/04
 */
public class FindTheDifference {

    /**
     * 两个字符数组相加，和为奇数的即为新添加的字母
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {

        int[] sum = new int[26];
        for (char c : s.toCharArray()) {
            sum[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            sum[c - 'a'] += 1;
        }
        Character ans = null;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] % 2 != 0) {
                ans = (char) (i + 'a');
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("abcd", "abcde"));
    }


}
