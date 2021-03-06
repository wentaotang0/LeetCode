package algorithms.sort;

/**
 * @author twt
 * @description 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 * <p>
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 * <p>
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 * <p>
 * 输入：s = "spo"
 * 输出："ops"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/11
 */
public class SortString {

    StringBuilder sb = new StringBuilder();

    int[] ans = new int[26];

    /**
     * 开一个长度为 26 的数组 h[]，作为用来计数的「桶」。
     * haveChar 的功能是在每次循环开始执行之前判断是否还有未使用的字符。
     * appendChar 的功能是检测当前位置的桶是否计数值为 0，如果不为 0 则修改目标串和计数值。
     *
     * @param s
     * @return
     */
    public String sortString(String s) {

        char[] chars = s.toCharArray();
        for (char c : chars) {
            ans[c - 'a'] += 1;
        }

        while (true) {

            if (!haveChar()) break;

            for (int i = 0; i < 26; i++) {
                appendChar(i);
            }

            for (int i = 25; i >= 0; i--) {
                appendChar(i);
            }
        }

        return sb.toString();
    }

    void appendChar(int p) {

        if (ans[p] > 0) {
            sb.append((char) (p + 'a'));
            ans[p] -= 1;
        }
    }

    boolean haveChar() {
        for (int i = 0; i < 26; i++) {
            if (ans[i] > 0) return true;
        }
        return false;
    }


}
