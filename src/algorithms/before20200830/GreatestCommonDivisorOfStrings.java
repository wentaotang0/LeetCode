package algorithms.before20200830;

/**
 * @author twt
 * @description 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/03/12
 */
public class GreatestCommonDivisorOfStrings {

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int length = gcd(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    /**
     *
     * 辗转相除法
     * 两个数的最大公约数等于较小的那个数和两个数相除余数的最大公约数
     * gcd(a,b) = gcd(b,a mod b) (不妨设a>b 且r=a mod b ,r不为0)
     *
     * 1997 / 615 = 3 (余 152)
     * 615 / 152 = 4(余7)
     * 152 / 7 = 21(余5)
     * 7 / 5 = 1 (余2)
     * 5 / 2 = 2 (余1)
     * 2 / 1 = 2 (余0)
     * 1为1997和615的最大公约数
     * @param l1
     * @param l2
     * @return
     */
    int gcd(int l1, int l2) {
        while (l2 > 0) {
            int rem = l1 % l2;
            l1 = l2;
            l2 = rem;
        }
        return l1;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings divisor = new GreatestCommonDivisorOfStrings();
        //System.out.println(divisor.gcdOfStrings("ABCABC", "ABC1"));
        System.out.println(divisor.gcdOfStrings("ABC", "ABCABC"));
    }
}
