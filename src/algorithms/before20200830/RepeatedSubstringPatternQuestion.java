package algorithms.before20200830;

/**
 * @author twt
 * @description 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/08/25
 */
public class RepeatedSubstringPatternQuestion {

        public boolean repeatedSubstringPattern(String s) {
            if (s == null) return false;
            String str = s + s;
            //左闭右开
            return str.substring(1, str.length() - 1).contains(s);
        }

    public static void main(String[] args) {
        String s= "abab";
        RepeatedSubstringPatternQuestion r = new RepeatedSubstringPatternQuestion();
        System.out.println(r.repeatedSubstringPattern(s));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
