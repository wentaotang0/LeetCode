package algorithms.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author twt
 * @description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/04
 */
public class CharisUnique {

    /**
     * 使用额外空间
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (set.contains(c)) return false;
            set.add(c);
        }

        return true;
    }

}
