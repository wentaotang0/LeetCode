package algorithms.hashtable;

import java.util.HashSet;

/**
 * @author twt
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/03
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口（双指针）+哈希表
     * 假如第一个最长不重复子串的开始位置为i，结束位置为j，则第二个最长不重复子串的开始位置i+1到j的位置肯定是不重复的，
     * 此时只需要继续移动j到最长不重复的位置。以此类推，每次i增加一位的时候记录长度，比较长度最大值。
     *
     * @param s
     * @return
     */
    /*public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        //表示一开始结束的位置在最左边
        int end = -1;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //起始位置不是第一位的是后每次滑动后需要移除上一位中set保存的值
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (end + 1 < n && !set.contains(s.charAt(end + 1))) {
                set.add(s.charAt(end + 1));
                end++;
            }
            ans = Math.max(ans, end - i + 1);
        }
        return ans;
    }*/

    /**
     * 双指针+哈希
     * 子串一定是连续的，遇到重复的字符就不能再继续往下找了，此时滑动窗口的左边界可以指向重复子串的下一个字符。
     * 当滑动窗口的有边界可以一直往下找直到最后一个字符，此时滑动窗口有最长的不重复字符。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
